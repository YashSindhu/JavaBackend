package com.capgemini.library_task_spring_security.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library_task_spring_security.entity.Book;
import com.capgemini.library_task_spring_security.entity.BorrowRecord;
import com.capgemini.library_task_spring_security.entity.User;
import com.capgemini.library_task_spring_security.repository.BookRepository;
import com.capgemini.library_task_spring_security.repository.BorrowRecordRepository;
import com.capgemini.library_task_spring_security.repository.UserRepository;

@Service
public class BorrowService {

    private final BorrowRecordRepository borrowRepo;
    private final UserRepository userRepo;
    private final BookRepository bookRepo;

    public BorrowService(
            BorrowRecordRepository borrowRepo,
            UserRepository userRepo,
            BookRepository bookRepo) {

        this.borrowRepo = borrowRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public BorrowRecord borrowBook(Long userId, Long bookId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        BorrowRecord record = new BorrowRecord();

        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);

        bookRepo.save(book);

        return borrowRepo.save(record);
    }

    public BorrowRecord returnBook(Long recordId) {
        BorrowRecord record = borrowRepo.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        if (record.isReturned()) {
            throw new RuntimeException("Book already returned");
        }

        record.setReturned(true);
        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setAvailable(true);
        bookRepo.save(book);

        return borrowRepo.save(record);
    }

    public List<BorrowRecord> getUserBorrowHistory(Long userId) {
        return borrowRepo.findByUserId(userId);
    }

    public List<BorrowRecord> getActiveBorrows(Long userId) {
        return borrowRepo.findByUserIdAndReturnedFalse(userId);
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRepo.findAll();
    }
}