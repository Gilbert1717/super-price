package superPrice.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superPrice.orders.model.Order;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.repository.OrderRepository;

import javax.naming.directory.InvalidAttributesException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    public NewOrderResponse creatingOrder(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException {
        Order o = orderDTOConverter(order);
        return orderRepository.createOrderAndItems(o,orderItems);
    }

    private Order orderDTOConverter(NewOrderRequest order) throws InvalidAttributesException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Parse the string and convert it to a Date
            Date parsedDate = dateFormat.parse(order.getDeliverTime());

            // Convert the Date to a java.sql.Timestamp
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return new Order(timestamp,order.getDeliveryAddress());
        } catch (Exception e) {
            throw new InvalidAttributesException("invalid delivery date");
        }
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteOrderByOrderId(order.getId());
    }
}
