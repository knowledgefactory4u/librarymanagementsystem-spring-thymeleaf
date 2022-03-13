package com.quickstartdev.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickstartdev.librarymanagementsystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
