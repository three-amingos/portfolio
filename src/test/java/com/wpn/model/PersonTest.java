package com.wpn.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    @Mock
    Account person;

    @BeforeEach
    void setUp() {
        person = new Account("1","yrkhanal@gmail.com","Yogi");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetSetId(){
        person.setId("7");
        assertTrue(person.getId().equals("7"));

    }

    @Test
    public void testGetSetName(){
        person.setName("yogi");
        assertTrue(person.getName().equals("yogi"));
    }

    @Test
    public void testGetSetEmail(){
        person.setName("yrkhanal@gmail.com");
        assertTrue(person.getEmail().equals("yrkhanal@gmail.com"));
    }
}