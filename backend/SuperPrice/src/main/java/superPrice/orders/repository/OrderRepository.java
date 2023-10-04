package superPrice.orders.repository;

import superPrice.orders.model.DTO.FindItemResponse;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.util.Collection;

public interface OrderRepository {
    Order createOrder(Order order) throws InvalidAttributesException;
    void deleteOrderByOrderId(long order_id) throws InvalidAttributesException;
    Order findOrderById(long id) throws InvalidAttributesException, SQLException;
    Collection<OrderItem> createItems(long orderID, Collection<OrderItem> orderItems) throws InvalidAttributesException;
    Collection<FindItemResponse> getItemsInOrder(long orderID) throws InvalidAttributesException;

}
