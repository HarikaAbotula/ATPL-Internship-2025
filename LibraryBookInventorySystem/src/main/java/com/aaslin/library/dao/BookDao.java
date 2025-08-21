package com.aaslin.library.dao;

import com.aaslin.library.model.Book;
import com.aaslin.library.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class to handle CRUD operations for Book.
 */

/**
 * Soft deletes a book by setting is_active = false and updating audit fields.
 * bookId Book ID to be soft deleted
 * updatedBy User who performed the deletion
 * updatedDate Date and time of update
 * true if update succeeded, false otherwise
 */
public class BookDao {

   
     //Add a new book to the database.
   
    public boolean addBook(Book book) {
        String query = "INSERT INTO book (book_id, title, author, isbn, is_available, is_active, created_date, created_by, updated_date, updated_by)"
                   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getIsbn());
            ps.setBoolean(5, book.isAvailable());
            ps.setBoolean(6, book.isActive());
            ps.setTimestamp(7, new Timestamp(book.getCreatedDate().getTime()));
            ps.setString(8, book.getCreatedBy());
            ps.setTimestamp(9, new Timestamp(book.getUpdatedDate().getTime()));
            ps.setString(10, book.getUpdatedBy());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   
     //Retrieve all active books from the database.
    
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE is_active = TRUE";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setAvailable(rs.getBoolean("is_available"));
                book.setActive(rs.getBoolean("is_active"));
                book.setCreatedDate(rs.getTimestamp("created_date"));
                book.setCreatedBy(rs.getString("created_by"));
                book.setUpdatedDate(rs.getTimestamp("updated_date"));
                book.setUpdatedBy(rs.getString("updated_by"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //Soft delete a book (set is_active = false).
     
    public boolean softDeleteBook(int bookId, String updatedBy, java.util.Date updatedDate) {
        String sql = "UPDATE book SET is_active = FALSE, updated_date = NOW(), updated_by = ? WHERE book_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, updatedBy);
            ps.setInt(2, bookId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update availability status (used during issue/return).
     
    public boolean updateAvailability(int bookId, boolean isAvailable, String updatedBy) {
        String sql = "UPDATE book SET is_available = ?, updated_date = NOW(), updated_by = ? WHERE book_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBoolean(1, isAvailable);
            ps.setString(2, updatedBy);
            ps.setInt(3, bookId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setAvailable(rs.getBoolean("is_available"));
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateBook(int id, String title, String author, String isbn, boolean available) {
        String sql = "UPDATE book SET title = ?, author = ?, isbn = ?, is_available = ?, updated_date = NOW() WHERE book_id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, isbn);
            ps.setBoolean(4, available);
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
