package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.ContactRemarkDto;
import nl.novi.loahy_v3.models.ContactRemark;
import nl.novi.loahy_v3.repositories.ContactRemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactRemarkService {

    @Autowired
    private final ContactRemarkRepository contactRemarkRepository;

    @Autowired
    public ContactRemarkService(ContactRemarkRepository contactRemarkRepository) {
        this.contactRemarkRepository = contactRemarkRepository;
    }

    public List<ContactRemarkDto> getAllContacts() {
        List<ContactRemarkDto> collection = new ArrayList<>();
        List<ContactRemark> list = contactRemarkRepository.findAll();
        for (ContactRemark contactRemark : list) {
            collection.add(fromContact(contactRemark));
        }
        return collection;
    }


    public ContactRemarkDto getContactByEmail(String contactEmail) {
        new ContactRemarkDto();
        ContactRemarkDto contactRemarkDto;
        Optional<ContactRemark> contact = contactRemarkRepository.findById(contactEmail);
        if (contact.isPresent()) {
            contactRemarkDto = fromContact(contact.get());
        } else {
            throw new ContactNotFoundException(contactEmail);
        }
        return contactRemarkDto;
    }


    public String createRemark(ContactRemarkDto contactRemarkDto) {
        ContactRemark newContactRemark = contactRemarkRepository.save(toContact(contactRemarkDto));
        return newContactRemark.getContactName();
    }


    public void deleteContact(String contactEmail) {
        contactRemarkRepository.deleteById(contactEmail);
    }


    public static ContactRemarkDto fromContact(ContactRemark contactRemark) {

        var contactDto = new ContactRemarkDto();

        contactDto.contactName = contactRemark.getContactName();
        contactDto.contactEmail = contactRemark.getContactEmail();
        contactDto.contactOrganisation = contactRemark.getContactOrganisation();
        contactDto.contactPhone = contactRemark.getContactPhone();
        contactDto.contactRemark = contactRemark.getContactRemark();

        return contactDto;
    }

    public ContactRemark toContact(ContactRemarkDto contactRemarkDto) {

        var contact = new ContactRemark();

        contact.setContactName(contactRemarkDto.getContactName());
        contact.setContactPhone(contactRemarkDto.getContactPhone());
        contact.setContactEmail(contactRemarkDto.getContactEmail());
        contact.setContactOrganisation(contactRemarkDto.getContactOrganisation());
        contact.setContactRemark(contactRemarkDto.getContactRemark());

        return contact;
    }
}
