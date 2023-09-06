package au.edu.rmit.sept.cinemas.movies.storePrice.store;


import au.edu.rmit.sept.cinemas.movies.RepositoryImpl;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
@Repository
public class StoreRepositoryImpl extends RepositoryImpl implements StoreRepository{


    @Override
    public Store findStoreByStoreId(String storeID){
        try {
            Connection connection = getDataSource().getConnection();
            String query = "select * from store where store_id=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, storeID);
            Collection<Store> stores = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            Store s = new Store();
            if(rs.next()){
                 s = new Store(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
            }
            connection.close();
            return s;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByCategory", e);
        }
    }

    @Override
    public Collection<Store> findStoreByName(String name){
        try {
            Connection connection = getDataSource().getConnection();
            String query = "select * from store where name=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            Collection<Store> stores = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Store s = new Store(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
                stores.add(s);
            }
            connection.close();
            return stores;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }

    }
}
