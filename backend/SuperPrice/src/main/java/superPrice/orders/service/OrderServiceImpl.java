package superPrice.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superPrice.orders.model.Order;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.repository.OrderRepository;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    public NewOrderResponse creatingOrder(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException, SQLException {
        Order o = orderDTOConverter(order);
        return orderRepository.createOrderAndItems(o,orderItems);
    }

    private Order orderDTOConverter(NewOrderRequest order) throws InvalidAttributesException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Parse the string and convert it to a Date
            Date parsedDate = dateFormat.parse(order.getDeliverTime());

            // Convert the Date to a java.sql.Timestamp
            Timestamp deliveryTime = new Timestamp(parsedDate.getTime());
            if(!deliveryTimeValidation(parsedDate.toInstant())){
                throw new InvalidAttributesException("invalid delivery date");
            }

            return new Order(deliveryTime,order.getDeliveryAddress(),order.getDeliveryType());
        } catch (ParseException e) {
            throw new InvalidAttributesException("invalid delivery date format");
        }
    }

    private boolean deliveryTimeValidation(Instant t1){
        boolean valid_delivery_time = false;
        Instant utcNow = Instant.now();
        long diff = utcNow.until(t1, ChronoUnit.DAYS);
        if (diff >= 1) {
            valid_delivery_time = true;
        }
        return valid_delivery_time;
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteOrderByOrderId(order.getId());
    }
}
