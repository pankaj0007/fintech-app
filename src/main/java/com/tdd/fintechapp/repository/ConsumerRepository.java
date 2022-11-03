package com.tdd.fintechapp.repository;

import com.tdd.fintechapp.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
}
