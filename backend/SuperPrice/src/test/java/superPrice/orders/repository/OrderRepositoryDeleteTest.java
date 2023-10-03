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
class OrderRepositoryDeleteTest {
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




//    @Test
    void deleteOrderByOrderId() throws InvalidAttributesException {
        //        create dummy order items for testing
        Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
        Timestamp deliverTimestamp = Timestamp.from(testingTime);
        ArrayList<OrderItem> ois = new ArrayList<>();
        ois.add(new OrderItem("5369979017",104,2));
        ois.add(new OrderItem("5369979017",109,2));
//      create order and items
        NewOrderResponse response = this.orderRepository.createOrderAndItems(new Order(deliverTimestamp, "testing address", "express"),ois);

//      run delete method
        this.orderRepository.deleteOrderByOrderId(response.getOrder().getId());
        Exception exception = assertThrows(InvalidAttributesException.class, () ->
                this.orderRepository.findOrderById(response.getOrder().getId()));

        String expectedMessage = "Error in find order Id";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }
}