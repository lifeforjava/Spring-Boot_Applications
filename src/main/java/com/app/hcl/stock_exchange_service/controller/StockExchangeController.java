package com.app.hcl.stock_exchange_service.controller;

import com.app.hcl.stock_exchange_service.entity.Stock;
import com.app.hcl.stock_exchange_service.entity.StockExchange;
import com.app.hcl.stock_exchange_service.service.StockExchangeService;
import com.app.hcl.stock_exchange_service.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @Autowired
    private StockService stockService;


    @GetMapping("/stock-exchange/{stockExchangeName}")
    public StockExchange getStockExchange(@PathVariable String stockExchangeName) {
        Optional<StockExchange> stockExchange = stockExchangeService.getStockExchangeByName(stockExchangeName);
        if (stockExchange.isEmpty()) {
            throw new RuntimeException("Stock Exchange not found");
        }

        StockExchange exchange = stockExchange.get();
        exchange.setLiveInMarket(stockExchangeService.isStockExchangeLive(exchange));

        return exchange;

    }


    @PostMapping("/stock-exchange")
    public StockExchange createStockExchange(@RequestBody StockExchange stockExchange) {
        return stockExchangeService.createStockExchange(stockExchange);
    }


    @PostMapping("/stock-exchange/{stockExchangeName}")
    public StockExchange addStockToExchange(@PathVariable String stockExchangeName, @RequestBody Stock stock) {
        Optional<StockExchange> stockExchange = stockExchangeService.getStockExchangeByName(stockExchangeName);
        if (stockExchange.isEmpty()) {
            throw new RuntimeException("Stock Exchange not found");
        }

        Stock createdStock = stockService.createStock(stock);
        stockExchange.get().getStocks().add(createdStock);
        return stockExchangeService.createStockExchange(stockExchange.get());
    }

}