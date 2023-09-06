package superPrice;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class RepositoryImpl {
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:/tmp/demodb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }
}
