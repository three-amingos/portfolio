package com.wpn.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class BankDaoTest {

    @Mock
    BankRepository personRepository;

    private BankDao bankDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertPersonData() {

    }

    @Test
    void getAllPersonInformation() {
    }

    @Test
    void getPersonInformationById() {
    }

    @Test
    void updatePersonUsingId() {
    }

    @Test
    void deletePersonUsingId() {
       // personRepository.deleteById("123");
    }
}