package superPrice.storePrice.repository.store;


import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;
import superPrice.storePrice.model.Store;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final DataSource dataSource;

    public StoreRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Store findStoreByStoreId(String storeID) {
        try {
            Connection connection = dataSource.getConnection();
            String query = "select * from store where UPPER(store_id)=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, storeID.toUpperCase());
            Collection<Store> stores = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            Store s = new Store();
            if (rs.next()) {
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
    public Collection<Store> findStoreByName(String name) {
        try {
            Connection connection = dataSource.getConnection();
            String query = "select * from store where UPPER(name)=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name.toUpperCase());
            System.out.println(stm);
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
