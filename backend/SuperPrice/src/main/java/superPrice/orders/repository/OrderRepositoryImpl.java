package superPrice.orders.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import superPrice.orders.model.DTO.FindItemResponse;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderItem;

import javax.naming.directory.InvalidAttributesException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final DataSource dataSource;
    Logger log = LoggerFactory.getLogger(OrderRepositoryImpl.class);

    public OrderRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Order createOrder(Order order) throws InvalidAttributesException {
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement(
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
                throw new SQLException("Failed to create order = " + order);
            }
            log.info("Creating order" + stm);
            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                connection.close();
                return new Order(id, timestamp, order.getDeliverTime(),order.getDeliveryAddress(),order.getDeliveryType());
            } else {
                connection.close();
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new InvalidAttributesException(e.getMessage());
        }
    }

    @Override
    public Order findOrderById(long id) throws InvalidAttributesException {
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "SELECT * FROM orders WHERE id = ?",Statement.RETURN_GENERATED_KEYS);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            Order order = new Order(rs.getLong(1), rs.getTimestamp(2),
                    rs.getTimestamp(3), rs.getString(4),rs.getString(5));
            connection.close();
            return order;
        }
        catch (Exception e){
            throw new InvalidAttributesException("Error in find order Id" + id);
        }
    }

    public Collection<OrderItem> createItems(long orderID, Collection<OrderItem> orderItems) throws InvalidAttributesException {
        //Create order first in orders table
        Collection<OrderItem> ois = new ArrayList<>();
        try {
            //Create items in the order in orders_item relation table
            Connection connection = this.dataSource.getConnection();
            for (OrderItem oi:orderItems){
                PreparedStatement stm = connection.prepareStatement(
                        "INSERT INTO order_product_store (order_id,barcode,store_id,quantity) VALUES (?, ?, ?,?)",
                        Statement.RETURN_GENERATED_KEYS);

                stm.setLong(1, orderID);
                stm.setString(2, oi.getBarcode());
                stm.setInt(3, oi.getStoreId());
                stm.setInt(4, oi.getQuantity());
                log.info("Creating items" + stm);
                int row = stm.executeUpdate();
                if (row == 0) {
                    throw new InvalidAttributesException("Failed to add item to order = " + orderID);
                }
                ois.add(new OrderItem(orderID,oi.getBarcode(),oi.getStoreId(), oi.getQuantity()));

            }

            connection.close();
            return ois;
            }

        catch (SQLException e) {
            throw new InvalidAttributesException("Error in creating order items, wrong item information provided");
        }
    }

    @Override
    public void deleteOrderByOrderId(long order_id) throws InvalidAttributesException {
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM orders WHERE id=?", Statement.RETURN_GENERATED_KEYS);

            stm.setLong(1, order_id);

            int row = stm.executeUpdate();
            connection.close();
            if (row == 0) {
                throw new SQLException("Failed to delete Order ID = " + order_id);
            }

        } catch (SQLException e) {
            throw new InvalidAttributesException("Error in deleting order" + order_id);
        }
    }
    @Override
    public Collection<FindItemResponse> getItemsInOrder(long orderID) throws InvalidAttributesException {
        try {
            Collection<FindItemResponse> orderItems = new ArrayList<>();
            //Create items in the order in orders_item relation table
            Connection connection = this.dataSource.getConnection();
            String query = "SELECT p.NAME as product_name, s.NAME as store_name, orderp.QUANTITY, sp.price " +
                    "FROM (SELECT * FROM ORDER_PRODUCT_STORE WHERE order_id = ?) orderp " +
                    "LEFT JOIN STORE s on orderp.STORE_ID = s.STORE_ID " +
                    "LEFT JOIN PRODUCT p on orderp.BARCODE = p.BARCODE " +
                    "LEFT JOIN store_price sp on orderp.BARCODE = sp.BARCODE and orderp.STORE_ID = sp.STORE_ID;";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setLong(1, orderID);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                FindItemResponse findItemResponse = new FindItemResponse(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getDouble(4));
                orderItems.add(findItemResponse);
            }
            connection.close();
            return orderItems;
        }

        catch (SQLException e) {

            throw new InvalidAttributesException("Error in find order items " + orderID);
        }
    }




}
