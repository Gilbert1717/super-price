package au.edu.rmit.sept.cinemas.movies.storePrice.price;


import au.edu.rmit.sept.cinemas.movies.storePrice.StorePrice;
import au.edu.rmit.sept.cinemas.movies.storePrice.product.Product;

import java.util.Collection;

public interface PriceRepository {

    Price findPricesByStoreIdAndBarcode(String StoreId, String Barcode);

    Collection<Price> findPricesByBarcode(String Barcode);
    Collection<Price> findPricesByStoreID(String StoreId);


}

