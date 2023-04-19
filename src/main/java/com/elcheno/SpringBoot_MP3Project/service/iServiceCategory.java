package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.CategoryList;

import java.util.List;

public interface iServiceCategory {
    List<CategoryList> getAllCategoryList(); //devuelve una lista de todas las categorias
    CategoryList getCategoryListById(int id); //devuelve una categoria por su id
}
