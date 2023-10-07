// package superPrice.orders.model;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import javax.naming.directory.InvalidAttributesException;
// import java.sql.Timestamp;
// import java.time.Instant;
// import java.time.temporal.ChronoUnit;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// public class OrderModelTest {
//     @Test
//     void order_info_validation_passed() throws InvalidAttributesException {
//         String deliveryAddress = "Testing address";
//         String deliveryType = "Express";
//         Instant testingTime = Instant.now().plus(2, ChronoUnit.DAYS);
//         String deliverTime = Timestamp.from(testingTime).toString();
//         Order order = new Order(deliverTime,  deliveryAddress, deliveryType);
//         assertEquals(deliveryAddress, order.getDeliveryAddress());
//         assertEquals(deliveryType, order.getDeliveryType());
//         assertEquals(deliverTime, order.getDeliverTime());
//     }

//     @Test
//     void order_info_validation_date_failed() throws InvalidAttributesException {
//         String deliveryAddress = "Testing address";
//         String deliveryType = "Express";
//         Instant testingTime = Instant.now();
//         String deliverTime = Timestamp.from(testingTime).toString();
//         Exception exception = assertThrows(InvalidAttributesException.class, () ->
//                 new Order(deliverTime,deliveryAddress,deliveryType));

//         String expectedMessage = "invalid delivery date";
//         String actualMessage = exception.getMessage();

//         assertTrue(actualMessage.contains(expectedMessage));
//     }

//     @Test
//     void order_info_validation_type_failed() throws InvalidAttributesException {
//         String deliveryAddress = "Testing address";
//         String deliveryType = "Expre";
//         Instant testingTime = Instant.now();
//         String deliverTime = Timestamp.from(testingTime).toString();
//         Exception exception = assertThrows(InvalidAttributesException.class, () ->
//                 new Order(deliverTime,deliveryAddress,deliveryType));

//         String expectedMessage = "invalid delivery information";
//         String actualMessage = exception.getMessage();

//         assertTrue(actualMessage.contains(expectedMessage));
//     }

//     @Test
//     void order_info_validation_address_failed() throws InvalidAttributesException {
//         String deliveryAddress = "Tes";
//         String deliveryType = "Express";
//         Instant testingTime = Instant.now();
//         String deliverTime = Timestamp.from(testingTime).toString();
//         Exception exception = assertThrows(InvalidAttributesException.class, () ->
//                 new Order(deliverTime,deliveryAddress,deliveryType));

//         String expectedMessage = "invalid delivery information";
//         String actualMessage = exception.getMessage();

//         assertTrue(actualMessage.contains(expectedMessage));
//     }


// }
