package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.CompanyInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.persistence.EntityNotFoundException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CompanyInfoControllerTest {

    @Mock
    private CompanyInfoService companyInfoService;

    @InjectMocks
    private CompanyInfoController companyInfoController;

    @Test@DisplayName("Should throw an exception when the company name does not exist")
    void getCompanyinformationWhenNameIsInvalidThenThrowException() {
        String name = "test";
        when(companyInfoService.getCompanyInfo(name))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(
                EntityNotFoundException.class,
                () -> companyInfoController.getCompanyInfo(name));

        verify(companyInfoService, times(1)).getCompanyInfo(name);

    }

}
