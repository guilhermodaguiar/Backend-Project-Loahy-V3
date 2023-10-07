package nl.novi.loahy_v3.models;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "image")
public class FileUploadResponse {

    @Getter
    @Id
    String fileName;
    String contentType;
    String url;


    @OneToOne
    Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    public FileUploadResponse(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public FileUploadResponse() {
    }
}
