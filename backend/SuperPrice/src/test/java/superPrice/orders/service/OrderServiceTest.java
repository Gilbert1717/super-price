package superPrice.orders.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.orders.model.DTO.*;
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
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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
        NewOrderRequest request = new NewOrderRequest(deliverTime,"testing address","Express",ois);

        // mock repository
        Timestamp convertedDeliverTime = this.orderService.converterOrderDeliveryTime(request.getDeliverTime());
        ArgumentCaptor<Order> order = ArgumentCaptor.forClass(Order.class);
        when(this.orderRepository.createOrder(order.capture())).thenReturn(new Order(1L,timestampNow, convertedDeliverTime,"testing address","Express"));

        // testing method
        Order createdOrder = this.orderService.creatingOrder(request);

        assertEquals(convertedDeliverTime,order.getValue().getDeliverTime());

        assertEquals(convertedDeliverTime, createdOrder.getDeliverTime());
        assertEquals("testing address", createdOrder.getDeliveryAddress());
        assertEquals("Express", createdOrder.getDeliveryType());
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
        NewOrderRequest request = new NewOrderRequest(deliverTime,"testing address","Express",ois);

        // mock repository
        Timestamp convertedDeliverTime = this.orderService.converterOrderDeliveryTime(request.getDeliverTime());
        ArgumentCaptor<Order> order = ArgumentCaptor.forClass(Order.class);
        when(this.orderRepository.createOrder(order.capture())).thenReturn(new Order(1L,timestampNow, convertedDeliverTime,"testing address","Express"));

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
        assertEquals("Express", response.getOrder().getDeliveryType());

        assertEquals("5369979017",oi.getBarcode());
        assertEquals(104, oi.getStoreId());
        assertEquals(2, oi.getQuantity());
    }
    @Test
    void should_throw_exception_creat_order_items() throws InvalidAttributesException {
        // generating new order request
        Instant utcNow = Instant.now();
        Timestamp timestampNow = Timestamp.from(utcNow);
        Instant testingTime = utcNow.now().plus(2, ChronoUnit.DAYS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String deliverTime = formatter.format(testingTime);
        Collection<OrderItem> ois = new ArrayList<>();
        NewOrderRequest request = new NewOrderRequest(deliverTime,"testing address","Express",ois);

        // mock repository
        Timestamp convertedDeliverTime = this.orderService.converterOrderDeliveryTime(request.getDeliverTime());
        ArgumentCaptor<Order> order = ArgumentCaptor.forClass(Order.class);
        when(this.orderRepository.createOrder(order.capture())).thenReturn(new Order(1L,timestampNow, convertedDeliverTime,"testing address","Express"));



        ArgumentCaptor<Collection<OrderItem>> orderItemsCaptor = ArgumentCaptor.forClass(Collection.class);
        when(this.orderRepository.createItems(eq(1L),orderItemsCaptor.capture())).thenThrow(InvalidAttributesException.class);


        // testing method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderService.creatingOrderAndItem(request,ois));
        String expectedMessage = "Error in creating order, wrong item information provided";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void should_converter_string_to_timeStamp() throws InvalidAttributesException {
        String deliverTime = "2023-10-30 10:30:20";
        Timestamp testTime = this.orderService.converterOrderDeliveryTime(deliverTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String originalDeliverTime = formatter.format(testTime.toInstant());
        assertEquals(deliverTime,originalDeliverTime);
    }

    @Test
    void should_fail_to_convert() {
        String deliverTime = "2023-10-30";
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderService.converterOrderDeliveryTime(deliverTime));
        String expectedMessage = "invalid delivery date format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDeleteOrder() throws InvalidAttributesException {
        // Arrange
        long orderIdToDelete = 123L;

        // Act
        assertDoesNotThrow(() -> orderService.deleteOrder(orderIdToDelete));

        // Assert
        ArgumentCaptor<Long> orderIdCaptor = ArgumentCaptor.forClass(Long.class);
        verify(orderRepository).deleteOrderByOrderId(orderIdCaptor.capture());

        Long capturedOrderId = orderIdCaptor.getValue();
        assertEquals(orderIdToDelete, capturedOrderId);
    }


    @Test
    void test_Get_Order() throws SQLException, InvalidAttributesException {
        // Arrange
        long orderId = 1L;
        Instant utcNow = Instant.now();
        Timestamp timestampNow = Timestamp.from(utcNow);
        Instant testingTime = utcNow.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // mock repository

        Order expectedOrder = new Order(1L,timestampNow, deliverTimestamp,"testing address","Express");
        when(orderRepository.findOrderById(orderId)).thenReturn(expectedOrder);

        // Act
        Order actualOrder = orderService.getOrder(orderId);

        // Assert
        assertEquals(expectedOrder, actualOrder);
        verify(orderRepository).findOrderById(orderId);
    }


    @Test
    void testFindOrderItemByID() throws SQLException, InvalidAttributesException {
        // Arrange
        long orderId = 1L;
        Instant utcNow = Instant.now();
        Timestamp timestampNow = Timestamp.from(utcNow);
        Instant testingTime = utcNow.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // mock repository
        FindOrderResponse orderResponse = new FindOrderResponse(timestampNow, deliverTimestamp,"Express");
        Order order = new Order(1L,timestampNow, deliverTimestamp,"testing address","Express");
        FindOrderResponse expectedOrderResponse = new FindOrderResponse(orderResponse.getCreatingTime(), orderResponse.getDeliverTime(), orderResponse.getDeliveryType());
        Collection<FindItemResponse> expectedItemsInOrder = Arrays.asList(
                new FindItemResponse("Digital Camera","Sports Store", 2, 240.6),
                new FindItemResponse("Digital Camera","Jewelry Store", 2, 835.86)
        );

        when(orderRepository.getItemsInOrder(orderId)).thenReturn(expectedItemsInOrder);
        when(orderRepository.findOrderById(orderId)).thenReturn(order);

        // Act
        FindOrderItemResponse result = orderService.findOrderItemByID(orderId);

        // Assert
        assertNotNull(result);
        assertEquals(deliverTimestamp, result.getOrder().getDeliverTime());
        assertEquals("Express", result.getOrder().getDeliveryType());
        assertEquals(timestampNow, result.getOrder().getCreatingTime());
        assertEquals(expectedItemsInOrder, result.getOrderItems());
        verify(orderRepository).findOrderById(orderId);
        verify(orderRepository).getItemsInOrder(orderId);
    }




}