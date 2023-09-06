package superPrice.storePrice.price;

import superPrice.RepositoryImpl;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
@Repository
public class PriceRepositoryImpl extends RepositoryImpl implements PriceRepository {


    @Override
    public Price findPricesByStoreIdAndBarcode(String storeId, String barcode){
        try {
            Connection connection = getDataSource().getConnection();
            String priceQuery = "select * from store where UPPER(store_id)=? and UPPER(barcode)=?";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, storeId.toUpperCase());
            stm.setString(2, barcode.toUpperCase());
            ResultSet rs = stm.executeQuery();
            Price price = new Price(rs.getString(1),rs.getInt(2),
                    rs.getDouble(3), rs.getString(4));
            connection.close();
            return price;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }
    }
    @Override
    public Collection<Price> findPricesByBarcode(String barcode){
        try {
            Connection connection = getDataSource().getConnection();
            String priceQuery = "select * from store_price where UPPER(barcode)=?";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, barcode.toUpperCase());
            ResultSet rs = stm.executeQuery();
            ArrayList<Price> prices = new ArrayList<>();
            while (rs.next()) {
                Price price = new Price(rs.getString(1),rs.getInt(2),
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
    public Collection<Price> findPricesByStoreID(String StoreId){
        try {
            Connection connection = getDataSource().getConnection();
            String priceQuery = "select * from store_price sp, store s, product p where store_id=? join ";
            PreparedStatement stm = connection.prepareStatement(priceQuery);
            stm.setString(1, StoreId);
            ResultSet rs = stm.executeQuery();
            ArrayList<Price> prices = new ArrayList<>();
            while (rs.next()) {
                Price price = new Price(rs.getString(1),rs.getInt(2),
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
