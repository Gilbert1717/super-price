package superPrice.orders.service;

import superPrice.orders.model.Order;
import superPrice.orders.model.OrderDTO;

import javax.naming.directory.InvalidAttributesException;

public interface OrderService {
    Order creatingOrder(OrderDTO order) throws InvalidAttributesException;

    void deleteOrder(Order order);
}
