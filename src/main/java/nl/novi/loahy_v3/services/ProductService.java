package nl.novi.loahy_v3.services;


import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.ProductInputDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.repositories.FileUploadRepository;
import nl.novi.loahy_v3.repositories.ProductRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.ProductDto.transferToDto;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FileUploadRepository uploadRepository;

    private final WishlistRepository wishlistRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FileUploadRepository uploadRepository, WishlistRepository wishlistRepository) {
        this.productRepository = productRepository;
        this.uploadRepository = uploadRepository;
        this.wishlistRepository = wishlistRepository;
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
        }
    }

    public Product transferToProduct(ProductDto dto) {

        var product = new Product();

        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductPrice(dto.getProductPrice());
        product.setImage(dto.getImage());
        return product;
    }

    public void assignWishlistToProduct(Integer productId, Integer wishlistId) {
        var optionalProduct = productRepository.findById(productId);
        var optionalWishlist = wishlistRepository.findById(wishlistId);

        if(optionalProduct.isPresent() && optionalWishlist.isPresent()) {
            var product = optionalProduct.get();
            var wishlist = optionalWishlist.get();

            product.setWishlist(wishlist);
            productRepository.save(product);
        } else {
            throw new RecordNotFoundException();
        }
    }
}

