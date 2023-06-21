package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
