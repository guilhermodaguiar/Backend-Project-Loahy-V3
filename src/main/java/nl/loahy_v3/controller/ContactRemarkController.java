package nl.loahy_v3.controller;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.ContactRemarkDto;
import nl.loahy_v3.record.ContactRemarkRequest;
import nl.loahy_v3.service.ContactRemarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/remark")
public class ContactRemarkController {

    private final ContactRemarkService contactRemarkService;

    @GetMapping
    public ResponseEntity<List<ContactRemarkDto>> getAllContacts() {
        List<ContactRemarkDto> contactRemarkDtos = contactRemarkService.getAllContacts();
        return ResponseEntity.ok().body(contactRemarkDtos);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<ContactRemarkDto>> getRemarkFromContact(@PathVariable("email") String contactEmail) {
        List<ContactRemarkDto> dto = contactRemarkService.getContactRemarkByEmail(contactEmail);
        return ResponseEntity.ok().body(dto);
    }


    @PostMapping
    public ResponseEntity<ContactRemarkDto> createRemark(@RequestBody @Valid ContactRemarkRequest request) {
        ContactRemarkDto dto = contactRemarkService.createRemark(request);
        return ResponseEntity.created(null).body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ContactRemarkDto> deleteContact(@PathVariable("id") Long id) {
        contactRemarkService.deleteContactRemark(id);
        return ResponseEntity.noContent().build();
    }
}
