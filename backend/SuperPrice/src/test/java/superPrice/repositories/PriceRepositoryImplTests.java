package superPrice.repositories;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.storePrice.price.Price;
import superPrice.storePrice.price.PriceRepository;
import superPrice.storePrice.price.PriceRepositoryImpl;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PriceRepositoryImplTests {
    @Autowired
    private Flyway flyway;

    @Autowired
    DataSource source;

    PriceRepository repo;

    @BeforeEach
    private void setUp() {
        flyway.migrate();
        repo = new PriceRepositoryImpl(source);
    }

    @AfterEach
    private void tearDown() {
        flyway.clean();
    }

    @Test
    void invalid_barcode_should_return_no_prices() {
        var prices = repo.findPricesByBarcode("abc");
        assertEquals(0, prices.size());
    }

    @Test
    void should_return_all_4_prices_for_item_with_given_barcode() {
        var prices = repo.findPricesByBarcode("5369979017");
        assertEquals(4, prices.size());
    }

}
