package nl.loahy_v3.record;

public record ProductRequest(
        Long productId,
        String productName,
        String productDescription,
        Double productPrice
) {

}
