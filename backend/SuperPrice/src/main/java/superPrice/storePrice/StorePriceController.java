package superPrice.storePrice;

import superPrice.storePrice.product.Product;
import superPrice.storePrice.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "price")
public class StorePriceController {
    @Autowired
    private StorePriceService StorePriceServiceImpl;

//    public StorePriceController(StorePriceService storePriceService) {
//        this.StorePriceService = storePriceService;
//    }
    @GetMapping(value = "product/category:{category}")
    public Collection<Product> findProductByCategory(@PathVariable String category) {
        return this.StorePriceServiceImpl.findProductByCategory(category);
    }

    @GetMapping(value = "product/barcode:{barcode}")
    public Product findProductByBarcode(@PathVariable String barcode) {
        return this.StorePriceServiceImpl.findProductByBarcode(barcode);
    }

    @GetMapping(value = "storePrice/{barcode}")
    public Collection<StorePrice> findPriceByProductBarcode(@PathVariable String barcode) {
        return this.StorePriceServiceImpl.findStorePriceByBarcode(barcode);
    }

    @GetMapping(value = "store/{storeid}")
    public Store findStoreByStoreId(@PathVariable String storeid) {
        return this.StorePriceServiceImpl.findStoreById(storeid);
    }

}
