package au.edu.rmit.sept.cinemas.movies.storePrice;

import au.edu.rmit.sept.cinemas.movies.storePrice.price.Price;
import au.edu.rmit.sept.cinemas.movies.storePrice.product.Product;
import au.edu.rmit.sept.cinemas.movies.storePrice.store.Store;



public class StorePrice {
    private Product product;
    private Store store;
    private Price price;


    public StorePrice() {
    }

    public StorePrice(Product product, Store store, Price price) {
        this.product = product;
        this.store = store;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}




