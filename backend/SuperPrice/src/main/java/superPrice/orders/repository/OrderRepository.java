package superPrice.orders.repository;

import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.util.Collection;

public interface OrderRepository {
    Order createOrder(Order order) throws InvalidAttributesException;
    void deleteOrderByOrderId(long order_id);
    NewOrderResponse createOrderAndItems(Order order, Collection<OrderItem> orderItems) throws InvalidAttributesException;
    Order findOrderById(long id) throws InvalidAttributesException, SQLException;

}
