package au.edu.rmit.sept.cinemas.movies.price.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface  ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "SELECT * FROM Product WHERE category = :category",
            nativeQuery = true)
    Collection<Product> SearchProductByCategory(@Param("category") String category);
}

