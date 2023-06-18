package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import epolsoft.practice.smart_surveys.services.impl.UserVoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey/{id}")
public class UserVoteController {
    @Autowired
    private UserVoteService userVoteService;

    @PostMapping("/submit")
    public ResponseEntity<UserVote> createUserVote(@RequestBody UserVote userVote){
        UserVote userVoteCreated = this.userVoteService.createUserVote(userVote);
        return new ResponseEntity<UserVote>(userVoteCreated, HttpStatus.CREATED);
    }
}
