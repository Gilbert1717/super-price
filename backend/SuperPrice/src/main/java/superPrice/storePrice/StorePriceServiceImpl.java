package superPrice.storePrice;

import superPrice.storePrice.price.Price;
import superPrice.storePrice.price.PriceRepository;
import superPrice.storePrice.product.Product;
import superPrice.storePrice.product.ProductRepository;
import superPrice.storePrice.store.Store;
import superPrice.storePrice.store.StoreRepository;
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
    private StoreRepository storeRepositoryImpl;


    /**
     * return list of products which matches the input catergory
     */
    @Override
    public Collection<Product> findAllProducts(){
        return this.productRepositoryImpl.findAll();
    }
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
            Store s = this.storeRepositoryImpl.findStoreByStoreId(Integer.toString(price.getStoreid()));
            StorePrice sp = new StorePrice(p,s,price);
            storePrices.add(sp);
        }
        return storePrices;
    }
    @Override
    public Collection<Product> findProductByName(String name){
        return this.productRepositoryImpl.findProductByName(name);
    }


    public Store findStoreById(String id){
        return this.storeRepositoryImpl.findStoreByStoreId(id);
    }

    public Product findProductByBarcode(String barcode){
        return this.productRepositoryImpl.findProductByBarcode(barcode);
    }

    public Collection<Product> findProductsByAnyCondition(String condition){
        return this.productRepositoryImpl.findProductByAnyCondition(condition);
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