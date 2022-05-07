package com.employeessystem.backend.service.implementation;

import com.employeessystem.backend.exception.CategoryNotFoundException;
import com.employeessystem.backend.model.CategoriesByDesc;
import com.employeessystem.backend.model.CategoryQuestions;
import com.employeessystem.backend.model.Goals;
import com.employeessystem.backend.repository.CategoryQuestionsRepository;
import com.employeessystem.backend.service.CategoryQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CategoryQuestionsServiceImplementation implements CategoryQuestionsService {

    @Autowired
    CategoryQuestionsRepository categoryQuestionsRepository;

    @Override
    public List<CategoriesByDesc> getCategories() throws CategoryNotFoundException {
        return categoryQuestionsRepository.getCategories();
    }

    @Override
    public List<Goals> getRatingsByEmployeeAndCategory(Integer employeeId, String categoryTitle) throws CategoryNotFoundException, InvalidParameterException {
        return categoryQuestionsRepository.getRatingsByEmployeeAndCategory(employeeId,categoryTitle);
    }

    @Override
    public List<CategoriesByDesc> getCategoriesAndQuestions() throws CategoryNotFoundException {
        return categoryQuestionsRepository.getCategoriesAndQuestions();
    }

    @Override
    public List<CategoriesByDesc> getCategoriesAndQuestionsByCategory(String categoryDescription) throws CategoryNotFoundException {
        return categoryQuestionsRepository.getCategoriesAndQuestionsByCategory(categoryDescription);
    }

    @Override
    public List<CategoryQuestions> getAllCategoriesData() throws CategoryNotFoundException{
        return categoryQuestionsRepository.findAll();
    }

    @Override
    public List<CategoriesByDesc> getCategoriesAndQuestionsDetailsByCategory(String categoryDescription) throws CategoryNotFoundException{
        return categoryQuestionsRepository.getCategoriesAndQuestionsDetailsByCategory(categoryDescription);
    }

}
