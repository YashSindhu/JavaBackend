package com.event_announcement_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event_announcement_system.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}