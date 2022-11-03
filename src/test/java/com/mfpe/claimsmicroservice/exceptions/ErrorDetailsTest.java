package com.mfpe.claimsmicroservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ErrorDetailsTest {
    @Test
    void testCanEqual() {
        assertFalse((new ErrorDetails()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ErrorDetails errorDetails = new ErrorDetails();
        assertTrue(errorDetails.canEqual(new ErrorDetails()));
    }

    @Test
    void testConstructor() {
        ErrorDetails actualErrorDetails = new ErrorDetails();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualErrorDetails.setDate(fromResult);
        actualErrorDetails.setMessage("Not all who wander are lost");
        actualErrorDetails.setRequestURL("https://example.org/example");
        assertSame(fromResult, actualErrorDetails.getDate());
        assertEquals("Not all who wander are lost", actualErrorDetails.getMessage());
        assertEquals("https://example.org/example", actualErrorDetails.getRequestURL());
    }

    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ErrorDetails actualErrorDetails = new ErrorDetails(
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Not all who wander are lost",
                "https://example.org/example");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualErrorDetails.setDate(fromResult);
        actualErrorDetails.setMessage("Not all who wander are lost");
        actualErrorDetails.setRequestURL("https://example.org/example");
        assertSame(fromResult, actualErrorDetails.getDate());
        assertEquals("Not all who wander are lost", actualErrorDetails.getMessage());
        assertEquals("https://example.org/example", actualErrorDetails.getRequestURL());
    }

    @Test
    void testEquals() {
        assertFalse((new ErrorDetails()).equals(null));
        assertFalse((new ErrorDetails()).equals("Different type to ErrorDetails"));
    }

    @Test
    void testEquals2() {
        ErrorDetails errorDetails = new ErrorDetails();
        assertTrue(errorDetails.equals(errorDetails));
        int expectedHashCodeResult = errorDetails.hashCode();
        assertEquals(expectedHashCodeResult, errorDetails.hashCode());
    }

    @Test
    void testEquals3() {
        ErrorDetails errorDetails = new ErrorDetails();
        ErrorDetails errorDetails1 = new ErrorDetails();
        assertTrue(errorDetails.equals(errorDetails1));
        int expectedHashCodeResult = errorDetails.hashCode();
        assertEquals(expectedHashCodeResult, errorDetails1.hashCode());
    }

    @Test
    void testEquals4() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(1L), "Not all who wander are lost",
                "https://example.org/example");
        assertFalse(errorDetails.equals(new ErrorDetails()));
    }

    @Test
    void testEquals5() {
        ErrorDetails errorDetails = new ErrorDetails();
        assertFalse(errorDetails
                .equals(new ErrorDetails(new Date(1L), "Not all who wander are lost", "https://example.org/example")));
    }

    @Test
    void testEquals6() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not all who wander are lost");
        assertFalse(errorDetails.equals(new ErrorDetails()));
    }

    @Test
    void testEquals7() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setRequestURL("https://example.org/example");
        assertFalse(errorDetails.equals(new ErrorDetails()));
    }

    @Test
    void testEquals8() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(1L), "Not all who wander are lost",
                "https://example.org/example");
        ErrorDetails errorDetails1 = new ErrorDetails(new Date(1L), "Not all who wander are lost",
                "https://example.org/example");

        assertTrue(errorDetails.equals(errorDetails1));
        int expectedHashCodeResult = errorDetails.hashCode();
        assertEquals(expectedHashCodeResult, errorDetails1.hashCode());
    }

    @Test
    void testEquals9() {
        ErrorDetails errorDetails = new ErrorDetails();

        ErrorDetails errorDetails1 = new ErrorDetails();
        errorDetails1.setMessage("Not all who wander are lost");
        assertFalse(errorDetails.equals(errorDetails1));
    }

    @Test
    void testEquals10() {
        ErrorDetails errorDetails = new ErrorDetails();

        ErrorDetails errorDetails1 = new ErrorDetails();
        errorDetails1.setRequestURL("https://example.org/example");
        assertFalse(errorDetails.equals(errorDetails1));
    }
}

