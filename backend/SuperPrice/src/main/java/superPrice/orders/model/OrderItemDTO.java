package superPrice.orders.model;

import java.util.Collection;

public class OrderItemDTO {
    private Collection<OrderItem> orderItems;
    private Order order;

    public OrderItemDTO(Collection<OrderItem> orderItems, Order order) {
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
