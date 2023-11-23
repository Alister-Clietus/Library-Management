package com.library.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.library.book.entity.BookingID;
import com.library.book.entity.LibraryEntity;

@Repository
public interface LibraryBorrow extends JpaRepository<LibraryEntity, BookingID>,JpaSpecificationExecutor<LibraryEntity>
{
	
}
