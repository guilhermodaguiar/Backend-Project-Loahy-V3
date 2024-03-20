package nl.loahy_v3.controller;


import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.ProductDto;
import nl.loahy_v3.dto.ProductInputDto;
import nl.loahy_v3.model.FileUploadResponse;
import nl.loahy_v3.model.Product;
import nl.loahy_v3.service.ProductService;
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
@AllArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    private final ImageController imageController;


    @GetMapping
    @Transactional
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        var dtos = new ArrayList<ProductDto>();
        List<Product> productList;
        var products = productService.getAllProducts();
        for (Product product : products) {
            dtos.add(ProductDto.transferToDto(product));
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        var product = productService.getProduct(productId);
        return ResponseEntity.ok().body(ProductDto.transferToDto(product));
    }


    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto dto) {
        var product = productService.createProduct(dto.toProduct());
        return ResponseEntity.created(null).body(ProductDto.transferToDto(product));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductInputDto> updateProduct(@PathVariable("id") Long productId,
                                                         @RequestBody @Valid ProductInputDto dto) {
        productService.updateProduct(productId, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/image")
    public void assignImageToProduct(@PathVariable("id") Long productId,
                                     @Valid @RequestBody MultipartFile file) {
        FileUploadResponse productImage = imageController.singleFileUpload(file);
        productService.assignImageToProduct(productImage.getFileName(), productId);
    }
}
