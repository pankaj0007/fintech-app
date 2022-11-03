package com.tdd.fintechapp.controller;

import com.tdd.fintechapp.model.Consumer;
import com.tdd.fintechapp.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping
    public ResponseEntity<Consumer> createConsumer(@RequestBody Consumer consumer){
        System.out.println(consumer.getFirstName()+ consumer.getLastName());
        Consumer dbConsumer = consumerService.saveConsumer(consumer);
        return  new ResponseEntity<>(dbConsumer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumer(@PathVariable("id") Integer id){
        Consumer dbConsumer = consumerService.getConsumerById(id);
        return  new ResponseEntity<>(dbConsumer, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Consumer>> getAllConsumer(){
        List<Consumer> list = consumerService.getALlConsumer();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable("id") Integer id, @RequestBody Consumer consumer){
        System.out.println(consumer.getFirstName()+ consumer.getLastName());
        return  new ResponseEntity<>(consumer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consumer> deleteConsumer(@PathVariable("id") Integer id){
        Consumer consumer1 = new Consumer(1, "Pankaj", "Mishra", 123);
        //consumer.setTaxId(456);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
