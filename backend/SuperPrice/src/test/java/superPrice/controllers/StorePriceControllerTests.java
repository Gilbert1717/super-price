package superPrice.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superPrice.storePrice.model.StorePrice;
import superPrice.storePrice.controller.StorePriceController;
import superPrice.storePrice.service.StorePriceService;
import superPrice.storePrice.model.Price;
import superPrice.storePrice.model.Product;
import superPrice.storePrice.model.Store;

import java.util.ArrayList;
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
    void no_products_found_by_findAllProducts_when_empty() {
        assertEquals(0, controller.findAllProducts().size());
    }

    @Test
    void multiple_products_found_by_findAllProducts_when_exist() {
        Product p1 = new Product("ABC", "XYZ", "CAT");
        Product p2 = new Product("DEF", "UVW", "DOG");
        when(service.findAllProducts())
                .thenReturn(List.of(p1, p2));
        assertEquals(2, controller.findAllProducts().size());
    }

    @Test
    void no_products_found_by_findProductByCategory_when_empty() {
        when(service.findProductByCategory("Electronics"))
            .thenReturn(new ArrayList<>());
        assertEquals(0, controller.findProductByCategory("Electronics").size());
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
        when (service.findProductByBarcode("ABC"))
            .thenReturn(p);
        assertEquals(p, controller.findProductByBarcode("ABC"));
    }

    @Test
    void should_not_return_details_when_product_does_not_exist() {
        assertNull(service.findProductByBarcode("ABC"));
    }

    @Test
    void should_return_prices_from_product_id() {
        Product product = new Product("ABC", "XYZ", "CAT");
        Store store = new Store(123, "ABC",  "XYZ", 321);
        Price price = new Price("ABC", 123,  2.10, "status");
        StorePrice sp = new StorePrice(product, store, price);
        when(service.findStorePriceByBarcode("ABC"))
            .thenReturn(List.of(sp));
        assertEquals(List.of(sp), controller.findPriceByProductBarcode("ABC"));
    }

    @Test
    void should_not_return_price_for_missing_product() {
        when(service.findStorePriceByBarcode("ABC"))
            .thenReturn(new ArrayList<>());
        assertEquals(0, controller.findPriceByProductBarcode("ABC").size());
    }

    @Test
    void should_return_store_with_full_id() {
        Store s = new Store(123, "ABC",  "XYZ", 321);
        when(service.findStoreById("123"))
            .thenReturn(s);
        assertEquals(s, controller.findStoreByStoreId("123"));
    }

    @Test
    void should_not_return_store_when_no_match() {
        Store s = new Store(123, "ABC",  "XYZ", 321);
        when(service.findStoreById("321"))
            .thenReturn(null);
        assertNull(controller.findStoreByStoreId("321"));
    }

    @Test
    void should_return_product_from_full_match_name() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductByName("XYZ"))
                .thenReturn(List.of(p));
        assertEquals(List.of(p), controller.findProductByName("XYZ"));
    }

    @Test
    void should_return_product_from_partial_match_name() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductByName("X"))
                .thenReturn(List.of(p));
        assertEquals(List.of(p), controller.findProductByName("X"));
    }

    @Test
    void findByName_should_return_no_product_when_no_match() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductByName("ABC"))
                .thenReturn(List.of());
        assertEquals(0, controller.findProductByName("ABC").size());
    }

    @Test
    void should_return_product_searched_by_id() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductsByAnyCondition("ABC"))
                .thenReturn(List.of(p));
        assertEquals(List.of(p), controller.findProductByAnyCondition("ABC"));
    }

    @Test
    void should_return_product_searched_by_full_name() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductsByAnyCondition("XYZ"))
                .thenReturn(List.of(p));
        assertEquals(List.of(p), controller.findProductByAnyCondition("XYZ"));
    }

    @Test
    void should_return_product_searched_by_partial_name() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductsByAnyCondition("X"))
                .thenReturn(List.of(p));
        assertEquals(List.of(p), controller.findProductByAnyCondition("X"));
    }

    @Test
    void findByAny_should_return_no_product_when_no_match() {
        Product p = new Product("ABC", "XYZ", "CAT");
        when(service.findProductsByAnyCondition("MMM"))
                .thenReturn(List.of());
        assertEquals(0, controller.findProductByAnyCondition("MMM").size());
    }
}
