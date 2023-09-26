package superPrice.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.service.OrderService;

import javax.naming.directory.InvalidAttributesException;

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
    public ResponseEntity newOrder(@RequestBody NewOrderRequest order) {
        try {
            NewOrderResponse o = service.creatingOrder(order,order.getOrderItems());
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
