package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.repository.ProductRepository;
import nl.loahy_v3.repository.WishlistRepository;
import nl.loahy_v3.model.Product;
import nl.loahy_v3.model.Wishlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public Wishlist getWishlistById(Integer wishlistId) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(wishlistId);
        if (wishlistOptional.isPresent()) {
            return wishlistOptional.get();
        } else {
            throw new RecordNotFoundException("wishlist met id " + wishlistId+ "niet gevonden");
        }
    }

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }


    public Wishlist assignProductToWishlist(Integer wishlistId, Integer productId) {
        Set<Product> productSet;
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("wishlist met id " + wishlistId+ " bestaat niet");
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("product met id  "+productId+ " bestaat niet");
        }
        Product product = productRepository.findById(productId).get();
        productSet = wishlist.getProducts();
        productSet.add(product);
        wishlist.setProducts(productSet);
        return wishlistRepository.save(wishlist);
    }

    public void removeProductFromWishlist(Integer wishlistId, Integer productId) {
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RecordNotFoundException("Wishlist met id " + wishlistId+" bestaat niet");
        }
        Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("product met id  "+productId+ " bestaat niet");
        }
        Product product = productRepository.findById(productId).get();

        wishlist.getProducts().remove(product);
        wishlistRepository.save(wishlist);
    }
}