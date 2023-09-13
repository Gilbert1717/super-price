package superPrice.models;

import org.junit.jupiter.api.Test;
import superPrice.storePrice.product.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTests {
    // format: Product(String barcode, String name, String category)
    @Test
    void should_return_product_details() {
        Product p = new Product("ABC", "XYZ", "CAT");
        assertEquals("ABC", p.getBarcode());
        assertEquals("XYZ", p.getName());
        assertEquals("CAT", p.getCategory());
    }

    @Test
    void should_return_no_details() {
        Product p = new Product();
        assertNull(p.getBarcode());
        assertNull(p.getName());
        assertNull(p.getCategory());
    }

    @Test
    void should_return_details_assigned_by_setters() {
        Product p = new Product();
        p.setBarcode("ABC");
        p.setName("XYZ");
        p.setCategory("CAT");
        assertEquals("ABC", p.getBarcode());
        assertEquals("XYZ", p.getName());
        assertEquals("CAT", p.getCategory());
    }
}
