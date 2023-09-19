package superPrice.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import superPrice.orders.model.Order;
import superPrice.orders.model.OrderDTO;
import superPrice.orders.service.OrderService;
import superPrice.storePrice.service.StorePriceService;

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
    public ResponseEntity newOrder(@RequestBody OrderDTO order) {
        try {
            Order o = service.creatingOrder(order);
            return new ResponseEntity<Order>(o, HttpStatus.CREATED);
        }
        catch(InvalidAttributesException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid delivery time");
        }

    }
}
