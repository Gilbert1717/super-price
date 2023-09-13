package superPrice.storePrice.product;


import java.util.Collection;

public interface  ProductRepository {


    Collection<Product> findAll();
    Collection<Product> findProductByCategory(String category);

    Product findProductByBarcode(String barcode);
    Collection<Product> findProductByName(String name);

    Collection<Product> findProductByAnyCondition(String condition);
}

