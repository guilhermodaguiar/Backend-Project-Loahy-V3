package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Product;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.ProductRepository;
import nl.novi.loahy_v3.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WishlistService {
    @Autowired
    private final WishlistRepository wishlistRepository;

    @Autowired
    private final ProductRepository productRepository;


    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ProductRepository productRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public Wishlist getWishlistById(Integer wishlistId) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(wishlistId);

        if (wishlistOptional.isPresent()) {
            return wishlistOptional.get();
        } else {
            throw new RecordNotFoundException("wishlist met id niet gevonden");
        }
    }

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }



    public Wishlist assignProductToWishlist(Integer wishlistId, Integer productId) {
        Set<Product> productSet;
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("Wishlist met id bestaat niet" );
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("Product met id bestaat niet" );
        }
        Product product = productRepository.findById(productId).get();
        productSet =  wishlist.getProducts();
        productSet.add(product);
        wishlist.setProducts(productSet);
        return wishlistRepository.save(wishlist);
    }

    public Wishlist removeProductFromWishlist(Integer wishlistId, Integer productId) {
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("Wishlist met id bestaat niet" );
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("Product met id bestaat niet" );
        }
        Product product = productRepository.findById(productId).get();

        wishlist.getProducts().remove(product);
        return wishlistRepository.save(wishlist);
    }
}