package com.app.hcl.stock_exchange_service.repository;

import com.app.hcl.stock_exchange_service.entity.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {

    Optional<StockExchange> findByName(String name);
}
