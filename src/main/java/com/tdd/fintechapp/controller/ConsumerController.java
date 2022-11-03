package com.tdd.fintechapp.controller;

import com.tdd.fintechapp.model.Consumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {


    @PostMapping
    public ResponseEntity<Consumer> createConsumer(@RequestBody Consumer consumer){
        System.out.println(consumer.getFirstName()+ consumer.getLastName());
        //consumer.setTaxId(456);
        return  new ResponseEntity<>(consumer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumer(@PathVariable("id") Integer id){
        Consumer consumer = new Consumer(id, "Pankaj", "Mishra", 123);
        return  new ResponseEntity<>(consumer, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Consumer>> getAllConsumer(){
        Consumer consumer1 = new Consumer(1, "Pankaj", "Mishra", 123);
        List<Consumer> list = new ArrayList<>();
        list.add(consumer1);
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable("id") Integer id, @RequestBody Consumer consumer){
        System.out.println(consumer.getFirstName()+ consumer.getLastName());
        //consumer.setTaxId(456);
        return  new ResponseEntity<>(consumer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consumer> deleteConsumer(@PathVariable("id") Integer id){
        Consumer consumer1 = new Consumer(1, "Pankaj", "Mishra", 123);
        //consumer.setTaxId(456);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
