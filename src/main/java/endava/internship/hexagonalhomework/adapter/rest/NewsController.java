package endava.internship.hexagonalhomework.adapter.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import endava.internship.hexagonalhomework.domain.service.NewsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("news")
    public List<NewsDto> getNews(@RequestParam int offset, @RequestParam int limit){
        return newsService.getNewsPage(offset, limit);
    }

}
