package superPrice.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import superPrice.orders.model.DTO.*;
import superPrice.orders.model.Order;
import superPrice.orders.service.OrderService;

import javax.naming.directory.InvalidAttributesException;
import java.sql.SQLException;

@CrossOrigin
@RestController
@RequestMapping(value = "order")
public class OrderController {
    private final OrderService service;

    @Autowired
    public OrderController(OrderService orderService) {
        this.service = orderService;
    }
    @PostMapping
    public ResponseEntity createOrder(@RequestBody NewOrderRequest order) throws SQLException, InvalidAttributesException {
        try {
            NewOrderResponse o = service.creatingOrderAndItem(order,order.getOrderItems());
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity findOrder(@PathVariable long id) {
        try {
            FindOrderItemResponse orderItemResponse = service.findOrderItemByID(id);
            return new ResponseEntity<>(orderItemResponse, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


}
