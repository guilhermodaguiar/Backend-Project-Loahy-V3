package nl.loahy_v3.record;

import nl.loahy_v3.model.Product;

import java.util.Set;

public record WishlistRequest(
        Long wishlistId,
        Set<Product> products) {
}
