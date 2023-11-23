package com.library.book.serviceImp;

import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.dto.LibraryDTO;
import com.library.book.dto.ServiceResponse;
import com.library.book.entity.BookingID;
import com.library.book.entity.LibraryEntity;
import com.library.book.repository.LibraryBorrow;
import com.library.book.service.LibraryBorrowSevice;

@Service
public class LibraryBorrowSeviceImp implements LibraryBorrowSevice
{
	private static Logger logger = LogManager.getLogger(LibraryBorrowSeviceImp.class);

	@Autowired 
	LibraryBorrow repo;
	
	public ServiceResponse borrowBook(LibraryDTO dto)
	{
		
		LibraryEntity entity =new LibraryEntity();
		BookingID id=new BookingID();
		try
		{
			id.setIsbn(dto.getIsbn());
			id.setUsername(dto.getUserName());
			entity.setId(id);
			entity.setBooked(true);
			entity.setBorrowedDate(dto.getBorrowedDate());
			entity.setReturnedDate(null);
			entity.setReturnedLate(false);
			entity.setDueAmount(0);
			repo.save(entity);
			return new ServiceResponse("Book Booked Successfully","Book Booked Successfully",null);
			
		}
		catch(Exception e)
		{
			logger.error("Error:" + e.getMessage(), e);
			return new ServiceResponse("Exception Occured","Exception Occured",null);
		}
	}
	
	public ServiceResponse returnBook(LibraryDTO dto)
	{
		Date date=new Date();
		BookingID id=new BookingID();
		try
		{
			id.setIsbn(dto.getIsbn());
			id.setUsername(dto.getUserName());
			Optional<LibraryEntity> details=repo.findById(id);
			LibraryEntity entity=details.get();
			entity.setReturnedDate(dto.getReturnedDate());
			entity.setReturnedLate(dto.isReturnedLate());
			entity.setDueAmount(dto.getDueAmount());
			repo.save(entity);
			return new ServiceResponse("Book Returned Successfully","Book Booked Successfully",null);
			
		}
		catch(Exception e)
		{
			logger.error("Error:" + e.getMessage(), e);
			return new ServiceResponse("Exception Occured","Exception Occured",null);
		}
	}

}
