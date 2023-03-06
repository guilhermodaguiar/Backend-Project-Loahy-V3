package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ContactRemarkDto;
import nl.novi.loahy_v3.services.ContactRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/contact-remarks")
public class ContactRemarkController {

    @Autowired
    private final ContactRemarkService contactRemarkService;

    @Autowired
    public ContactRemarkController(ContactRemarkService contactRemarkService) {
        this.contactRemarkService = contactRemarkService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ContactRemarkDto>> getAllContacts() {

        List<ContactRemarkDto> contactRemarkDtos = contactRemarkService.getAllContacts();

        return ResponseEntity.ok().body(contactRemarkDtos);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<ContactRemarkDto> createRemark(@RequestBody ContactRemarkDto contactRemarkDto) {

        final String createdContact = contactRemarkService.createRemark(contactRemarkDto);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{contactName}")
                .buildAndExpand(createdContact).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(value = "/delete/{email}")
    public ResponseEntity<ContactRemarkDto> deleteContact(@PathVariable("email") String contactEmail) {
        contactRemarkService.deleteContact(contactEmail);
        return ResponseEntity.noContent().build();
    }

}
