package superPrice.orders.service;

import superPrice.orders.model.Order;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;

import javax.naming.directory.InvalidAttributesException;
import java.util.Collection;

public interface OrderService {
    NewOrderResponse creatingOrder(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException;

    void deleteOrder(Order order);
}
