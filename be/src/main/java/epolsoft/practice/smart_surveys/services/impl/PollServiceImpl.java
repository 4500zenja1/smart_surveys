package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.PollRepository;
import epolsoft.practice.smart_surveys.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void checkById(Long id) throws NotFoundException {
        if (!pollRepository.existsById(id)) {
            throw new NotFoundException(
                    "Не найден пул с таким id в базе данных"
            );
        }
    }
}
