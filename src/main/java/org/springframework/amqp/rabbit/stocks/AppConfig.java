package org.springframework.amqp.rabbit.stocks;

import org.springframework.amqp.rabbit.stocks.handler.ClientHandler;
import org.springframework.amqp.rabbit.stocks.ui.StockController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClientHandler clientHandler() {
        ClientHandler clientHandler = new ClientHandler();
        clientHandler.setStockController(new StockController());
        return clientHandler;
    }
}
