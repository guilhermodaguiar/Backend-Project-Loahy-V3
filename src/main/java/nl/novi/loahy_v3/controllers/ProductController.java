package nl.novi.loahy_v3.controllers;


import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.ProductInputDto;
import nl.novi.loahy_v3.models.FileUploadResponse;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductController {



    private final ProductService productService;

    private final ImageController imageController;


    @Autowired
    public ProductController(ProductService productService, ImageController imageController) {
        this.productService = productService;
        this.imageController = imageController;
    }

    @GetMapping
    @Transactional
    public List<ProductDto> getAllProducts() {
        var dtos = new ArrayList<ProductDto>();
        List<Product> productList;

        var products = productService.getAllProducts();
        for (Product product : products) {
            dtos.add(ProductDto.transferToDto(product));
        }

        return dtos;
    }

    @GetMapping(value = "/{id}")
    @Transactional
    public ProductDto getProductById(@PathVariable("id") Integer productId) {

        var product = productService.getProduct(productId);

        return ProductDto.transferToDto(product);
    }


    @PostMapping
    public ProductDto createProduct(@RequestBody @Valid ProductDto dto) {
        var product = productService.createProduct(dto.toProduct());

        return ProductDto.transferToDto(product);

    }

    @PutMapping(value = "/{id}")
    public ProductInputDto updateProduct(@PathVariable("id") Integer productId,
                                    @RequestBody @Valid ProductInputDto dto) {
        productService.updateProduct(productId, dto);

        return dto;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }


    @PostMapping(value = "/{id}/image")
    public void assignImageToProduct(@PathVariable("id") Integer productId,
                                     @RequestBody MultipartFile file) {

        FileUploadResponse productImage = imageController.singleFileUpload(file);

        productService.assignImageToProduct(productImage.getFileName(), productId);
    }
}
