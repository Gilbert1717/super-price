package superPrice.orders.repository;

import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.storePrice.model.Price;

import javax.naming.directory.InvalidAttributesException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final DataSource dataSource;

    public OrderRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Order createOrder(Order order) throws InvalidAttributesException {
        try {
            PreparedStatement stm = this.dataSource.getConnection().prepareStatement(
                    "INSERT INTO orders (creating_time,delivery_time,delivery_address,delivery_type) VALUES (?, ?, ?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            Instant utcNow = Instant.now();
            Timestamp timestamp = Timestamp.from(utcNow);

            stm.setTimestamp(1, timestamp);
            stm.setTimestamp(2, order.getDeliverTime());
            stm.setString(3, order.getDeliveryAddress());
            stm.setString(4, order.getDeliveryType());
            int row = stm.executeUpdate();

            if (row == 0) {
                throw new SQLException("Failed to create order = " + order.toString());
            }

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Order(id, timestamp, order.getDeliverTime(),order.getDeliveryAddress(),order.getDeliveryType());
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new InvalidAttributesException("Error in creating order");
        }
    }

    @Override
    public Order findOrderById(long id) throws InvalidAttributesException {
        try {
            PreparedStatement stm = this.dataSource.getConnection().prepareStatement(
                    "SELECT * FROM orders WHERE id = ?",Statement.RETURN_GENERATED_KEYS);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            Order order = new Order(rs.getLong(1), rs.getTimestamp(2),
                    rs.getTimestamp(3), rs.getString(4),rs.getString(5));
            return order;
        }
        catch (Exception e){
            throw new InvalidAttributesException("Error in find order Id" + id);
        }
    }


    public NewOrderResponse createOrderAndItems(Order order, Collection<OrderItem> orderItems) throws InvalidAttributesException {
        //Create order first in orders table
        Order o = createOrder(order);
        try {
            //Create items in the order in orders_item relation table
            Collection<OrderItem> ois = new ArrayList<>();
            for (OrderItem orderItem:orderItems){
                PreparedStatement stm = this.dataSource.getConnection().prepareStatement(
                        "INSERT INTO order_product_store (order_id,barcode,store_id,quantity) VALUES (?, ?, ?,?)",
                        Statement.RETURN_GENERATED_KEYS);

                stm.setLong(1, o.getId());
                stm.setString(2, orderItem.getBarcode());
                stm.setInt(3, orderItem.getStoreId());
                stm.setInt(4, orderItem.getQuantity());

                int row = stm.executeUpdate();
                if (row == 0) {
                    throw new InvalidAttributesException("Failed to add item to order = " + o.getId());
                }
                ois.add(new OrderItem(o.getId(),orderItem.getBarcode(),orderItem.getStoreId(), orderItem.getQuantity()));
            }
            return new NewOrderResponse(ois,o);

        } catch (SQLException e) {
            deleteOrderByOrderId(o.getId());
            throw new InvalidAttributesException("Error in creating order, wrong item information provided");
        }
    }

    @Override
    public void deleteOrderByOrderId(long order_id) {
        try {
            PreparedStatement stm = this.dataSource.getConnection().prepareStatement(
                    "DELETE FROM orders WHERE id=?", Statement.RETURN_GENERATED_KEYS);

            stm.setLong(1, order_id);

            int row = stm.executeUpdate();

            if (row == 0) {
                throw new SQLException("Failed to delete Order ID = " + order_id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error in create", e);
        }
    }


}
