package superPrice.orders.model.DTO;

import superPrice.orders.model.Order;

import java.util.Collection;

public class FindOrderItemResponse {
    private FindOrderResponse order;
    private Collection<FindItemResponse> findItemResponse;

    public FindOrderItemResponse(FindOrderResponse order, Collection<FindItemResponse> findItemResponse) {
        this.order = order;
        this.findItemResponse = findItemResponse;
    }

    public FindOrderResponse getOrder() {
        return order;
    }

    public Collection<FindItemResponse> getFindItemResponse() {
        return findItemResponse;
    }
}
