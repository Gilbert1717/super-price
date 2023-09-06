package au.edu.rmit.sept.cinemas.movies;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class RepositoryImpl {
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/superprice?");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("12345678");
        return dataSourceBuilder.build();
    }
}
