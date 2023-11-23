package com.library.management.service;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

import com.library.management.dto.BookDTO;
import com.library.management.dto.ServiceResponse;

public interface BookService 
{
	
	public ServiceResponse creatBooKEntry(BookDTO bookdto);
	public JSONObject searchforBooks(String searchParam);
	public JSONObject getall();
	public ResponseEntity<?> getByISBN(String isbn);
}
