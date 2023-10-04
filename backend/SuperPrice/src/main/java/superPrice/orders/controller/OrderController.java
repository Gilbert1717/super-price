package superPrice.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import superPrice.orders.model.DTO.FindOrderItemResponse;
import superPrice.orders.model.DTO.FindOrderResponse;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.model.Order;
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
            NewOrderResponse o = service.creatingOrderAndItem(order,order.getOrderItems());
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity getOrder(@PathVariable long id) {
        try {
            FindOrderItemResponse orderItemResponse = service.findOrderItemByID(id);
            return new ResponseEntity<>(orderItemResponse, HttpStatus.OK);
        }
        catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
