package superPrice.repositories;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import superPrice.storePrice.model.Product;
import superPrice.storePrice.repository.product.ProductRepository;
import superPrice.storePrice.repository.product.ProductRepositoryImpl;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ProductRepositoryImplTests {
    @Autowired
    private Flyway flyway;

    @Autowired
    DataSource source;

    ProductRepository repo;

    @BeforeEach
    private void setUp() {
        flyway.migrate();
        repo = new ProductRepositoryImpl(source);
    }

    @AfterEach
    private void tearDown() {
        flyway.clean();
    }

    @Test
    void should_retrieve_all_products() {
        var prods = repo.findAll();
        assertEquals(40, prods.size());
    }

    @Test
    void should_return_no_products_for_invalid_category() {
        var prods = repo.findProductByCategory("abc");
        assertEquals(0, prods.size());
    }

    @Test
    void should_return_all_products_in_full_category_name() {
        var prods = repo.findProductByCategory("electronics");
        assertEquals(8, prods.size());
    }

    @Test
    void should_not_return_all_products_in_partial_category_name() {
        var prods = repo.findProductByCategory("elec");
        assertEquals(0, prods.size());
    }

    @Test
    void should_return_product_with_barcode() {
        Product prod = repo.findProductByBarcode("5369979017");
        assertEquals("Digital Camera", prod.getName());
    }

    @Test
    void should_return_nothing_from_invalid_barcode() {
        Product prod = repo.findProductByBarcode("abc");
        assertEquals(null, prod.getName());
    }

    @Test
    void should_return_products_from_full_name() {
        var prods = repo.findProductByName("digital camera");
        assertEquals(1, prods.size());
    }

    @Test
    void should_return_products_from_partial_name() {
        var prods = repo.findProductByName("digi");
        assertEquals(1, prods.size());
    }

    @Test
    void should_not_return_products_from_invalid_name() {
        var prods = repo.findProductByName("abcd");
        assertEquals(0, prods.size());
    }

    @Test
    void should_return_product_from_partial_matching_name() {
        var prods = repo.findProductByAnyCondition("digi");
        assertEquals(1, prods.size());
    }

    @Test
    void should_return_product_from_fully_matching_barcode() {
        var prods = repo.findProductByAnyCondition("5369979017");
        assertEquals(1, prods.size());
    }
    @Test
    void should_return_product_from_partial_matching_barcode() {
        var prods = repo.findProductByAnyCondition("536997");
        assertEquals(1, prods.size());
    }

    @Test
    void should_return_many_products_from_generic_barcode_search() {
        var prods = repo.findProductByAnyCondition("1");
        assertEquals(28, prods.size());
    }


    @Test
    void should_return_nothing_from_invalid_search_term() {
        var prods = repo.findProductByAnyCondition("abcdef");
        assertEquals(0, prods.size());
    }
}

