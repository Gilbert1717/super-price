package au.edu.rmit.sept.cinemas.movies.storePrice;

import au.edu.rmit.sept.cinemas.movies.storePrice.product.Product;
import au.edu.rmit.sept.cinemas.movies.storePrice.store.Store;

import java.util.Collection;

interface StorePriceService {
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