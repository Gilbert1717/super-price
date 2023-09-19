package superPrice.orders.repository;

import superPrice.orders.model.Order;

public interface OrderRepository {
    Order create(Order order);
}
