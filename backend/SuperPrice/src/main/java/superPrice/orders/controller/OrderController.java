package superPrice.orders.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import superPrice.orders.model.DTO.ErrorResponse;
import superPrice.orders.model.DTO.FindOrderItemResponse;
import superPrice.orders.model.DTO.NewOrderRequest;
import superPrice.orders.model.DTO.NewOrderResponse;
import superPrice.orders.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping(value = "order")
public class OrderController {
    private final OrderService service;

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody NewOrderRequest order) {
        try {
            NewOrderResponse o = service.creatingOrderAndItem(order, order.getOrderItems());
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findOrder(@PathVariable long id) {
        try {
            FindOrderItemResponse orderItemResponse = service.findOrderItemByID(id);
            return new ResponseEntity<>(orderItemResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


}
