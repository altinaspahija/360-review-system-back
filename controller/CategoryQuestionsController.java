package com.employeessystem.backend.controller;

import com.employeessystem.backend.dto.DepartmentDto;
import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.exception.DepartmentNotFoundException;
import com.employeessystem.backend.exception.QuestionNotFoundException;
import com.employeessystem.backend.model.*;
import com.employeessystem.backend.service.CategoryQuestionsService;
import com.employeessystem.backend.service.DepartmentService;
import com.employeessystem.backend.service.QuestionService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*")
@RestController
public class CategoryQuestionsController {

    @Autowired
    CategoryQuestionsService categoryQuestionsService;
    @Autowired
    QuestionService questionService;

    //http://localhost:9090/categoriesTitles GET
    @GetMapping("categoriesTitles")
    public List<CategoriesByDesc> getCategories() throws CategoryNotFoundException {
        return categoryQuestionsService.getCategories();
    }

    //http://localhost:9090/categories GET
    @GetMapping("categories")
    public List<CategoryQuestions> getAllCategoriesData() throws CategoryNotFoundException {
        return categoryQuestionsService.getAllCategoriesData();
    }

    //http://localhost:9090/ratingsByEmployeeAndCategory GET
    @GetMapping("ratingsByEmployeeAndCategory")
    public List<Goals> getRatingsByEmployeeAndCategory(@RequestParam(required = true) Integer employeeId, @RequestParam(required = true) String categoryTitle) throws CategoryNotFoundException, InvalidParameterException {
        return categoryQuestionsService.getRatingsByEmployeeAndCategory(employeeId,categoryTitle);
    }

    //http://localhost:9090/questionCategories GET
    @GetMapping("questionCategories")
    public List<CategoriesByDesc> getCategoriesAndQuestions() throws CategoryNotFoundException {
        return categoryQuestionsService.getCategoriesAndQuestions();
    }

    //http://localhost:9090/questionCategoriesByCategory/{categoryDescription} GET
    @GetMapping("questionCategoriesByCategory/{categoryDescription}")
    public List<CategoriesByDesc> getQuestionCategoriesByCategory(@PathVariable String categoryDescription) throws CategoryNotFoundException{
        return categoryQuestionsService.getCategoriesAndQuestionsByCategory(categoryDescription);
    }

    //http://localhost:9090/questionsByCategory/{categoryId} GET
    @GetMapping("questionsByCategory/{categoryId}")
    public List<Question> getQuestionsByCategory(@PathVariable Integer categoryId) throws CategoryNotFoundException{
        return questionService.findQuestionByCategory(categoryId);
    }

    //http://localhost:9090/questionsDetailsByCategoryTitle/{categoryDescription} GET
    @GetMapping("questionsDetailsByCategoryTitle/{categoryDescription}")
    public List<CategoriesByDesc> getQuestionsDetailsByCategoryTitle(@PathVariable String categoryDescription) throws CategoryNotFoundException{
        return categoryQuestionsService.getCategoriesAndQuestionsDetailsByCategory(categoryDescription);
    }

    //http://localhost:9090/allQuestions GET
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() throws QuestionNotFoundException {
        return questionService.findAllQuestions();
    }

    //http://localhost:9090/oneQuestionByCategory POST
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/oneQuestionByCategory")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }

}
