package superPrice.storePrice.models;

import org.junit.jupiter.api.Test;
import superPrice.storePrice.model.Price;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PriceTests {
    // format: Price(String barcode, int storeid,  double price, String status)
    @Test
    void should_return_price_details() {
        Price p = new Price("ABC", 123,  2.10, "status");
        assertEquals("ABC", p.getBarcode());
        assertEquals(123, p.getStoreid());
        assertEquals(2.10, p.getPrice());
        assertEquals("status", p.getStatus());
    }

    @Test
    void should_return_no_details() {
        Price p = new Price();
        assertNull(p.getBarcode());
        assertEquals(0, p.getStoreid());
        assertEquals(0, p.getPrice());
        assertNull(p.getStatus());
    }

    @Test
    void should_return_details_assigned_by_setters() {
        Price p = new Price();
        p.setBarcode("ABC");
        p.setStoreid(123);
        p.setPrice(2.10);
        p.setStatus("status");
        assertEquals("ABC", p.getBarcode());
        assertEquals(123, p.getStoreid());
        assertEquals(2.10, p.getPrice());
        assertEquals("status", p.getStatus());
    }
}
