package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVoteRepository extends JpaRepository<UserVote, Long> {
}
