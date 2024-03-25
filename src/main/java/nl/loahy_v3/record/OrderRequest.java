package nl.loahy_v3.record;

import java.util.List;

public record OrderRequest(
        Long orderId,
        List<Object>productList,
        String comment,
        Long addressId,
        String orderDate) {
}
