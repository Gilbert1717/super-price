package superPrice.storePrice.store;

import java.util.Collection;

public interface StoreRepository {

    Store findStoreByStoreId(String StoreId);

    Collection<Store> findStoreByName(String name);
}
