package superPrice.storePrice.service;

import superPrice.storePrice.model.Price;
import superPrice.storePrice.model.Product;
import superPrice.storePrice.model.StorePrice;
import superPrice.storePrice.model.Store;

import java.util.Collection;

public interface StorePriceService {
    /**
     * return list of products which matches the input catergory
     */
    Collection<Product> findProductByCategory(String category);

    /**
     * return list of prices which matches the input product name
     */
    Collection<StorePrice> findStorePriceByBarcode(String barcode);


    Store findStoreById(String id);

    Product findProductByBarcode(String barcode);

    Collection<Product> findAllProducts();

    Collection<StorePrice> findTenSpecials();

    Collection<Product> findProductByName(String name);

    Collection<Product> findProductsByAnyCondition(String name);

    /**
     * return list of prices which matches the input barcode
     */
//    public List<Price> SearchByBarcode(int barcode);

    /**
     * return list of prices which matches the input status (such as price drop, special offer, on sale, MSRP)
     */
//    public List<Price> SearchByStatus(String status);

    /**
     * return list of sorted prices based on the input sorting condition
     */
//    public List<Price> SortPrice(String condition);
}