package superPrice.storePrice.repository.price;

import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;
import superPrice.storePrice.model.Price;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    private final DataSource dataSource;

    public PriceRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Collection<Price> findTenSpecials() {
        try {
            Connection connection = dataSource.getConnection();
            String priceQuery = "select * from store_price where STATUS= 'Special Offer';";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            ResultSet rs = stm.executeQuery();
            ArrayList<Price> prices = new ArrayList<>();
            while (rs.next()) {
                Price price = new Price(rs.getString(1), rs.getInt(2),
                        rs.getDouble(3), rs.getString(4));
                prices.add(price);
            }
            connection.close();
            return prices;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findTenSpecials", e);
        }
    }

    @Override
    public Price findPricesByStoreIdAndBarcode(String storeId, String barcode) {
        try {
            Connection connection = dataSource.getConnection();
            String priceQuery = "select * from store where UPPER(store_id)=? and UPPER(barcode)=?";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, storeId.toUpperCase());
            stm.setString(2, barcode.toUpperCase());
            ResultSet rs = stm.executeQuery();
            Price price = new Price(rs.getString(1), rs.getInt(2),
                    rs.getDouble(3), rs.getString(4));
            connection.close();
            return price;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }
    }

    @Override
    public Collection<Price> findPricesByBarcode(String barcode) {
        try {
            Connection connection = dataSource.getConnection();
            String priceQuery = "select * from store_price where UPPER(barcode)=? ORDER BY price";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, barcode.toUpperCase());
            ResultSet rs = stm.executeQuery();
            ArrayList<Price> prices = new ArrayList<>();
            while (rs.next()) {
                Price price = new Price(rs.getString(1), rs.getInt(2),
                        rs.getDouble(3), rs.getString(4));
                prices.add(price);
            }
            connection.close();
            return prices;

        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }
    }

    @Override
    public Collection<Price> findPricesByStoreID(String StoreId) {
        try {
            Connection connection = dataSource.getConnection();
            String priceQuery = "select * from store_price sp, store s, product p where store_id=?  ";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, StoreId);
            ResultSet rs = stm.executeQuery();
            ArrayList<Price> prices = new ArrayList<>();
            while (rs.next()) {
                Price price = new Price(rs.getString(1), rs.getInt(2),
                        rs.getDouble(3), rs.getString(4));
                prices.add(price);
            }
            connection.close();
            return prices;

        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }
    }

}
