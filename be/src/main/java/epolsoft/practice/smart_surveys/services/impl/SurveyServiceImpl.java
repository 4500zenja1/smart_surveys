package epolsoft.practice.smart_surveys.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import epolsoft.practice.smart_surveys.dto.AnswerOptionResponseDto;
import epolsoft.practice.smart_surveys.dto.PollRequestDto;
import epolsoft.practice.smart_surveys.dto.SurveyRequestDto;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.entity.enums.AnswerType;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.exceptions.ValidationException;
import epolsoft.practice.smart_surveys.mapper.AnswerOptionMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.repository.SurveyRepository;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
import epolsoft.practice.smart_surveys.services.PollService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private PollService pollService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private AnswerOptionService answerOptionService;

    @Autowired
    private UserVoteService userVoteService;

    @Autowired
    private AnswerOptionMapper answerOptionMapper;

    @Override
    @Transactional
    public Survey createSurvey(SurveyRequestDto surveyRequestDto) {

        Survey survey = surveyMapper.toEntity(surveyRequestDto);

        LocalDateTime openDate = survey.getOpenSurveyDate();
        LocalDateTime closeDate = survey.getCloseSurveyDate();
        LocalDateTime closeIterableDate = survey.getCloseSurveyIterableDate();
        if (!openDate.isBefore(closeDate)) {
            throw new ValidationException(
                    "Дата завершения опроса должна быть строго после даты начала"
            );
        } else if (closeIterableDate.isAfter(closeDate)) {
            throw new ValidationException(
                    "Дата завершения итерации опроса не должна быть после даты окончания самого опроса"
            );
        } else if (closeIterableDate.isBefore(openDate)) {
            throw new ValidationException(
                    "Дата завершения итерации опроса не должна быть до даты начала самого опроса"
            );
        }

        Integer timeAmount = survey.getTimeAmount();
        if (timeAmount == 0 && !closeIterableDate.isEqual(closeDate)) {
            throw new ValidationException(
                    "Если интервал равен 0, то дата завершения итерации опроса должна совпадать с датой окончания самого опроса"
            );
        }

        Long authorId = surveyRequestDto.getAuthorId();
        User author = userService.getUserById(authorId);
        survey.setAuthor(author);

        List<PollRequestDto> pollRequestDtoList = surveyRequestDto.getPolls();
        for (PollRequestDto pollRequestDto : pollRequestDtoList) {
            Poll poll = pollService.createPoll(pollRequestDto);
            poll.setSurvey(survey);
        }

        return surveyRepository.save(survey);
    }

    @Override
    @Transactional(readOnly = true)
    public Survey getSurveyById(Long id) {
        checkById(id);
        return surveyRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Survey> getAllSurveysByUserId(Long id) {
        userService.checkById(id);
        return surveyRepository.findAllByAuthorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Survey getAllAnswersOptionById(Long id) {
        checkById(id);
        Survey survey = surveyRepository.findById(id).get();
        for (Poll poll : survey.getPolls()) {
            Set<AnswerOption> temp = new HashSet<>();
            for (AnswerOption answerOption : poll.getAnswers()) {
                if (answerOption.getAnswerType().equals(AnswerType.OPEN)) {
                    List<UserVote> userVotes = userVoteService.getAllVotesByAnswerId(answerOption.getId());
                    for (UserVote user : userVotes) {
                        AnswerOption userAnswer = new AnswerOption();
                        userAnswer.setAnswerType(AnswerType.OPEN);
                        userAnswer.setOption(user. getText());
                        userAnswer.setVotedCount((int) userVotes.stream()
                                .filter(userVote -> userVote.getText().equals(user.getText()))
                                .count());
                        userAnswer.setId(user.getAnswerOptionId());
                        userAnswer.setOptionImage(answerOption.getOptionImage());
                        userAnswer.setPoll(answerOption.getPoll());
                        temp.add(userAnswer);
                    }
                }
            }
            poll.getAnswers().removeIf(answerOption -> answerOption.getAnswerType().equals(AnswerType.OPEN));
            poll.getAnswers().addAll(temp);
        }
        return survey;
    }

    @Override
    public void updateSurvey(Survey survey, Long id) {
    }

    @Override
    public void deleteSurvey(Long id) {
    }

    @Override
    @Transactional(readOnly = true)
    public void checkById(Long id) throws NotFoundException {
        if (!surveyRepository.existsById(id)) {
            throw new NotFoundException("Не найден опрос с таким id в базе данных");
        }
    }

    @Override
    public Document getReport(Long id, String path, Survey survey) throws FileNotFoundException, DocumentException, JsonProcessingException {
        checkById(id);
        String FILE;

        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);//заголовок опроса
        Font answerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);//ответ
        Font descriptionFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL);//описание
        Font questionFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);//вопрос

        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(path, Map.class);
        String file_path = map.get("path").toString();

        if(file_path.isEmpty())  FILE = "d:/surveyReport_" + id + ".pdf";
        else FILE = file_path;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();

        Paragraph preface = new Paragraph();
        preface.add(new Paragraph(survey.getSurveyTitle(), titleFont));
        preface.add(new Paragraph(" "));
        preface.add(new Paragraph(survey.getSurveyDescription(), descriptionFont));
        preface.add(new Paragraph(" "));

        List<Poll> polls = survey.getPolls();
        for (Poll poll : polls) {
            List<AnswerOption> answers = poll.getAnswers();
            List<AnswerOptionResponseDto> answersDto = answerOptionMapper.toResponseDtos(answers);
            preface.add(new Paragraph(poll.getQuestion(), questionFont));
            for (AnswerOptionResponseDto answer : answersDto) {
                preface.add(new Paragraph(answer.getOption() +
                        " - " + Math.round(answer.getVotedInPercent()) + "% " +
                        "(" + answer.getVotedCount() + ")", answerFont));
            }
            preface.add(new Paragraph(" "));
        }
        document.add(preface);
        document.close();
        return document;
    }
}
