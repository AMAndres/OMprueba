package dev.amandres.omprueba.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.amandres.omprueba.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.amandres.omprueba.repository.OrderRepository;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    
    @GetMapping("getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orderList = new ArrayList<>();
            orderRepo.findAll().forEach(orderList::add);
            
            if (orderList.isEmpty()) {
                return new ResponseEntity<>(orderList, HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Optional<Order> orderData = orderRepo.findById(id);

        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order readOrder = orderRepo.save(order);
        return new ResponseEntity<>(readOrder, HttpStatus.OK);
    }

    // @PostMapping("/updateOrderById/{id}")
    // public void updateOrderById(@PathVariable Long id, @RequestBody Order newOrderData) {
    //     Optional<Order> oldOrderData = orderRepo.findById(id)

    //     if(oldBookData.isPresent()) {
    //         Order udpatedOrderData = oldOrderData.get()
    //         udpatedOrderData.setTitle(newOrderData.getTitle());
    //     }
        
    // }
    
    @DeleteMapping
    public void deleteOrderById() {
        
    }

}
