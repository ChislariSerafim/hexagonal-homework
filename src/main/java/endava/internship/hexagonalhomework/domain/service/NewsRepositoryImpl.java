package endava.internship.hexagonalhomework.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import endava.internship.hexagonalhomework.domain.entity.NewsEntity;
import endava.internship.hexagonalhomework.domain.entity.TagEntity;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public abstract class NewsRepositoryImpl implements NewsRepository{

    private final String GET_NEWS_BY_TAG = "SELECT title, content, date, priority FROM news"
            + " JOIN news_tag on (news_tag.news_id = news.id)"
            + " WHERE tag = ':tag'";

    private final NewsRowMapper newsRowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<NewsEntity> getNewsByTag(TagEntity tagEntity){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("tag", tagEntity.getName());
        return jdbcTemplate.query(GET_NEWS_BY_TAG, parameters, newsRowMapper);
    }

}
