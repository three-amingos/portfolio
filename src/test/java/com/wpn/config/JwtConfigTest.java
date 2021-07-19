package com.wpn.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.KeyStoreException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;

import static org.junit.jupiter.api.Assertions.*;

class JwtConfigTest {

    @Mock
    Certificate certificate;
    @Mock
    PublicKey publicKey;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    public void testException() {

        Mockito.doThrow(new KeyStoreException()).when(certificate.getPublicKey());
    }
}