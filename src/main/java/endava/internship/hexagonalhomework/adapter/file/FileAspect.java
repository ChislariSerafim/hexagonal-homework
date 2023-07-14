package endava.internship.hexagonalhomework.adapter.file;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import endava.internship.hexagonalhomework.adapter.dto.NewsDto;
import endava.internship.hexagonalhomework.domain.service.FileService;
import lombok.RequiredArgsConstructor;

@Component
@Aspect
@RequiredArgsConstructor
public class FileAspect {

        private final FileService fileService;

        @Pointcut("@annotation(FileOutput)")
        public void pointcut(){}

        @After("pointcut()")
        public void saveToFile(JoinPoint joinPoint){
            NewsDto newsDto = (NewsDto) joinPoint.getArgs()[0];
            fileService.saveNews(newsDto);
        }
    }
