package com.library.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.dto.LibraryDTO;
import com.library.book.service.LibraryBorrowSevice;

@RestController
@RequestMapping("/borrow")
public class LibraryController 
{
	@Autowired
	LibraryBorrowSevice service;
	
	@PostMapping("/getbook")
	ResponseEntity<?> getBooks(@RequestBody LibraryDTO librarydto)
	{
		return new ResponseEntity<>(service.borrowBook(librarydto),HttpStatus.OK);
		
	}
	@PostMapping("/returnbook")
	ResponseEntity<?> returnBooks(@RequestBody LibraryDTO librarydto)
	{
		return new ResponseEntity<>(service.returnBook(librarydto),HttpStatus.OK);
		
	}
	
}
