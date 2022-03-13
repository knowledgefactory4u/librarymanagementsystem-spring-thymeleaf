package com.quickstartdev.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickstartdev.librarymanagementsystem.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
