package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
