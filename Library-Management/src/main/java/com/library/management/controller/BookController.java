package com.library.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.dto.BookDTO;
import com.library.management.serviceimp.BookServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController 
{
	
	@Autowired 
	BookServiceImp bookservice;
	
	@PostMapping("/get")
	ResponseEntity<?> getBookbyISBN(@RequestBody String isbn)
	{
		return new ResponseEntity<>(bookservice.getByISBN(isbn),HttpStatus.OK);
	}
	@PostMapping("/add")
	ResponseEntity<?> addBook(@Valid @RequestBody BookDTO bookdto)
	{
		return new ResponseEntity<>(bookservice.creatBooKEntry(bookdto),HttpStatus.OK);
	}
	@GetMapping("/getall")
	ResponseEntity<?> getAllBook()
	{
		return new ResponseEntity<>(bookservice.getall(),HttpStatus.OK);
	}
	@GetMapping("/search")
	ResponseEntity<?> searchBook(@RequestParam("searchParam") String searchParam)
	{
		return new ResponseEntity<>(bookservice.searchforBooks(searchParam),HttpStatus.OK);
	}

}

