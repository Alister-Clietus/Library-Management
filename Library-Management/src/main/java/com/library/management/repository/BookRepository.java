package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.library.management.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String>,JpaSpecificationExecutor<BookEntity>
{
	
}
