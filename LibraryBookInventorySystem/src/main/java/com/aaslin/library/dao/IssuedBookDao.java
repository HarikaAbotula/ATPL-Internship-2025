package com.aaslin.library.dao;

import com.aaslin.library.model.IssuedBook;
import com.aaslin.library.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssuedBookDao {

    // Issue a book to a user and mark it unavailable
    public boolean issueBook(IssuedBook issuedBook) {
        Connection conn = null;
        PreparedStatement insertIssueStmt = null;
        PreparedStatement updateBookStmt = null;
        boolean success = false;

        String insertSql = "INSERT INTO issued_book (book_id, user_id, issue_date, due_date, is_returned, notes, created_date, created_by, updated_date, updated_by) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String updateBookSql = "UPDATE book SET is_available = FALSE, updated_date = NOW(), updated_by = ? WHERE book_id = ?";

        try {
            conn = DbUtil.getConnection();
            conn.setAutoCommit(false);  // Start transaction

            insertIssueStmt = conn.prepareStatement(insertSql);
            insertIssueStmt.setInt(1, issuedBook.getBookId());
            insertIssueStmt.setInt(2, issuedBook.getUserId());
            insertIssueStmt.setTimestamp(3, new Timestamp(issuedBook.getIssueDate().getTime()));
            insertIssueStmt.setTimestamp(4, new Timestamp(issuedBook.getDueDate().getTime()));
            insertIssueStmt.setBoolean(5, issuedBook.isReturned());
            insertIssueStmt.setString(6, issuedBook.getNotes());
            insertIssueStmt.setTimestamp(7, new Timestamp(issuedBook.getCreatedDate().getTime()));
            insertIssueStmt.setString(8, issuedBook.getCreatedBy());
            insertIssueStmt.setTimestamp(9, new Timestamp(issuedBook.getUpdatedDate().getTime()));
            insertIssueStmt.setString(10, issuedBook.getUpdatedBy());
            insertIssueStmt.executeUpdate();

            updateBookStmt = conn.prepareStatement(updateBookSql);
            updateBookStmt.setString(1, issuedBook.getUpdatedBy());
            updateBookStmt.setInt(2, issuedBook.getBookId());
            updateBookStmt.executeUpdate();

            conn.commit();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try {
                if (insertIssueStmt != null) insertIssueStmt.close();
                if (updateBookStmt != null) updateBookStmt.close();
                if (conn != null) conn.setAutoCommit(true); conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    // Return a book and mark it available
    public boolean returnBook(int issueId, int bookId, Date returnDate, String updatedBy) {
        Connection conn = null;
        PreparedStatement updateIssueStmt = null;
        PreparedStatement updateBookStmt = null;
        boolean success = false;

        // SQL to update the issued_book table to mark book as returned
        String updateIssueSql = "UPDATE issued_book SET " +
                "is_returned = TRUE, " +
                "return_date = ?, " +
                "updated_date = NOW(), " +
                "updated_by = ? " +
                "WHERE issue_id = ?";

        // SQL to mark the book as available again
        String updateBookSql = "UPDATE book SET " +
                "is_available = TRUE, " +
                "updated_date = NOW(), " +
                "updated_by = ? " +
                "WHERE book_id = ?";

        try {
            conn = DbUtil.getConnection();
            conn.setAutoCommit(false);

            // Update issued_book (mark returned)
            updateIssueStmt = conn.prepareStatement(updateIssueSql);
            updateIssueStmt.setTimestamp(1, new Timestamp(returnDate.getTime()));
            updateIssueStmt.setString(2, updatedBy);
            updateIssueStmt.setInt(3, issueId);
            updateIssueStmt.executeUpdate();

            // Update book availability
            updateBookStmt = conn.prepareStatement(updateBookSql);
            updateBookStmt.setString(1, updatedBy);
            updateBookStmt.setInt(2, bookId);
            updateBookStmt.executeUpdate();

            conn.commit();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
        } finally {
            try {
                if (updateIssueStmt != null) updateIssueStmt.close();
                if (updateBookStmt != null) updateBookStmt.close();
                if (conn != null) conn.setAutoCommit(true); conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }


    //  View only currently issued (not yet returned) books
    public List<IssuedBook> getIssuedBooks() {
        List<IssuedBook> list = new ArrayList<>();
        String sql = "SELECT * FROM issued_book WHERE is_returned = FALSE";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //  View ALL issued books (returned + not returned)
    public List<IssuedBook> getAllIssuedBooks() {
        List<IssuedBook> list = new ArrayList<>();
        String sql = "SELECT * FROM issued_book ORDER BY issue_id DESC";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IssuedBook ib = new IssuedBook();
                ib.setIssueId(rs.getInt("issue_id"));
                ib.setBookId(rs.getInt("book_id"));
                ib.setUserId(rs.getInt("user_id"));
                ib.setIssueDate(rs.getTimestamp("issue_date"));
                ib.setDueDate(rs.getTimestamp("due_date"));
                ib.setReturnDate(rs.getTimestamp("return_date"));
                ib.setReturned(rs.getBoolean("is_returned"));
                ib.setNotes(rs.getString("notes"));
                ib.setCreatedDate(rs.getTimestamp("created_date"));
                ib.setCreatedBy(rs.getString("created_by"));
                ib.setUpdatedDate(rs.getTimestamp("updated_date"));
                ib.setUpdatedBy(rs.getString("updated_by"));
                list.add(ib);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //View ALL issued books by searching user id(returned + not returned)
    public List<IssuedBook> getIssuedBooksByUserId(int userId) {
        List<IssuedBook> list = new ArrayList<>();
        String sql = "SELECT * FROM issued_book WHERE user_id = ? ORDER BY issue_id DESC";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    IssuedBook ib = new IssuedBook();
                    ib.setIssueId(rs.getInt("issue_id"));
                    ib.setBookId(rs.getInt("book_id"));
                    ib.setUserId(rs.getInt("user_id"));
                    ib.setIssueDate(rs.getTimestamp("issue_date"));
                    ib.setDueDate(rs.getTimestamp("due_date"));
                    ib.setReturnDate(rs.getTimestamp("return_date"));
                    ib.setReturned(rs.getBoolean("is_returned"));
                    ib.setNotes(rs.getString("notes"));
                    ib.setCreatedDate(rs.getTimestamp("created_date"));
                    ib.setCreatedBy(rs.getString("created_by"));
                    ib.setUpdatedDate(rs.getTimestamp("updated_date"));
                    ib.setUpdatedBy(rs.getString("updated_by"));
                    list.add(ib);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    //  Delete only returned books
    public boolean deleteIssuedBook(int issueId) {
        String sql = "DELETE FROM issued_book WHERE issue_id = ? AND is_returned = TRUE";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, issueId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Utility method to map ResultSet to IssuedBook object
    private IssuedBook mapResultSet(ResultSet rs) throws SQLException {
        IssuedBook ib = new IssuedBook();
        ib.setIssueId(rs.getInt("issue_id"));
        ib.setBookId(rs.getInt("book_id"));
        ib.setUserId(rs.getInt("user_id"));
        ib.setIssueDate(rs.getTimestamp("issue_date"));
        ib.setDueDate(rs.getTimestamp("due_date"));
        ib.setReturnDate(rs.getTimestamp("return_date")); 
        ib.setReturned(rs.getBoolean("is_returned"));
        ib.setNotes(rs.getString("notes"));
        ib.setCreatedDate(rs.getTimestamp("created_date"));
        ib.setCreatedBy(rs.getString("created_by"));
        ib.setUpdatedDate(rs.getTimestamp("updated_date"));
        ib.setUpdatedBy(rs.getString("updated_by"));
        return ib;
    }
}
