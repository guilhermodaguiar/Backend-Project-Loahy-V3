package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.ProductDto;
import nl.novi.loahy_v3.dtos.WishlistDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.*;
import nl.novi.loahy_v3.repositories.ProductRepository;
import nl.novi.loahy_v3.repositories.WishlistProductRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class WishlistProductService {

    private final WishlistRepository wishlistRepository;

    private final ProductRepository productRepository;

    private final WishlistProductRepository wishlistProductRepository;

    @Autowired
    public WishlistProductService(WishlistRepository wishlistRepository, ProductRepository productRepository,
                                  WishlistProductRepository wishlistProductRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
        this.wishlistProductRepository = wishlistProductRepository;
    }


    public Collection<ProductDto> getWishlistProductsByWishlistId(Integer wishlistId) {
        Collection<ProductDto> productDtos = new HashSet<>();
        Collection<WishlistProduct> wishlistProducts = wishlistProductRepository.findAllByWishlist_WishlistId(wishlistId);
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            Product product = wishlistProduct.getProduct();
            var productDto = new ProductDto();

            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductInformation(product.getProductDescription());
            productDto.setProductPrice(product.getProductPrice());
            productDto.setImage(product.getImage());

            productDtos.add(productDto);
        }
        return productDtos;
    }


    public void addWishlistProduct(Integer wishlistId, Integer productId) {
        var wishlistProduct = new WishlistProduct();
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("wishlist id niet gevonden");
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("product id niet gevonden");
        }
        Product product = productRepository.findById(productId).orElse(null);
        wishlistProduct.setWishlist(wishlist);
        wishlistProduct.setProduct(product);

        WishlistProductKey id = new WishlistProductKey(wishlistId, productId);
        wishlistProduct.setId(id);
        wishlistProductRepository.save(wishlistProduct);
    }

    public Collection<ProductDto> deleteWishlistProduct(Integer wishlistId, Integer productId) {
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("wishlist id niet gevonden");
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElse(null);
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("product id niet gevonden");
        }
        Collection<ProductDto> productDtos = new HashSet<>();
        Collection<WishlistProduct> wishlistProducts = wishlistProductRepository.findAllByWishlist_WishlistId(wishlistId);
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            Product product = wishlistProduct.


        }
        return productDtos;


//        Collection <WishlistProduct> product1 = wishlistProductRepository.findWishlistProductBy(productId);
//        Product productToRemove = product1.getProducts()
//
//
//        User user = userRepository.findById(username).get();
//        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
//        user.removeAuthority(authorityToRemove);
//        userRepository.save(user);

    }

}
