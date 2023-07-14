package endava.internship.hexagonalhomework.adapter.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import endava.internship.hexagonalhomework.domain.service.NewsService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewsListener implements MessageListener {

    private final ObjectMapper objectMapper;

    private final NewsService newsService;

    public void onMessage(Message message) {
        String data = new String(message.getBody());
        NewsDto newsDto = null;
        try {
            newsDto = objectMapper.readValue(data, NewsDto.class);
        } catch (JsonProcessingException e) {
            System.out.println("Message not readable!");
        }
        newsService.addNews(newsDto);
    }

}
