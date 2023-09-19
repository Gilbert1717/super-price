package superPrice.orders.repository;

import org.springframework.stereotype.Repository;
import superPrice.orders.model.Order;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Instant;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final DataSource dataSource;

    public OrderRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Order create(Order order) {
        try {
            PreparedStatement stm = this.dataSource.getConnection().prepareStatement(
                    "INSERT INTO orders (creating_time,delivery_time,delivery_address) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            Instant utcNow = Instant.now();
            Timestamp timestamp = Timestamp.from(utcNow);

            stm.setTimestamp(1, timestamp);
            stm.setTimestamp(2, order.getDeliverTime());
            stm.setString(3, order.getDeliveryAddress());
            int row = stm.executeUpdate();

            if (row == 0) {
                throw new SQLException("Failed to create order = " + order.toString());
            }

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Order(id, timestamp, order.getDeliverTime(),order.getDeliveryAddress());
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error in creating order", e);
        }
    }
}
