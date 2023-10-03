package superPrice.orders.repository;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.orders.model.Order;

import javax.naming.directory.InvalidAttributesException;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryCreateTest {
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
    void should_create_an_order() throws InvalidAttributesException, SQLException {
//       create dummy order for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);

//        run the method
        Order order = this.orderRepository.createOrder(new Order(deliverTimestamp, "testing address", "express"));

//        check all the information in the dummy order with the order created in the database
        assertEquals(deliverTimestamp, order.getDeliverTime());
        assertEquals("testing address", order.getDeliveryAddress());
        assertEquals("express", order.getDeliveryType());
        assertNotNull(order.getId());
        assertNotNull(order.getCreatingTime());
        assertDoesNotThrow(()->this.orderRepository.findOrderById(order.getId()));
        assertNotNull(this.orderRepository.findOrderById(order.getId()));
    }

}