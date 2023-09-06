package superPrice.storePrice.product;


import java.util.Collection;

public interface  ProductRepository {


//    @Query(value = "SELECT * FROM Product WHERE upper(category) = upper(:category)",
//            nativeQuery = true)
    Collection<Product> findProductByCategory(String category);

    Product findProductByBarcode(String barcode);
}

