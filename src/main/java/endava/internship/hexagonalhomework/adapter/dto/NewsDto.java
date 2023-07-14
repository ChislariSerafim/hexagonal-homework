package endava.internship.hexagonalhomework.adapter.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {

    private String title;

    private String content;

    private String date;

    private Short priority;

    private List<String> tags;

}
