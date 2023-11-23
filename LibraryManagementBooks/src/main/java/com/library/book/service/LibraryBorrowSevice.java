package com.library.book.service;

import com.library.book.dto.LibraryDTO;
import com.library.book.dto.ServiceResponse;

public interface LibraryBorrowSevice 
{
	ServiceResponse returnBook(LibraryDTO dto);
	ServiceResponse borrowBook(LibraryDTO dto);

}
