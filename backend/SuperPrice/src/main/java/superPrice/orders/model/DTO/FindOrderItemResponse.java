package superPrice.orders.model.DTO;

import java.util.Collection;

public class FindOrderItemResponse {
    private final FindOrderResponse order;
    private final Collection<FindItemResponse> orderItems;

    public FindOrderItemResponse(FindOrderResponse order, Collection<FindItemResponse> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public FindOrderResponse getOrder() {
        return order;
    }

    public Collection<FindItemResponse> getOrderItems() {
        return orderItems;
    }
}
