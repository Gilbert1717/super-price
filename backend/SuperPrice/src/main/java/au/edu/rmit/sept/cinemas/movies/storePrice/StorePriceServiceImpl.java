package au.edu.rmit.sept.cinemas.movies.storePrice;

import au.edu.rmit.sept.cinemas.movies.storePrice.price.Price;
import au.edu.rmit.sept.cinemas.movies.storePrice.price.PriceRepository;
import au.edu.rmit.sept.cinemas.movies.storePrice.product.Product;
import au.edu.rmit.sept.cinemas.movies.storePrice.product.ProductRepository;
import au.edu.rmit.sept.cinemas.movies.storePrice.store.Store;
import au.edu.rmit.sept.cinemas.movies.storePrice.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
@Service
public class StorePriceServiceImpl implements StorePriceService {
//    private ProductRepository productRepository;
//    private PriceRepository priceRepository;
    @Autowired
    private PriceRepository priceRepositoryImpl;
    @Autowired
    private ProductRepository productRepositoryImpl;
    @Autowired
    private StoreRepository storeServiceImpl;


    /**
     * return list of products which matches the input catergory
     */
    @Override
    public Collection<Product> findProductByCategory(String category){
        return this.productRepositoryImpl.findProductByCategory(category);
    }

    @Override
    public Collection<StorePrice> findStorePriceByBarcode(String barcode){
        Product p = this.productRepositoryImpl.findProductByBarcode(barcode);
        Collection<Price> prices = this.priceRepositoryImpl.findPricesByBarcode(barcode);
        Collection<StorePrice> storePrices = new ArrayList<>();
        for (Price price:prices){
            Store s = this.storeServiceImpl.findStoreByStoreId(Integer.toString(price.getStoreid()));
            StorePrice sp = new StorePrice(p,s,price);
            storePrices.add(sp);
        }
        return storePrices;
    }

    public Store findStoreById(String id){

        Store s = this.storeServiceImpl.findStoreByStoreId(id);
        return s;
    }

    public Product findProductByBarcode(String barcode){
        Product p = this.productRepositoryImpl.findProductByBarcode(barcode);
        return p;
    }





//    public Collection<Price> SearchPriceByName(String name){
//        return this.priceRepository.findPricesByProductName(name);
//    }
//    public Collection<StorePrice> SearchPriceByBarcode(String barcode){
//        return this.priceRepository.findPricesByBarcode(barcode);
//    }

    /**
     * return list of prices which matches the input product name
     */
//    public List<Price> SearchByName(String name);

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