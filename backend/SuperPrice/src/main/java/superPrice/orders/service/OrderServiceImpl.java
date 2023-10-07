package superPrice.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superPrice.orders.model.DTO.*;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;
import superPrice.orders.repository.OrderRepository;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order creatingOrder(NewOrderRequest order) throws InvalidAttributesException {
        // Timestamp deliveryTime = converterOrderDeliveryTime(order.getDeliverTime());
        Order newOrder = new Order(order.getDeliverTime(),order.getDeliveryAddress(), order.getDeliveryType());
        Order order_with_id = orderRepository.createOrder(newOrder);
        return order_with_id;
    }

    @Override
    public NewOrderResponse creatingOrderAndItem(NewOrderRequest order, Collection<OrderItem> orderItems) throws InvalidAttributesException{
        Order o = creatingOrder(order);
        try{
            Collection<OrderItem> ois = this.orderRepository.createItems(o.getId(),orderItems);
            return new NewOrderResponse(ois,o);
        }
        catch (Exception e){
            deleteOrder(o.getId());
            throw new InvalidAttributesException("Error in creating order, wrong item information provided");
        }

    }
    @Override
    public Timestamp converterOrderDeliveryTime(String deliverTime) throws InvalidAttributesException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Parse the string and convert it to a Date
            Date parsedDate = dateFormat.parse(deliverTime);

            // Convert the Date to a java.sql.Timestamp
            Timestamp deliveryTime = new Timestamp(parsedDate.getTime());
            return deliveryTime;
        } catch (ParseException e) {
            throw new InvalidAttributesException("invalid delivery date format");
        }
    }


    @Override
    public void deleteOrder(long orderID) throws InvalidAttributesException {
        orderRepository.deleteOrderByOrderId(orderID);
    }


    @Override
    public Order getOrder(Long id) throws SQLException, InvalidAttributesException {
        return orderRepository.findOrderById(id);
    }


    @Override
    public FindOrderItemResponse findOrderItemByID(long orderID) throws SQLException, InvalidAttributesException {
        Order order = getOrder(orderID);
        FindOrderResponse orderResponse = new FindOrderResponse(order.getCreatingTime(),order.getDeliverTime(),order.getDeliveryType());
        Collection<FindItemResponse> itemsInOrder = this.orderRepository.getItemsInOrder(orderID);
        return new FindOrderItemResponse(orderResponse,itemsInOrder);
    }
}
