package nl.novi.loahy_v3.models;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "image")
public class FileUploadResponse {

    @Id
    String fileName;
    String contentType;
    String url;

    public FileUploadResponse(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public FileUploadResponse() {
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
