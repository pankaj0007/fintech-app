package com.tdd.fintechapp.service;

import com.tdd.fintechapp.model.Consumer;
import com.tdd.fintechapp.repository.ConsumerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsumerServiceTest {

    @Mock
    private ConsumerRepository consumerRepository;

    @InjectMocks
    private ConsumerService consumerService;

    private Consumer consumer;

    @BeforeEach
    public void setup(){
        consumer = new Consumer(1, "Pankaj", "Mishra", 123);
    }
    @Test
    public void saveConsumerTest(){
        Mockito.when(consumerRepository.save(consumer)).thenReturn(consumer);

        Consumer consumer1 = consumerService.saveConsumer(consumer);
        Assertions.assertNotNull(consumer1);
    }


}
