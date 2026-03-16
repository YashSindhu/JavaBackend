package com.capgemini.library_task_spring_security.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.library_task_spring_security.entity.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByUserId(Long userId);
    List<BorrowRecord> findByBookId(Long bookId);
    List<BorrowRecord> findByUserIdAndReturnedFalse(Long userId);
}