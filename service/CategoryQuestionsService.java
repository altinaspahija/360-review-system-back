package com.employeessystem.backend.service;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.model.CategoriesByDesc;
import com.employeessystem.backend.model.CategoryQuestions;
import com.employeessystem.backend.model.Goals;
import com.employeessystem.backend.model.Question;

import java.security.InvalidParameterException;
import java.util.List;

public interface CategoryQuestionsService {

    List<CategoriesByDesc> getCategories() throws CategoryNotFoundException;
    List<Goals> getRatingsByEmployeeAndCategory(Integer employeeId, String categoryTitle) throws CategoryNotFoundException, InvalidParameterException;
    List<CategoriesByDesc> getCategoriesAndQuestions() throws CategoryNotFoundException;
    List<CategoriesByDesc> getCategoriesAndQuestionsByCategory(String categoryDescription) throws CategoryNotFoundException;
    List<CategoryQuestions> getAllCategoriesData() throws CategoryNotFoundException;
    List<CategoriesByDesc> getCategoriesAndQuestionsDetailsByCategory(String categoryDescription) throws CategoryNotFoundException;

}
