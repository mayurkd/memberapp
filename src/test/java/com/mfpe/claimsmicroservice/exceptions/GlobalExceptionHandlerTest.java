package com.mfpe.claimsmicroservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

class GlobalExceptionHandlerTest {
    @Test
    void testInvalidTokenExceptionHandling() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        InvalidTokenException exception = new InvalidTokenException("An error occurred");
        ResponseEntity<ErrorDetails> actualInvalidTokenExceptionHandlingResult = globalExceptionHandler
                .invalidTokenExceptionHandling(exception, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualInvalidTokenExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualInvalidTokenExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.BAD_REQUEST, actualInvalidTokenExceptionHandlingResult.getStatusCode());
        ErrorDetails body = actualInvalidTokenExceptionHandlingResult.getBody();
        assertEquals("uri=", body.getRequestURL());
        assertEquals("Token is either expired or invalid", body.getMessage());
    }

    @Test
    void testInvalidClaimIdExceptionHandling() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        InvalidClaimIdException exception = new InvalidClaimIdException("An error occurred");
        ResponseEntity<ErrorDetails> actualInvalidClaimIdExceptionHandlingResult = globalExceptionHandler
                .invalidClaimIdExceptionHandling(exception, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualInvalidClaimIdExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualInvalidClaimIdExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.NOT_FOUND, actualInvalidClaimIdExceptionHandlingResult.getStatusCode());
        ErrorDetails body = actualInvalidClaimIdExceptionHandlingResult.getBody();
        assertEquals("uri=", body.getRequestURL());
        assertEquals("An error occurred", body.getMessage());
    }

    @Test
    void testNullPointerExceptionHandling() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        NullPointerException exception = new NullPointerException("foo");
        ResponseEntity<ErrorDetails> actualNullPointerExceptionHandlingResult = globalExceptionHandler
                .nullPointerExceptionHandling(exception, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualNullPointerExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualNullPointerExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.NOT_FOUND, actualNullPointerExceptionHandlingResult.getStatusCode());
        ErrorDetails body = actualNullPointerExceptionHandlingResult.getBody();
        assertEquals("uri=", body.getRequestURL());
        assertEquals("foo", body.getMessage());
    }

    @Test
    void testFeignExceptionHandling() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        FeignException feignException = mock(FeignException.class);
        when(feignException.getMessage()).thenReturn("Not all who wander are lost");
        ResponseEntity<ErrorDetails> actualFeignExceptionHandlingResult = globalExceptionHandler
                .feignExceptionHandling(feignException, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualFeignExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualFeignExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.NOT_FOUND, actualFeignExceptionHandlingResult.getStatusCode());
        ErrorDetails body = actualFeignExceptionHandlingResult.getBody();
        assertEquals("uri=", body.getRequestURL());
        assertEquals("Not all who wander are lost", body.getMessage());
        verify(feignException).getMessage();
    }

    @Test
    void testGlobalExceptionHandling() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Exception exception = new Exception("foo");
        ResponseEntity<ErrorDetails> actualGlobalExceptionHandlingResult = globalExceptionHandler
                .globalExceptionHandling(exception, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualGlobalExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualGlobalExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualGlobalExceptionHandlingResult.getStatusCode());
        ErrorDetails body = actualGlobalExceptionHandlingResult.getBody();
        assertEquals("uri=", body.getRequestURL());
        assertEquals("foo", body.getMessage());
    }
}

