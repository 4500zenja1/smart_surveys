package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessSurveyRepository extends JpaRepository<AccessSurvey,Long> {
    List<AccessSurvey> findAllByUserId(Long id);
}
