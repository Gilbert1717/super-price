package superPrice;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import superPrice.storePrice.price.PriceRepository;
import superPrice.storePrice.price.PriceRepositoryImpl;
import superPrice.storePrice.product.ProductRepository;
import superPrice.storePrice.product.ProductRepositoryImpl;
import superPrice.storePrice.store.StoreRepository;
import superPrice.storePrice.store.StoreRepositoryImpl;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {
    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl(getDataSource());
    }

    @Bean
    public StoreRepository storeRepository() {
        return new StoreRepositoryImpl(getDataSource());
    }

    @Bean
    public PriceRepository priceRepository() {
        return new PriceRepositoryImpl(getDataSource());
    }

    private DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:file:/tmp/pricedb")
                .username("sa")
                .password("password")
                .build();
    }
}
