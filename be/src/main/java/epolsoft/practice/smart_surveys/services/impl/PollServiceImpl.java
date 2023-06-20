package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.repository.PollRepository;
import epolsoft.practice.smart_surveys.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepository pollRepository;

    @Override
    public Poll getPollById(Long id) {
        checkById(id);
        return pollRepository.findById(id).get();
    }

    public void checkById(Long id) throws ResponseStatusException {
        if (!pollRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Не найден пул с таким id в базе данных"
            );
        }
    }
}
