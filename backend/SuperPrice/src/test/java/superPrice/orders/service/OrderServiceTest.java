package superPrice.orders.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;
import superPrice.orders.repository.OrderRepository;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTest {
    OrderService orderService;
    OrderRepository orderRepository;
    @BeforeEach
    void setUp() {
        this.orderRepository =mock(OrderRepository.class);
        this.orderService = new OrderServiceImpl(this.orderRepository);
    }


    @Test
    void should_create_order() throws SQLException, InvalidAttributesException {
        // generating new order request
        Instant utcNow = Instant.now();
        Timestamp timestampNow = Timestamp.from(utcNow);
        Instant testingTime = utcNow.now().plus(2, ChronoUnit.DAYS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String deliverTime = formatter.format(testingTime);
        Collection<OrderItem> ois = new ArrayList<>();
        NewOrderRequest request = new NewOrderRequest(deliverTime,"testing address","express",ois);

        // mock repository
        Timestamp convertedDeliverTime = this.orderService.converterOrderDeliveryTime(request.getDeliverTime());
        ArgumentCaptor<Order> order = ArgumentCaptor.forClass(Order.class);
        when(this.orderRepository.createOrder(order.capture())).thenReturn(new Order(1L,timestampNow, convertedDeliverTime,"testing address","express"));

        // testing method
        Order createdOrder = this.orderService.creatingOrder(request);

        assertEquals(convertedDeliverTime,order.getValue().getDeliverTime());

        assertEquals(convertedDeliverTime, createdOrder.getDeliverTime());
        assertEquals("testing address", createdOrder.getDeliveryAddress());
        assertEquals("express", createdOrder.getDeliveryType());
    }

    @Test
    void should_create_order_items() throws SQLException, InvalidAttributesException {
        // generating new order request
        Instant utcNow = Instant.now();
        Timestamp timestampNow = Timestamp.from(utcNow);
        Instant testingTime = utcNow.now().plus(2, ChronoUnit.DAYS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String deliverTime = formatter.format(testingTime);
        Collection<OrderItem> ois = new ArrayList<>();
        NewOrderRequest request = new NewOrderRequest(deliverTime,"testing address","express",ois);

        // mock repository
        Timestamp convertedDeliverTime = this.orderService.converterOrderDeliveryTime(request.getDeliverTime());
        ArgumentCaptor<Order> order = ArgumentCaptor.forClass(Order.class);
        when(this.orderRepository.createOrder(order.capture())).thenReturn(new Order(1L,timestampNow, convertedDeliverTime,"testing address","express"));

        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",109,2));

        ArgumentCaptor<Collection<OrderItem>> orderItemsCaptor = ArgumentCaptor.forClass(Collection.class);
        when(this.orderRepository.createItems(eq(1L),orderItemsCaptor.capture())).thenReturn(orderItems);


        // testing method
        NewOrderResponse response = this.orderService.creatingOrderAndItem(request,orderItems);
        OrderItem oi = (OrderItem)response.getOrderItems().toArray()[0];

        assertEquals(convertedDeliverTime,order.getValue().getDeliverTime());
        assertEquals(convertedDeliverTime, response.getOrder().getDeliverTime());
        assertEquals("testing address", response.getOrder().getDeliveryAddress());
        assertEquals("express", response.getOrder().getDeliveryType());

        assertEquals("5369979017",oi.getBarcode());
        assertEquals(104, oi.getStoreId());
        assertEquals(2, oi.getQuantity());
    }








}