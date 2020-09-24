package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener {

    @EventListener
    public void testListener(TestEvent testEvent) {
        System.out.println("test eventListener");

    }
}
