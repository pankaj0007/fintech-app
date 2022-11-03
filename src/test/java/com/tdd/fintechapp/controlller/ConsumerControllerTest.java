package com.tdd.fintechapp.controlller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.fintechapp.exception.RecordNotFoundException;
import com.tdd.fintechapp.model.Consumer;
import com.tdd.fintechapp.service.ConsumerService;
import org.assertj.core.api.Assert;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class ConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsumerService consumerService;

    private Consumer consumer;
    private List<Consumer> consumerList;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        consumerList = new ArrayList<>();
        consumer = new Consumer(1, "Pankaj", "Mishra", 123);
        consumerList.add(consumer);
    }

    @Test
    public void createConsumerTest() throws Exception {

        //Mock consumerService save method call
        Mockito.when(consumerService.saveConsumer(Mockito.any())).thenReturn(consumer);



        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                                        .post("/consumer")
                                        .contentType(MediaType.APPLICATION_JSON)
                                         .content(objectMapper.writeValueAsString(consumer)));

        //Verify there was 1 interaction with the repository
        Mockito.verify(consumerService, Mockito.times(1)).saveConsumer(Mockito.any());

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(consumer.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(consumer.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.taxId").value(consumer.getTaxId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idNumber").isNotEmpty());
    }

    @Test
    public void getConsumerTest() throws Exception {

        Mockito.when(consumerService.getConsumerById(Mockito.any())).thenReturn(consumer);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                .get("/consumer/{id}", 1));

        Mockito.verify(consumerService, Mockito.times(1)).getConsumerById(Mockito.any());

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(consumer.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(consumer.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.taxId").value(consumer.getTaxId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idNumber").value(1));
    }

    @Test
    public void getAllConsumerTest() throws Exception {

        Mockito.when(consumerService.getALlConsumer()).thenReturn(consumerList);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                .get("/consumer"));

        Mockito.verify(consumerService, Mockito.times(1)).getALlConsumer();

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(consumerList.size()));
    }

    @Test
    public void updateConsumerTest() throws Exception {

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                .put("/consumer/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(consumer)));

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(consumer.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(consumer.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.taxId").value(consumer.getTaxId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idNumber").isNotEmpty());
    }

    @Test
    public void deleteConsumerTest() throws Exception {

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                .delete("/consumer/{id}", 1));

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
