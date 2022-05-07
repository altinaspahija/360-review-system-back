package com.employeessystem.backend.dto;

import com.employeessystem.backend.model.Question;
import lombok.Data;

@Data
public class QuestionDto {

  private int questionId;
  private String question;

  public static Question getQuestion(QuestionDto questionDto){
    if (questionDto==null) return null;
    Question question = new Question();
    question.setQuestionId(questionDto.getQuestionId());
    question.setQuestion(questionDto.getQuestion());
    return question;
  }

  public static QuestionDto getQuestionDto(Question question){
    if (question==null) return null;
    QuestionDto questionDto = new QuestionDto();
    questionDto.setQuestionId(question.getQuestionId());
    questionDto.setQuestion(question.getQuestion());
    return questionDto;
  }

}
