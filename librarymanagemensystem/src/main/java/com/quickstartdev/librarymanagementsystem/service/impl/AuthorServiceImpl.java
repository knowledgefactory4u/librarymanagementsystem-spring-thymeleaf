package com.quickstartdev.librarymanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quickstartdev.librarymanagementsystem.entity.Author;
import com.quickstartdev.librarymanagementsystem.exception.NotFoundException;
import com.quickstartdev.librarymanagementsystem.repository.AuthorRepository;
import com.quickstartdev.librarymanagementsystem.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Author findAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
	}

	@Override
	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		var author = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));

		authorRepository.deleteById(author.getId());
	}

}
