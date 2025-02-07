package com.app.hcl.stock_exchange_service.service;

import com.app.hcl.stock_exchange_service.entity.StockExchange;
import com.app.hcl.stock_exchange_service.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public Optional<StockExchange> getStockExchangeByName(String name) {
        return stockExchangeRepository.findByName(name);
    }

    public StockExchange createStockExchange(StockExchange stockExchange) {
        return stockExchangeRepository.save(stockExchange);
    }

    public boolean isStockExchangeLive(StockExchange stockExchange) {
        return stockExchange.getStocks().size() >= 5;
    }
}