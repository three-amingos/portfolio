package com.wpn.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Mock
    Account accountTest;

    public static final String ID="123";
    public static final String NAME="Yogi";
    public static final String EMAIL="yrkhanal@gmail.com";

    @BeforeEach
    void setUp() {
        accountTest = new Account(ID,NAME, EMAIL);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getSetId(){
        accountTest.setId(ID);
        assertTrue(accountTest.getId().equals(ID));
    }

    @Test
    public void getSetName(){
        accountTest.setName(NAME);
        assertTrue(accountTest.getName().equals(NAME));
    }

    @Test
    public void getSetEmail(){
        accountTest.setEmail(EMAIL);
        assertTrue(accountTest.getEmail().equals(EMAIL));
    }


}