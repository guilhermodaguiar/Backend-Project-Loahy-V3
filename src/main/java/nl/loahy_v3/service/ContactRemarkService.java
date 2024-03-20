package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.ContactRemarkDto;
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
    public ContactRemarkDto getContactRemarkByEmail(String contactEmail) {
        Optional<ContactRemark> remark = contactRemarkRepository.findAllByEmail(contactEmail);
        if (remark.isPresent()) {
            return fromContactRemark(remark.get());
        } else {
            throw new RecordNotFoundException(contactEmail);
        }
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


    public void deleteContact(Long id) {
        if (!contactRemarkRepository.existsById(id)) {
            throw new RecordNotFoundException("opmerking van user met email bestaat niet");
        }
        contactRemarkRepository.deleteById(id);
    }
}
