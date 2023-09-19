package superPrice;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import superPrice.storePrice.repository.price.PriceRepository;
import superPrice.storePrice.repository.price.PriceRepositoryImpl;
import superPrice.storePrice.repository.product.ProductRepository;
import superPrice.storePrice.repository.product.ProductRepositoryImpl;
import superPrice.storePrice.repository.store.StoreRepository;
import superPrice.storePrice.repository.store.StoreRepositoryImpl;

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
