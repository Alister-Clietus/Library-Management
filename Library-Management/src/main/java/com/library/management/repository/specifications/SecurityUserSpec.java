package com.library.management.repository.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.library.management.entity.BookEntity;

public class SecurityUserSpec {
	public static Specification<BookEntity> getUserSpec(String searchParam) {
		return new Specification<BookEntity>() {
			public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate finalPredicate = null;
				JSONParser parser = new JSONParser();
				JSONObject searchObject;
				try {
					searchObject = (JSONObject) parser.parse(searchParam);
					String title = (String) searchObject.get("title");
					String author = (String) searchObject.get("author");
					String isbn = (String) searchObject.get("isbn");
					Long numberOfPages = (Long) searchObject.get("numberOfPages");
					
		            if(!StringUtils.isEmpty(title)) {
		            	System.out.println("here");
		            	Predicate titlePredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("title")),"%"+title.toUpperCase()+"%");
		            	finalPredicate = criteriaBuilder.and(titlePredicate);
		            }
		            
		            if(!StringUtils.isEmpty(author)) {
		            	System.out.println("author");
		            	Predicate authorPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("author")),"%"+author.toUpperCase()+"%");
		            	if(finalPredicate!=null) {
		            		authorPredicate = criteriaBuilder.and(finalPredicate, authorPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(authorPredicate);
		            	}
		            	
		            }
		            
		            if(numberOfPages!=0) {
		            	System.out.println("no of pages");
		            	Predicate numberOfPagesPredicate = criteriaBuilder.equal(root.get("numberOfPages"),numberOfPages);
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate, numberOfPagesPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(numberOfPagesPredicate);
		            	}
		            }
		            
		            if(!StringUtils.isEmpty(isbn)) {
		            	System.out.println("isbn");
		            	Predicate isbnPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("isbn")), "%"+isbn.toUpperCase()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate, isbnPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(isbnPredicate);
		            	}
		            }
		            
		            Order proTimeOrder = criteriaBuilder.desc(root.get("numberOfPages"));
		            query.orderBy(proTimeOrder);
		            
				} catch (ParseException e) 
				{
					e.printStackTrace();
				}
	            
				return finalPredicate;
			}
		};
	}
}

