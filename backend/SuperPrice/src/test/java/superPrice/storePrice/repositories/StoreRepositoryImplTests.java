package superPrice.storePrice.repositories;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.storePrice.repository.store.StoreRepository;
import superPrice.storePrice.repository.store.StoreRepositoryImpl;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StoreRepositoryImplTests {
    @Autowired
    private Flyway flyway;

    @Autowired
    DataSource source;

    StoreRepository repo;

    @BeforeEach
    private void setUp() {
        flyway.migrate();
        repo = new StoreRepositoryImpl(source);
    }

    @AfterEach
    private void tearDown() {
        flyway.clean();
    }

    @Test
    void should_return_products_from_store_by_name() {
        var stores = repo.findStoreByName("sports store");
        assertEquals(1, stores.size());
    }

    @Test
    void should_return_nothing_from_invalid_store_name() {
        var stores = repo.findStoreByName("abcdef");
        assertEquals(0, stores.size());
    }

    @Test
    void should_return_store_from_store_id() {
        var store = repo.findStoreByStoreId("101");
        assertEquals("Electronics Store", store.getName());
    }

    @Test
    void should_return_empty_store_from_invalid_id() {
        var store = repo.findStoreByStoreId("zzz");
        assertNull(store.getName());
    }
}
