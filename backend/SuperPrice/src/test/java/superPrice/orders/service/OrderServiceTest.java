package superPrice.orders.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.orders.model.DTO.NewOrderRequest;
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
    void should_create_item() throws SQLException, InvalidAttributesException {
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








}