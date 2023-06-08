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

    public List<ProductDto> getAllProducts() {
        List<ProductDto> collection = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for (Product product : list) {
            collection.add(transferToDto(product));
        }
        return collection;
    }

    public ProductDto getProduct(Integer productId) {
        new ProductDto();
        ProductDto productDto;
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productDto = transferToDto(product.get());
        } else {
            throw new RecordNotFoundException("Product niet gevonden");
        }
        return productDto;
    }

    public ProductDto createProduct(ProductInputDto inputDto) {

        Product newProduct = transferToProduct(inputDto);

        productRepository.save(newProduct);

        return transferToDto(newProduct);
    }


    public ProductDto updateProduct(Integer productId, ProductInputDto inputDto) {
        if (productRepository.findById(productId).isPresent()) {

            Product product = productRepository.findById(productId).get();

            Product product1 = transferToProduct(inputDto);
            product1.setProductId(product.getProductId());

            productRepository.save(product1);

            return transferToDto(product1);
        } else {
            throw new RecordNotFoundException("Product niet gevonden");
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

    public Product transferToProduct(ProductInputDto productDto) {

        var product = new Product();

        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductInformation());
        product.setProductPrice(productDto.getProductPrice());
        product.setImage(productDto.getImage());
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

