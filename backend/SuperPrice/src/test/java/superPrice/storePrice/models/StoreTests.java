package superPrice.storePrice.models;

import org.junit.jupiter.api.Test;
import superPrice.storePrice.model.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StoreTests {
    // format: Store(int storeId, String name, String address, int postcode)
    @Test
    void should_return_store_details() {
        Store s = new Store(123, "ABC",  "XYZ", 321);
        assertEquals(123, s.getStoreId());
        assertEquals("ABC", s.getName());
        assertEquals("XYZ", s.getAddress());
        assertEquals(321, s.getPostcode());
    }

    @Test
    void should_return_no_details() {
        Store s = new Store();
        assertEquals(0, s.getStoreId());
        assertNull(s.getName());
        assertNull(s.getAddress());
        assertEquals(0, s.getPostcode());
    }

    @Test
    void should_return_details_assigned_by_setters() {
        Store s = new Store();
        s.setStoreId(123);
        s.setName("ABC");
        s.setAddress("XYZ");
        s.setPostcode(321);
        assertEquals(123, s.getStoreId());
        assertEquals("ABC", s.getName());
        assertEquals("XYZ", s.getAddress());
        assertEquals(321, s.getPostcode());
    }
}
