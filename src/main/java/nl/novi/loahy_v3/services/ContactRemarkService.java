package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.ContactRemark;
import nl.novi.loahy_v3.repositories.ContactRemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static nl.novi.loahy_v3.dtos.ContactRemarkDto.fromContact;

@Service
public class ContactRemarkService {

    @Autowired
    private final ContactRemarkRepository contactRemarkRepository;

    @Autowired
    public ContactRemarkService(ContactRemarkRepository contactRemarkRepository) {
        this.contactRemarkRepository = contactRemarkRepository;
    }

    public List<nl.novi.loahy_v3.dtos.ContactRemarkDto> getAllContacts() {
        List<nl.novi.loahy_v3.dtos.ContactRemarkDto> collection = new ArrayList<>();
        List<ContactRemark> list = contactRemarkRepository.findAll();
        for (ContactRemark contactRemark : list) {
            collection.add(fromContact(contactRemark));
        }
        return collection;
    }


    public String createRemark(nl.novi.loahy_v3.dtos.ContactRemarkDto contactRemarkDto) {
        var contact = new ContactRemark();

        contact.setContactName(contactRemarkDto.getContactName());
        contact.setContactPhone(contactRemarkDto.getContactPhone());
        contact.setContactEmail(contactRemarkDto.getContactEmail());
        contact.setContactOrganisation(contactRemarkDto.getContactOrganisation());
        contact.setContactRemark(contactRemarkDto.getContactRemark());

        ContactRemark newContactRemark = contactRemarkRepository.save(contact);
        return newContactRemark.getContactName();
    }


    public void deleteContact(String contactEmail) {
        if (!contactRemarkRepository.existsById(contactEmail)) {
            throw new RecordNotFoundException("opmerking van user met email bestaat niet" );
        }
        contactRemarkRepository.deleteById(contactEmail);
    }
}
