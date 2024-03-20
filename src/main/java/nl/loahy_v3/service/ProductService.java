package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.repository.FileUploadRepository;
import nl.loahy_v3.repository.ProductRepository;
import nl.loahy_v3.dto.ProductInputDto;
import nl.loahy_v3.model.FileUploadResponse;
import nl.loahy_v3.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final FileUploadRepository uploadRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("Product is niet gevonden");
        }
    }

    public Product createProduct(Product product) {

        product.setProductId(product.getProductId());
        product.setProductName(product.getProductName());
        product.setProductDescription(product.getProductDescription());
        product.setProductPrice(product.getProductPrice());

        return productRepository.save(product);
    }


    public void updateProduct(Long productId, ProductInputDto dto) {

        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("product niet gevonden..");
        }

        Product product1 = productRepository.findById(productId).get();
        product1.setProductId(dto.getProductId());
        product1.setProductName(dto.getProductName());
        product1.setProductDescription(dto.getProductDescription());
        product1.setProductPrice(dto.getProductPrice());

        productRepository.save(product1);

    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("Product met id bestaat niet");
        }
        productRepository.deleteById(productId);
    }

    public void assignImageToProduct(String fileName, Long productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(fileName);

        if (optionalProduct.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse image = fileUploadResponse.get();
            Product product = optionalProduct.get();

            product.setImage(image);
            productRepository.save(product);
        } else {
            throw new RecordNotFoundException("product met id " + productId + " niet gevonden");
        }
    }
}

