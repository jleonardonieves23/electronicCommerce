package com.stomp.websocket.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stomp.websocket.infrastructure.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
