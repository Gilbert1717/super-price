package superPrice.orders.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderDTO;
import superPrice.orders.repository.OrderRepository;
import superPrice.storePrice.repository.price.PriceRepository;

import javax.naming.directory.InvalidAttributesException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    public Order creatingOrder(OrderDTO order) throws InvalidAttributesException {
        Order o = orderDTOConverter(order);
//        orderRepository.create()
        return o;
    }

    private Order orderDTOConverter(OrderDTO order) throws InvalidAttributesException {
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
