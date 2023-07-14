package endava.internship.hexagonalhomework.adapter.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import endava.internship.hexagonalhomework.domain.entity.NewsEntity;
import endava.internship.hexagonalhomework.domain.entity.TagEntity;

@Mapper
public interface NewsMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public NewsDto toDto(NewsEntity newsEntity);

    public NewsEntity toEntity(NewsDto newsDto);

    public default String tagToString(TagEntity tagEntity){
        return tagEntity.getName();
    }

    public default TagEntity StringToTag(String tag){
        return new TagEntity(tag);
    }

    public default String localDateToString(LocalDate localDate){
        return formatter.format(localDate);
    }

    public default LocalDate stringToLocalDate(String localDate){
        return LocalDate.parse(localDate, formatter);
    }

}
