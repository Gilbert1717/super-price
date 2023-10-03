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
class OrderRepositoryCreateOrderItemTest {
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
    void should_create_order_and_items() throws InvalidAttributesException {
        //create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);
        ArrayList<OrderItem> ois = new ArrayList<>();
        ois.add(new OrderItem("5369979017",104,2));
//        ois.add(new OrderItem("5369979017",109,2));
        // run the method
        NewOrderResponse response = this.orderRepository.createOrderAndItems(new Order(deliverTimestamp, "testing address", "express"),ois);

        // check infomation in order
        assertEquals(deliverTimestamp, response.getOrder().getDeliverTime());
        assertEquals("testing address", response.getOrder().getDeliveryAddress());
        assertEquals("express", response.getOrder().getDeliveryType());
        assertNotNull(response.getOrder().getId());
        assertNotNull(response.getOrder().getCreatingTime());
        assertDoesNotThrow(()->this.orderRepository.findOrderById(response.getOrder().getId()));

        //check information in items
        OrderItem item = (OrderItem) response.getOrderItems().toArray()[0];
        assertEquals("5369979017",item.getBarcode());
        assertEquals(104,item.getStoreId());
        assertEquals(2,item.getQuantity());
    }


    @Test
    void should_throw_InvalidAttributesException() {
        // create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);
        ArrayList<OrderItem> ois = new ArrayList<>();
        ois.add(new OrderItem("5369979017",104,2));
        ois.add(new OrderItem("5369979017",104,2));
        // run the method
        Exception exception =
        assertThrows(InvalidAttributesException.class, () ->
            this.orderRepository.createOrderAndItems(new Order(deliverTimestamp, "testing address", "express"),ois));

        String expectedMessage = "Error in creating order, wrong item information provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}