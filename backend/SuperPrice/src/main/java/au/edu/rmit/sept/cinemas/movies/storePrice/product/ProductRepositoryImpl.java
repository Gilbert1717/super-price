package au.edu.rmit.sept.cinemas.movies.storePrice.product;

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
public class ProductRepositoryImpl extends RepositoryImpl implements ProductRepository{
    @Override
    public Collection<Product> findProductByCategory(String category){
        try {
            Connection connection = getDataSource().getConnection();
            String query = "select * from product where category=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, category);
            Collection<Product> products = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product m = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
                products.add(m);
            }
            connection.close();
            return products;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByCategory", e);
        }
    }

    @Override
    public Product findProductByBarcode(String barcode){
        try {
            Connection connection = getDataSource().getConnection();
            String query = "select * from Product where Barcode=?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, barcode);
            System.out.println(stm);
            ResultSet rs = stm.executeQuery();
            Product p = new Product();
            if(rs.next()){
                p = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            connection.close();
            return p;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in findProductByBarcode", e);
        }

    }
}
