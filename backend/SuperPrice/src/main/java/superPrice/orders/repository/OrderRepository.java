package superPrice.orders.repository;

import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;

import java.util.Collection;

public interface OrderRepository {
    Order createOrder(Order order);
    void deleteOrderByOrderId(long order_id);
    NewOrderResponse createOrderAndItems(Order order, Collection<OrderItem> orderItems);

}
