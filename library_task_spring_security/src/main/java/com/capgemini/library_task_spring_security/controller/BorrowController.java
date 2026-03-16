package com.capgemini.library_task_spring_security.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.capgemini.library_task_spring_security.entity.BorrowRecord;
import com.capgemini.library_task_spring_security.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private final BorrowService service;

    public BorrowController(BorrowService service) {
        this.service = service;
    }

    @PostMapping
    public BorrowRecord borrowBook(
            @RequestParam Long userId,
            @RequestParam Long bookId) {

        return service.borrowBook(userId, bookId);
    }

    @PutMapping("/return/{recordId}")
    public BorrowRecord returnBook(@PathVariable Long recordId) {
        return service.returnBook(recordId);
    }

    @GetMapping("/user/{userId}")
    public List<BorrowRecord> getUserBorrowHistory(@PathVariable Long userId) {
        return service.getUserBorrowHistory(userId);
    }

    @GetMapping("/user/{userId}/active")
    public List<BorrowRecord> getActiveBorrows(@PathVariable Long userId) {
        return service.getActiveBorrows(userId);
    }

    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return service.getAllBorrowRecords();
    }
}