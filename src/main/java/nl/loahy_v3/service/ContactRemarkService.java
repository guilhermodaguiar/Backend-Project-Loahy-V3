package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.ContactRemarkDto;
import nl.loahy_v3.exceptions.NoEntityIdFoundException;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.mapper.ContactRemarkMapper;
import nl.loahy_v3.model.ContactRemark;
import nl.loahy_v3.record.ContactRemarkRequest;
import nl.loahy_v3.repository.ContactRemarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static nl.loahy_v3.mapper.ContactRemarkMapper.fromContactRemark;


@Service
@AllArgsConstructor
public class ContactRemarkService {

    private final ContactRemarkRepository contactRemarkRepository;

    public List<ContactRemarkDto> getAllContacts() {
        return contactRemarkRepository.findAll()
                .stream()
                .map(ContactRemarkMapper::fromContactRemark)
                .toList();
    }

    //maybe stream
    public List<ContactRemarkDto> getContactRemarkByEmail(String contactEmail) {
        return contactRemarkRepository.findAll()
                .stream()
                .filter(contactRemark -> contactRemark.getContactEmail().equalsIgnoreCase(contactEmail))
                .map(ContactRemarkMapper::fromContactRemark)
                .toList();
    }

    public ContactRemarkDto createRemark(ContactRemarkRequest request) {
        ContactRemark newRemark = new ContactRemark(
                request.contactName(),
                request.contactEmail(),
                request.contactPhone(),
                request.contactOrganisation(),
                request.contactRemark());
        contactRemarkRepository.save(newRemark);
        return fromContactRemark(newRemark);
    }


    public void deleteContactRemark(Long id) {
        if (!contactRemarkRepository.existsById(id)) {
            throw new NoEntityIdFoundException("opmerking van user id: " + id + " bestaat niet");
        }
        contactRemarkRepository.deleteById(id);
    }
}
