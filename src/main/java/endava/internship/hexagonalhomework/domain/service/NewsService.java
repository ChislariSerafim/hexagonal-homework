package endava.internship.hexagonalhomework.domain.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import endava.internship.hexagonalhomework.adapter.file.FileOutput;
import endava.internship.hexagonalhomework.adapter.mapper.NewsMapper;
import endava.internship.hexagonalhomework.domain.entity.NewsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewsService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final NewsRepository newsRepository;

    private final NewsMapper newsMapper;

    public List<NewsDto> getNewsPage(int offset, int limit){
        Pageable pageable = PageRequest.of(offset, limit);
        return newsRepository.findAll(pageable).get().map(newsMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    @FileOutput
    public void addNews(NewsDto newsDto){
        entityManager.persist(newsMapper.toEntity(newsDto));
    }

}
