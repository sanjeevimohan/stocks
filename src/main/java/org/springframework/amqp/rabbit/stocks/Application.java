package org.springframework.amqp.rabbit.stocks;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.stocks.web.QuoteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.amqp.core.Queue;

import java.text.SimpleDateFormat;
import java.util.Date;

//@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final RabbitTemplate template;

    @Autowired
    public Application(RabbitTemplate template) {
        this.template = template;
    }

    @Bean
    Queue queue() {
        return new Queue("marketDataQueue", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("app.stock.marketdata");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("app.stock.quotes.nasdaq");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("marketDataQueue");
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(QuoteController receiver) {
        return new MessageListenerAdapter(receiver, "handleQuote");
    }


    @Bean
    Queue tradeQueue() {
        return new Queue("tradeQueue", false);
    }

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("broadcast.responses");
    }

    @Bean
    Binding fanoutBinding(Queue tradeQueue, FanoutExchange fanout) {
        return BindingBuilder.bind(tradeQueue).to(fanout);
    }

    @Bean
    SimpleMessageListenerContainer tradeQueueContainer(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter tradeQueueListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("tradeQueue");
        container.setMessageListener(tradeQueueListenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter tradeQueueListenerAdapter(QuoteController receiver) {
        return new MessageListenerAdapter(receiver, "handleTrade");
    }

//    @Scheduled(fixedRate = 1000)
//    public void sendMessage() {
//        System.out.println("Called sendMessage ***");
//        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
//        String message = "Hello world! " + timestamp;
//
//        this.template.convertAndSend("spring-boot", message);
//    }

//    @Bean
//    public Queue queue() {
//        return new Queue("spring-boot", false);
//    }
}
