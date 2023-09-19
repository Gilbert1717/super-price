package superPrice.storePrice.repository.store;

import superPrice.storePrice.model.Store;

import java.util.Collection;

public interface StoreRepository {

    Store findStoreByStoreId(String StoreId);

    Collection<Store> findStoreByName(String name);
}
