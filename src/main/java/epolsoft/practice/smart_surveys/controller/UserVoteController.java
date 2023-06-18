package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.services.impl.UserVoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey/{id}")
public class UserVoteController {
    @Autowired
    private UserVoteServiceImpl userServiceImpl;

    @PostMapping("/submit")
    public ResponseEntity<UserVote> createUser(@RequestBody UserVote userVote){
        UserVote userVoteCreated = this.userServiceImpl.createUserVote(userVote);
        return new ResponseEntity<UserVote>(userVoteCreated, HttpStatus.CREATED);
    }
}
