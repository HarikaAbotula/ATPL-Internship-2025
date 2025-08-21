package com.aaslin.librarysystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaslin.librarysystem.model.Book;
import com.aaslin.librarysystem.model.IssuedBook;
import com.aaslin.librarysystem.model.User;
import com.aaslin.librarysystem.repository.IssuedBookRepository;

@Service
public class IssuedBookService {

	@Autowired
	private IssuedBookRepository issuedBookRepository;

	public List<IssuedBook> getOpenIssues() {
		return issuedBookRepository.findByIsReturnedFalseOrderByIssueDateDesc();
	}

	public List<IssuedBook> getUserIssues(String userNum) {
		return issuedBookRepository.findByUser_UserNum(userNum);
	}

	public List<IssuedBook> getUserHistory(String userNum) {
		return issuedBookRepository.findByUser_UserNumOrderByIssueDateDesc(userNum);
	}

	public IssuedBook getActiveIssueForBook(Integer bookId) {
		return issuedBookRepository.findFirstByBook_BookIdAndIsReturnedFalseOrderByIssueDateDesc(bookId);
	}

	@Transactional
	public IssuedBook issueBook(Book book, User user, String notes, String createdBy) {
		IssuedBook issued = new IssuedBook();
		issued.setBook(book);
		issued.setUser(user);
		issued.setIssueDate(LocalDateTime.now());
		issued.setDueDate(LocalDateTime.now().plusDays(14));
		issued.setNotes(notes);
		issued.setCreatedDate(LocalDateTime.now());
		issued.setCreatedBy(createdBy);
		return issuedBookRepository.save(issued);
	}

	@Transactional
	public IssuedBook markReturned(IssuedBook issued, String updatedBy) {
		issued.setIsReturned(true);
		issued.setReturnDate(LocalDateTime.now());
		issued.setUpdatedDate(LocalDateTime.now());
		issued.setUpdatedBy(updatedBy);
		return issuedBookRepository.save(issued);
	}
}


