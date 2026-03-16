
package com.event_announcement_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event_announcement_system.entity.Event;
import com.event_announcement_system.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents(){
        return repository.findAll();
    }

    public Event saveEvent(Event event){
        return repository.save(event);
    }

}