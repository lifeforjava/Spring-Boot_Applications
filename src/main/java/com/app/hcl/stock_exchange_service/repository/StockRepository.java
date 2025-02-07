package com.app.hcl.stock_exchange_service.repository;

import com.app.hcl.stock_exchange_service.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}