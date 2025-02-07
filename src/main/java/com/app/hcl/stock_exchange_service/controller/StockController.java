package com.app.hcl.stock_exchange_service.controller;

import com.app.hcl.stock_exchange_service.entity.Stock;
import com.app.hcl.stock_exchange_service.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stock")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

   //http://localhost:8080/api/v1/stock?stockId=9&newPrice=1100
    @PutMapping("/stock")
    public Stock updateStockPrice(@RequestParam Long stockId, @RequestParam BigDecimal newPrice) {
        return stockService.updateStockPrice(stockId, newPrice);
    }
}