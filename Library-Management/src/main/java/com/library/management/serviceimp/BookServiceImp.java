package com.library.management.serviceimp;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.management.dto.BookDTO;
import com.library.management.dto.ServiceResponse;
import com.library.management.entity.BookEntity;
import com.library.management.repository.BookRepository;
import com.library.management.repository.specifications.SecurityUserSpec;
import com.library.management.service.BookService;

@Service
public class BookServiceImp implements BookService
{
	private static Logger logger = LogManager.getLogger(BookServiceImp.class);

	@Autowired
	BookRepository bookrepo;
	
	public ServiceResponse creatBooKEntry(BookDTO bookdto)
	{
		BookEntity bookentity=new BookEntity();
		try
		{
			bookentity.setAuthor(bookdto.getAuthor());
			bookentity.setIsbn(bookdto.getIsbn());
			bookentity.setNumberOfPages(bookdto.getNumberOfPages());
			bookentity.setTitle(bookdto.getTitle());
			bookentity.setStatus("INSTOCK");
			if(bookrepo.save(bookentity)!=null)
			return new ServiceResponse("Entered Successfully","Entered Successfully",null);
			else
			return new ServiceResponse("Not Entered Successfully","Not Entered Successfully",null);
		}
		catch(Exception e)
		{
			logger.error("Error:" + e.getMessage(), e);

			return new ServiceResponse("Exception Occured","Exception Occured",null);
		}

	}
	
	
	
	public JSONObject searchforBooks(String searchParam) {
		JSONObject result = new JSONObject();
		try {
//			PageRequest pageable = PageRequest.of(start / pageSize, pageSize);
			Specification<BookEntity> spec = SecurityUserSpec.getUserSpec(searchParam);
			List<BookEntity> usersList = bookrepo.findAll(spec);
			JSONArray array = new JSONArray();
//			JSONArray countByStatus = countByStatus(spec);
			for (BookEntity users : usersList) {
				JSONObject obj = new JSONObject();
				obj.put("Author", users.getAuthor());
				obj.put("isbn", users.getIsbn());
				obj.put("Title", users.getTitle());
				obj.put("Number", users.getNumberOfPages());
				obj.put("status", users.getStatus());
				array.add(obj);
			}
			result.put("aaData", array);
//			result.put("iTotalDisplayRecords", studentrepo.findAll(spec).size());
//			result.put("iTotalRecords", studentrepo.findAll(spec).size());
//			result.put("countByStatus", countByStatus);
		} catch (Exception e) {
//			logger.error("Error : " + e.getMessage(), e);
			logger.error("Error:" + e.getMessage(), e);
		}
		return result;
	}
	
	private JSONArray countByStatus(Specification<BookEntity> spec) {
		JSONArray array = new JSONArray();
		try {
			List<BookEntity> headerList = bookrepo.findAll(spec);
			Map<String, Long> countByStatus = headerList.stream()
					.collect(Collectors.groupingBy(BookEntity::getStatus, Collectors.counting()));
			for (String status : countByStatus.keySet()) {
				JSONObject obj = new JSONObject();
				obj.put("name", status);
				obj.put("count", countByStatus.get(status));
				array.add(obj);
			}
		} catch (Exception e) {
			logger.error("Error:" + e.getMessage(), e);
		}
		return array;
	}
	
	public JSONObject getall()
	{
		
		JSONObject result = new JSONObject();
		try {
			List<BookEntity> usersList = bookrepo.findAll();
			JSONArray array = new JSONArray();
			for (BookEntity users : usersList) 
			{
				JSONObject obj = new JSONObject();
				obj.put("Author", users.getAuthor());
				obj.put("isbn", users.getIsbn());
				obj.put("Title", users.getTitle());
				obj.put("Number", users.getNumberOfPages());
				obj.put("status", users.getStatus());
				array.add(obj);
			}
			result.put("bookdata", array);
		} 
		catch (Exception e) 
		{
			logger.error("Error:" + e.getMessage(), e);
		}
		return result;
	}
	
	public ResponseEntity<?> getByISBN(String isbn)
	{
		try
		{
			Optional<BookEntity> book=bookrepo.findById(isbn);
			BookEntity bentity=book.get();
			return new ResponseEntity(bentity,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error("Error:" + e.getMessage(), e);
			return new ResponseEntity("Exception Eroor Occured",HttpStatus.OK);
		}

		
	}
	

}
