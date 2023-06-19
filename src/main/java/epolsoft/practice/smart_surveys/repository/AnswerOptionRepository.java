package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption,Long> {
}
