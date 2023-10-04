package superPrice.orders.service;

import superPrice.orders.model.DTO.FindOrderItemResponse;
import superPrice.orders.model.Order;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

public interface OrderService {
    Order creatingOrder(NewOrderRequest order) throws InvalidAttributesException, SQLException;
    NewOrderResponse creatingOrderAndItem(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException, SQLException;

    void deleteOrder(long orderID) throws InvalidAttributesException;
    Order getOrder(Long id) throws SQLException, InvalidAttributesException;
    Timestamp converterOrderDeliveryTime(String deliverTime) throws InvalidAttributesException;
    FindOrderItemResponse findOrderItemByID(long orderID) throws SQLException, InvalidAttributesException;
}
