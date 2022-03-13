package com.quickstartdev.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickstartdev.librarymanagementsystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
