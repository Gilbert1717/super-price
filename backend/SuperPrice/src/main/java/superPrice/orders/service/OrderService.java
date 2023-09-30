package superPrice.orders.service;

import org.springframework.http.ResponseEntity;
import superPrice.orders.model.Order;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.util.Collection;

public interface OrderService {
    NewOrderResponse creatingOrder(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException, SQLException;

    void deleteOrder(Order order);
    Order getOrder(Long id) throws SQLException, InvalidAttributesException;
}
