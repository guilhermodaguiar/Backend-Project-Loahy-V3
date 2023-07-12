package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.repositories.FileUploadRepository;
import nl.novi.loahy_v3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final FileUploadRepository uploadRepository;


    @Autowired
    public ProductService(ProductRepository productRepository, FileUploadRepository uploadRepository) {
        this.productRepository = productRepository;
        this.uploadRepository = uploadRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer productId) {
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


    public void updateProduct(Product product) {

        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());

        if (optionalProduct.isEmpty()) {
            throw new RecordNotFoundException("product niet gevonden..");
        } else {

            Product product1 = optionalProduct.get();
            product1.setProductId(product.getProductId());
            product1.setProductName(product.getProductName());
            product1.setProductDescription(product.getProductDescription());
            product1.setProductPrice(product.getProductPrice());

            productRepository.save(product1);

        }
    }

    public void deleteProduct(Integer productId) {
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("Product met id bestaat niet");
        }
        productRepository.deleteById(productId);
    }

    public void assignImageToProduct(String fileName, Integer productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(fileName);

        if (optionalProduct.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse image = fileUploadResponse.get();
            Product product = optionalProduct.get();

            product.setImage(image);
            productRepository.save(product);
        } else {
            throw new RecordNotFoundException();
        }
    }
}

