package superPrice.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superPrice.storePrice.model.StorePrice;
import superPrice.storePrice.model.Price;
import superPrice.storePrice.model.Product;
import superPrice.storePrice.model.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StorePriceTests {
    // format: Product(Product product, Store store, Price price)

    Product product;
    Store store;
    Price price;

    @BeforeEach
    void setup() {
        product = new Product("ABC", "XYZ", "CAT");
        store = new Store(123, "ABC",  "XYZ", 321);
        price = new Price("ABC", 123,  2.10, "status");
    }

    @Test
    void should_return_store_price_details() {
        StorePrice sp = new StorePrice(product, store, price);
        assertEquals(product, sp.getProduct());
        assertEquals(store, sp.getStore());
        assertEquals(price, sp.getPrice());
    }

    @Test
    void should_return_no_details() {
        StorePrice sp = new StorePrice();
        assertNull(sp.getProduct());
        assertNull(sp.getStore());
        assertNull(sp.getPrice());
    }

    @Test
    void should_return_details_assigned_by_setters() {
        StorePrice sp = new StorePrice();
        sp.setProduct(product);
        sp.setStore(store);
        sp.setPrice(price);
        assertEquals(product, sp.getProduct());
        assertEquals(store, sp.getStore());
        assertEquals(price, sp.getPrice());
    }
}
