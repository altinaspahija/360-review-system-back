package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.QuestionNotFoundException;
import com.employeessystem.backend.model.Question;
import com.employeessystem.backend.repository.QuestionRepository;
import com.employeessystem.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> findQuestionByCategory(Integer categoryId) throws CategoryNotFoundException {
        return questionRepository.findQuestionByCategory(categoryId);
    }

    @Override
    public List<Question> findAllQuestions() throws QuestionNotFoundException {
        return questionRepository.findAll();
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

}
