package endava.internship.hexagonalhomework.adapter;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import endava.internship.hexagonalhomework.adapter.amqp.NewsListener;

@Configuration
public class RabbitMqConfig {
    @Value("${rabbitmq.queue}")
    String queueName;


    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, Queue queue, NewsListener newsListener) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(queue);
        simpleMessageListenerContainer.setMessageListener(newsListener);
        return simpleMessageListenerContainer;

    }
}
