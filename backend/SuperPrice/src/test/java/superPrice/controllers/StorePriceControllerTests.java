package superPrice.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import superPrice.storePrice.StorePrice;
import superPrice.storePrice.StorePriceController;
import superPrice.storePrice.StorePriceService;
import superPrice.storePrice.product.Product;
import superPrice.storePrice.store.Store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StorePriceControllerTests {
    StorePriceController controller;
    StorePriceService service;

    @BeforeEach
    void setup() {
        service = mock(StorePriceService.class);
        controller = new StorePriceController(service);
    }

    @Test
    void no_products_found_when_findProductByCategory_returns_empty() {
        when(service.findProductByCategory("Electronics"))
            .thenReturn(new ArrayList<>());
        assertEquals(0, controller.findProductByCategory("Electronics").size());
    }

    @Test
    void product_should_return_when_product_in_database() {
        when(service.findProductByCategory("Electronics"))
            .thenReturn(List.of(new Product("ABC", "XYZ", "CAT")));
        assertEquals(1, controller.findProductByCategory("Electronics").size());
    }

    @Test
    void product_should_be_found_when_in_category() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductByCategory("Electronics"))
            .thenReturn(List.of(p));
        assertTrue(controller.findProductByCategory("Electronics").contains(p));
    }

    @Test
    void product_should_not_be_found_when_not_in_category() {
        Product p1 = new Product("ABC", "XYZ", "CAT");
        Product p2 = new Product("DEF", "UVW", "DOG");
        when(service.findProductByCategory("Electronics"))
                .thenReturn(List.of(p1));
        assertFalse(controller.findProductByCategory("Electronics").contains(p2));
    }

    @Test
    void should_return_details_of_given_product_id() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when (service.findProductByBarcode("ABC")).thenReturn(p);
        assertEquals(p, service.findProductByBarcode("ABC"));
    }

    @Test
    void should_not_return_details_when_product_does_not_exist() {
        assertNull(service.findProductByBarcode("ABC"));
    }


}
