package superPrice.storePrice.price;


import java.util.Collection;

public interface PriceRepository {

    Price findPricesByStoreIdAndBarcode(String StoreId, String Barcode);

    Collection<Price> findPricesByBarcode(String Barcode);
    Collection<Price> findPricesByStoreID(String StoreId);


}

