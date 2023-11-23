package com.library.book.dto;

import jakarta.validation.constraints.NotEmpty;

public class LibraryDTO 
{
	@NotEmpty
    private String isbn;
	
	@NotEmpty
	private String userName;
	
    private boolean booked;
    private String borrowedDate;
    private String returnedDate;
    private boolean returnedLate;
    private int dueAmount;
    
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public String getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	public boolean isReturnedLate() {
		return returnedLate;
	}
	public void setReturnedLate(boolean returnedLate) {
		this.returnedLate = returnedLate;
	}
	public int getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(int dueAmount) {
		this.dueAmount = dueAmount;
	}

}
