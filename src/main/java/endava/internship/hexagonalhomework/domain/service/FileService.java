package endava.internship.hexagonalhomework.domain.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FileService {

    private final ObjectMapper objectMapper;

    public void saveNews(NewsDto newsDto) {
        File file = new File( "C:\\News\\" + newsDto.getTitle().substring(0, 20) + ".txt");
        try {
            file.createNewFile();
            try (final FileOutputStream fileOutputStream = new FileOutputStream(file);
                    final ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
                out.writeObject(objectMapper.writeValueAsString(newsDto));
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
