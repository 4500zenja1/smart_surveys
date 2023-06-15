package epolsoft.practice.smart_surveys.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Опросник",description = "Все методы для работы с опросником")
public class SurveyController {
}
