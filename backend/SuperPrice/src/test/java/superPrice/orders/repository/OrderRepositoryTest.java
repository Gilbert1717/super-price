package superPrice.orders.repository;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.orders.model.DTO.FindItemResponse;
import superPrice.orders.model.DTO.FindOrderResponse;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;

import javax.naming.directory.InvalidAttributesException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private Flyway flyway;

    @Autowired
    DataSource source;

    OrderRepository orderRepository;
    @BeforeEach
    void setUp() {
        flyway.migrate();
        orderRepository = new OrderRepositoryImpl(source);
    }

    @AfterEach
    void tearDown() {
        flyway.clean();
    }



    @Test
    void should_create_items() throws InvalidAttributesException {
        //create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // run the method
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));
        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",109,2));

        // run the method
        Collection<OrderItem> ois = this.orderRepository.createItems(order.getId(),orderItems);
        OrderItem oi = (OrderItem)ois.toArray()[0];
        // check information in items
        assertEquals(1,oi.getOrderId());
        assertEquals("5369979017",oi.getBarcode());
        assertEquals(104,oi.getStoreId());
        assertEquals(2,oi.getQuantity());
    }

    @Test
    void create_items_throws_exception_due_to_foreign_key() throws InvalidAttributesException {

        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",109,2));
        // run the method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.createItems((long)1,orderItems));
        String expectedMessage = "Error in creating order items, wrong item information provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void create_item_throws_exception_due_to_item_pk() throws InvalidAttributesException {

        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",104,2));
        // run the method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.createItems((long)1,orderItems));
        String expectedMessage = "Error in creating order items, wrong item information provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



    @Test
    void should_create_an_order() throws InvalidAttributesException, SQLException {
        // create dummy order for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // run the method
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));

        // check all the information in the dummy order with the order created in the database
        assertEquals(deliverTimestamp, order.getDeliverTime());
        assertEquals("testing address", order.getDeliveryAddress());
        assertEquals("express", order.getDeliveryType());
        assertNotNull(order.getId());
        assertNotNull(order.getCreatingTime());
        assertDoesNotThrow(()->this.orderRepository.findOrderById(order.getId()));
        assertNotNull(this.orderRepository.findOrderById(order.getId()));
    }
    @Test
    void deleteOrderByOrderId() throws InvalidAttributesException {
        // create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);
        // create order
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));

        // run delete method
        this.orderRepository.deleteOrderByOrderId(order.getId());
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.findOrderById(order.getId()));

        String expectedMessage = "Error in find order Id";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete_order_throws_exception() throws InvalidAttributesException {

        // run delete method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.deleteOrderByOrderId(22));

        String expectedMessage = "Error in deleting order";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void find_order_throws_exception() throws InvalidAttributesException {

        // run find order method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.findOrderById(22));

        String expectedMessage = "Error in find order Id";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void find_order_test() throws InvalidAttributesException, SQLException {

        // run delete method
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // Create order
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));

        // Test method
        Order order_found = this.orderRepository.findOrderById(order.getId());
        assertEquals(deliverTimestamp, order_found.getDeliverTime());
        assertEquals("testing address", order_found.getDeliveryAddress());
        assertEquals("express", order_found.getDeliveryType());
    }

    @Test
    void find_items_in_order_test() throws InvalidAttributesException {

        // run delete method
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // Create order
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));

        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",109,2));

        // run the method
        Collection<OrderItem> ois = this.orderRepository.createItems(order.getId(),orderItems);

        // Test method
        Collection<FindItemResponse> items_found = this.orderRepository.getItemsInOrder(order.getId());

        FindItemResponse response = (FindItemResponse)items_found.toArray()[0];
        assertEquals(2, response.getQuantity());
    }

    @Test
    void find_items_in_order_return_empty_list() throws InvalidAttributesException {
        // Test method

        Collection<FindItemResponse> items_found = this.orderRepository.getItemsInOrder(20L);

        assertEquals(0, items_found.size());


    }
}