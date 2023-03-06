package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.ImageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageControllerTest {

    @Mock
    private ImageService imageService;

    @InjectMocks
    private ImageController imageController;

    private String fileStorageLocation = "src/test/resources/";


    @Test
    @DisplayName("Should throw an exception when the file does not exist")
    void downLoadSingleFileWhenFileDoesNotExistThenThrowException() {
        String fileName = "test.txt";
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(imageService.downLoadFile(fileName))
                .thenThrow(new RuntimeException("the file doesn't exist or not readable"));

        assertThrows(
                RuntimeException.class,
                () -> imageController.downLoadSingleFile(fileName, request));
    }
}
