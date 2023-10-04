package superPrice.orders.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import superPrice.SuperPriceApplication;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.OrderItem;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SuperPriceApplication.class)
@AutoConfigureMockMvc
public class ControllerIntegrationTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    Flyway flyway;

    @BeforeEach
    public void setUp() {
        flyway.migrate();
    }

    @AfterEach
    public void tearDown() {
        flyway.clean();
    }

    @Test
    void createOrder() throws Exception {
        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",109,2));
        mvc.perform(post("/order")
                        .content(asJsonString(new NewOrderRequest("2023-10-30 10:30:20", "Test address", "Express",orderItems)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.order.id").exists())
                .andExpect(jsonPath("$.order.deliveryAddress", is("Test address")))
                .andExpect(jsonPath("$.orderItems[0].orderId", is(2)))
                .andExpect(jsonPath("$.orderItems[0].barcode", is("5369979017")))
                .andExpect(jsonPath("$.orderItems[0].quantity", is(2)));

    }
    @Test
    void createOrder_throw_exception() throws Exception {
        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("5369979017",104,2));
        orderItems.add(new OrderItem("5369979017",104,2));
        mvc.perform(post("/order").content(asJsonString(new NewOrderRequest("2023-10-30 10:30:20", "Test address", "Express",orderItems)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Error in creating order, wrong item information provided")));
    }

    @Test
    void get_order_id_1() throws Exception {
        mvc.perform(get("/order/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.order.deliveryType", is("Express")))
                .andExpect(jsonPath("$.findItemResponse[0].product_name", is("Digital Camera")))
                .andExpect(jsonPath("$.findItemResponse[0].storeName", is("Sports Store")))
                .andExpect(jsonPath("$.findItemResponse[0].quantity", is(1)));
    }

    @Test
    void get_order_not_found() throws Exception {
        mvc.perform(get("/order/22").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(""));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
