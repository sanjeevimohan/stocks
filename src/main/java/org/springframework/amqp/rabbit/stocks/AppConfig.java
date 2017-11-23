package org.springframework.amqp.rabbit.stocks;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.stocks.gateway.*;
import org.springframework.amqp.rabbit.stocks.handler.ClientHandler;
import org.springframework.amqp.rabbit.stocks.service.CreditCheckService;
import org.springframework.amqp.rabbit.stocks.service.TradingService;
import org.springframework.amqp.rabbit.stocks.service.stubs.CreditCheckServiceStub;
import org.springframework.amqp.rabbit.stocks.service.stubs.TradingServiceStub;
import org.springframework.amqp.rabbit.stocks.ui.StockController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.stocks.web.QuoteController;
import org.springframework.amqp.rabbit.stocks.service.ExecutionVenueService;
import org.springframework.amqp.rabbit.stocks.service.stubs.ExecutionVenueServiceStub;
import org.springframework.amqp.rabbit.stocks.handler.ServerHandler;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@Configuration
public class AppConfig {

//    @Bean
//    public ServletRegistrationBean main(){
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        applicationContext.register(AppConfig.class);
//        dispatcherServlet.setApplicationContext(applicationContext);
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/");
//        servletRegistrationBean.setName("main");
//        return servletRegistrationBean;
//    }
//
//
//    // servlet-config.xml
//
//    @Value("${defaultReplyTo}")
//    String defaultReplyTo;
//
//    // Defined already in RabbitClientConfiguration.java
////    @Bean
////    public StockServiceGateway stockServiceGateway(@Autowired RabbitTemplate rabbitTemplate) {
////        RabbitStockServiceGateway stockServiceGateway = new RabbitStockServiceGateway();
////        stockServiceGateway.setDefaultReplyTo(defaultReplyTo);
////        stockServiceGateway.setRabbitTemplate(rabbitTemplate);
////        return stockServiceGateway;
////    }
//
//    @Bean
//    public QuoteController quoteController(@Autowired StockServiceGateway stockServiceGateway) {
//        QuoteController quoteController = new QuoteController();
//        quoteController.setStockServiceGateway(stockServiceGateway);
//        return quoteController;
//    }
//
//    // client-handlers.xml
//
//    @Bean
//    public StockController stockController(@Autowired StockServiceGateway stockServiceGateway) {
//        StockController stockController = new StockController();
//        stockController.setStockServiceGateway(stockServiceGateway);
//        return stockController;
//    }
//
//    @Bean
//    public ClientHandler clientHandler(@Autowired StockController stockController) {
//        ClientHandler clientHandler = new ClientHandler();
//        clientHandler.setStockController(stockController);
//        return clientHandler;
//    }
//
//    // server-services.xml
//
//    @Bean
//    public ExecutionVenueService executionVenueService(){
//        return new ExecutionVenueServiceStub();
//    }
//
//    @Bean
//    public CreditCheckService creditCheckService(){
//        return new CreditCheckServiceStub();
//    }
//
//    @Bean
//    public TradingService tradingService(){
//        return new TradingServiceStub();
//    }
//
//    // server-messaging.xml
//
////    @Bean
////    public MarketDataGateway marketDataGateway(@Autowired RabbitTemplate rabbitTemplate){
////        RabbitMarketDataGateway marketDataGateway = new RabbitMarketDataGateway();
////        marketDataGateway.setRabbitTemplate(rabbitTemplate);
////        return marketDataGateway;
////    }
//
//    // server-handlers.xml
//
//    @Bean
//    public ServerHandler serverHandler(@Autowired ExecutionVenueService executionVenueService,
//                                       @Autowired CreditCheckService creditCheckService,
//                                       @Autowired TradingService tradingService){
//        return new ServerHandler(executionVenueService, creditCheckService, tradingService);
//    }
}
