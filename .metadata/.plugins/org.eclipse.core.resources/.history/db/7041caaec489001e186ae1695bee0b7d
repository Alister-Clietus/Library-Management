package com.library.book.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="BOOKING_DETAILS")
public class LibraryEntity 
{
	@EmbeddedId
	BookingID id;
	@Column(name="BOOKED")
    private boolean booked;
	@Column(name="BORROWED_DATE")
    private String borrowedDate;
	@Column(name="RETURNED_DATE")
    private String returnedDate;
	@Column(name="RETURNED_LATE")
    private boolean returnedLate;
	@Column(name="DUE_AMOUNT")
    private int dueAmount;
	
	
	public BookingID getId() {
		return id;
	}
	public void setId(BookingID id) {
		this.id = id;
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
