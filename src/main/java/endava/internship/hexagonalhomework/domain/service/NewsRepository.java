package endava.internship.hexagonalhomework.domain.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import endava.internship.hexagonalhomework.domain.entity.NewsEntity;

public interface NewsRepository extends PagingAndSortingRepository<NewsEntity, Long> {

}
