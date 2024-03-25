package nl.loahy_v3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
public class FileUploadResponse {

    @Id
    @GeneratedValue(generator = "sequence_generator")
    @GenericGenerator(
            name = "sequence_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "image_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "26"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    Long imageId;
    String fileName;
    String contentType;
    String url;

    @Setter
    @OneToOne
    @JoinColumn(name = "fk_product_id")
    Product product;

    public FileUploadResponse(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }
}
