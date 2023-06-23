package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserVoteRepository extends JpaRepository<UserVote, Long> { }