package com.tdd.fintechapp.service;

import com.tdd.fintechapp.exception.RecordNotFoundException;
import com.tdd.fintechapp.model.Consumer;
import com.tdd.fintechapp.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {
    @Autowired
    private ConsumerRepository consumerRepository;

    public Consumer saveConsumer(Consumer consumer){
        Consumer dbConsumer = consumerRepository.save(consumer);
        return  dbConsumer;
    }

    public Consumer getConsumerById(Integer id)  throws RecordNotFoundException{
        Optional<Consumer> consumer = consumerRepository.findById(id);
        if(consumer.isEmpty())
            throw new RecordNotFoundException("Consumer with id "+ id+ " not found");

        return consumerRepository.findById(id).get();
    }

    public List<Consumer> getALlConsumer() {
        return consumerRepository.findAll();
    }
}
