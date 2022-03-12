package com.quickstartdev.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quickstartdev.librarymanagementsystem.entity.Author;
import com.quickstartdev.librarymanagementsystem.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@RequestMapping("/authors")
	public String findAllAuthors(Model model) {

		model.addAttribute("authors", authorService.findAllAuthors());
		return "list-authors";
	}

	@RequestMapping("/author/{id}")
	public String findAuthorById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("author", authorService.findAuthorById(id));
		return "list-author";
	}

	@GetMapping("/addAuthor")
	public String showCreateForm(Author author) {
		return "add-author";
	}

	@RequestMapping("/add-author")
	public String createAuthor(Author author, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-author";
		}

		authorService.createAuthor(author);
		model.addAttribute("author", authorService.findAllAuthors());
		return "redirect:/authors";
	}

	@GetMapping("/updateAuthor/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("author", authorService.findAuthorById(id));
		return "update-author";
	}

	@RequestMapping("/update-author/{id}")
	public String updateAuthor(@PathVariable("id") Long id, Author author, BindingResult result, Model model) {
		if (result.hasErrors()) {
			author.setId(id);
			return "update-author";
		}

		authorService.updateAuthor(author);
		model.addAttribute("author", authorService.findAllAuthors());
		return "redirect:/authors";
	}

	@RequestMapping("/remove-author/{id}")
	public String deleteAuthor(@PathVariable("id") Long id, Model model) {
		authorService.deleteAuthor(id);

		model.addAttribute("author", authorService.findAllAuthors());
		return "redirect:/authors";
	}

}
