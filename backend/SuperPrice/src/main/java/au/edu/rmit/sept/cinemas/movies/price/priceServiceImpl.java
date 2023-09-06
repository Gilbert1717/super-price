package au.edu.rmit.sept.cinemas.movies.price;

import au.edu.rmit.sept.cinemas.movies.price.product.Product;
import au.edu.rmit.sept.cinemas.movies.price.product.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.Collection;
@Service
public class priceServiceImpl implements PriceService {
    private ProductRepository productRepository;

    public priceServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /**
     * return list of products which matches the input catergory
     */
    @Override
    public Collection<Product> SearchByCategory(String category){
        return productRepository.SearchProductByCategory(category);
    }

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