package nl.loahy_v3.controller;

import nl.loahy_v3.service.ContactRemarkService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ContactRemarkControllerTest {

    @Mock
    private ContactRemarkService contactRemarkService;

    @InjectMocks
    private ContactRemarkController contactRemarkController;




}
