package com.app.hcl.stock_exchange_service.service;


import com.app.hcl.stock_exchange_service.entity.Stock;
import com.app.hcl.stock_exchange_service.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.List;
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock createStock(Stock stock) {
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }

    public Stock updateStockPrice(Long stockId, BigDecimal newPrice) {
        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}