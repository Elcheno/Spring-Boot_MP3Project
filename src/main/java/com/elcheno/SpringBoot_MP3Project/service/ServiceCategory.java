package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.CategoryList;
import com.elcheno.SpringBoot_MP3Project.repository.RepositoryCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory implements iServiceCategory{
    private RepositoryCategory repository;

    public ServiceCategory(RepositoryCategory repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryList> getAllCategoryList() {
        return repository.findAll();
    }

    public void save(CategoryList category){
        repository.save(category);
    }
}
