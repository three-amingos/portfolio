package com.wpn.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class JwtFromLoginTest {

    @Mock
    JwtFromLogin jwtFromLoginTest;


    @BeforeEach
    void setUp() {
        jwtFromLoginTest = new JwtFromLogin("jwt");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testJwt(){
        jwtFromLoginTest.setJwt("jwt");
        assertTrue(jwtFromLoginTest.getJwt().equals("jwt"));
    }


}