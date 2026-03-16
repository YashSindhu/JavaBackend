package com.event_announcement_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event_announcement_system.entity.Event;
import com.event_announcement_system.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public List<Event> getAllEvents(){
        return service.getAllEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return service.saveEvent(event);
    }
}