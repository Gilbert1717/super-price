package au.edu.rmit.sept.cinemas.movies.storePrice.store;

import java.util.Collection;

//
public interface  StoreRepository {

    Store findStoreByStoreId(String StoreId);

    Collection<Store> findStoreByName(String name);
}
//
