package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.QuestionNotFoundException;
import com.employeessystem.backend.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findQuestionByCategory(Integer categoryId) throws CategoryNotFoundException;
    List<Question> findAllQuestions() throws QuestionNotFoundException;
    Question createQuestion(Question question);

}
