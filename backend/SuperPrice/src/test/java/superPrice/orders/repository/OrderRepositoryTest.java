package superPrice.orders.repository;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    void should_create_item() throws InvalidAttributesException {
        //create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

        // run the method
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));
//        ois.add(new OrderItem("5369979017",109,2));
        // run the method
        OrderItem orderItem = this.orderRepository.createItem(order.getId(),new OrderItem("5369979017",104,2));

        // check information in items
        assertEquals(1,orderItem.getOrderId());
        assertEquals("5369979017",orderItem.getBarcode());
        assertEquals(104,orderItem.getStoreId());
        assertEquals(2,orderItem.getQuantity());
    }

    @Test
    void create_item_throws_exception_due_to_foreign_key() throws InvalidAttributesException {

        // run the method
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.createItem((long)1,new OrderItem("5369979017",104,2)));
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
}