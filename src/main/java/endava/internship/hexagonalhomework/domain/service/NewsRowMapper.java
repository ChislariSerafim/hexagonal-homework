package endava.internship.hexagonalhomework.domain.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static java.util.Objects.nonNull;

import org.springframework.jdbc.core.RowMapper;

import endava.internship.hexagonalhomework.domain.entity.NewsEntity;

public class NewsRowMapper implements RowMapper<NewsEntity> {

    @Override
    public NewsEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        NewsEntity news = new NewsEntity();

        news.setTitle(rs.getString("title"));
        news.setContent(rs.getString("content"));
        news.setDate(rs.getDate("date").toLocalDate());
        news.setPriority(rs.getShort("priority"));

        return news;
    }
}
