package com.aaslin.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaslin.librarysystem.model.IssuedBook;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer> {
    List<IssuedBook> findByUser_UserNum(String userNum);

    List<IssuedBook> findByIsReturnedFalseOrderByIssueDateDesc();

    IssuedBook findFirstByBook_BookIdAndIsReturnedFalseOrderByIssueDateDesc(Integer bookId);

    List<IssuedBook> findByUser_UserNumOrderByIssueDateDesc(String userNum);
}


