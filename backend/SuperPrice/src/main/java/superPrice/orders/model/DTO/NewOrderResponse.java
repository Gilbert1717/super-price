package superPrice.orders.model.DTO;

import org.springframework.http.ResponseEntity;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;

import java.util.Collection;

public class NewOrderResponse {
    private Collection<OrderItem> orderItems;
    private Order order;

    public NewOrderResponse(Collection<OrderItem> orderItems, Order order) {
        this.orderItems = orderItems;
        this.order = order;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order getOrder() {
        return order;
    }

}
