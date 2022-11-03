package com.mfpe.claimsmicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ClaimDTOTest {
    @Test
    void testCanEqual() {
        assertFalse((new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        assertTrue(claimDTO.canEqual(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testConstructor() {
        ClaimDTO actualClaimDTO = new ClaimDTO();
        actualClaimDTO.setBenefitId("42");
        actualClaimDTO.setClaimAmount(10.0);
        actualClaimDTO.setClaimId("42");
        actualClaimDTO.setDescription("The characteristics of someone or something");
        actualClaimDTO.setHospitalId("42");
        actualClaimDTO.setMemberId("42");
        actualClaimDTO.setPolicyId("42");
        actualClaimDTO.setRemarks("Remarks");
        actualClaimDTO.setStatus("Status");
        assertEquals("42", actualClaimDTO.getBenefitId());
        assertEquals(10.0, actualClaimDTO.getClaimAmount());
        assertEquals("42", actualClaimDTO.getClaimId());
        assertEquals("The characteristics of someone or something", actualClaimDTO.getDescription());
        assertEquals("42", actualClaimDTO.getHospitalId());
        assertEquals("42", actualClaimDTO.getMemberId());
        assertEquals("42", actualClaimDTO.getPolicyId());
        assertEquals("Remarks", actualClaimDTO.getRemarks());
        assertEquals("Status", actualClaimDTO.getStatus());
    }

    @Test
    void testConstructor2() {
        ClaimDTO actualClaimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42");

        assertEquals("42", actualClaimDTO.getBenefitId());
        assertEquals("Status", actualClaimDTO.getStatus());
        assertEquals("Remarks", actualClaimDTO.getRemarks());
        assertEquals("42", actualClaimDTO.getPolicyId());
        assertEquals("42", actualClaimDTO.getMemberId());
        assertEquals("42", actualClaimDTO.getHospitalId());
        assertEquals("The characteristics of someone or something", actualClaimDTO.getDescription());
        assertEquals("42", actualClaimDTO.getClaimId());
        assertEquals(10.0, actualClaimDTO.getClaimAmount());
    }

    @Test
    void testEquals() {
        assertFalse((new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).equals(null));
        assertFalse((new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).equals("Different type to ClaimDTO"));
    }

    @Test
    void testEquals2() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        assertTrue(claimDTO.equals(claimDTO));
        int expectedHashCodeResult = claimDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimDTO.hashCode());
    }

    @Test
    void testEquals3() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        ClaimDTO claimDTO1 = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");

        assertTrue(claimDTO.equals(claimDTO1));
        int expectedHashCodeResult = claimDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimDTO1.hashCode());
    }

    @Test
    void testEquals4() {
        ClaimDTO claimDTO = new ClaimDTO("Status", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals5() {
        ClaimDTO claimDTO = new ClaimDTO(null, "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals6() {
        ClaimDTO claimDTO = new ClaimDTO("42", "42", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals7() {
        ClaimDTO claimDTO = new ClaimDTO("42", null, "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals8() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "42", "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals9() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals10() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "42", 10.0, "42",
                "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals11() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", null, 10.0, "42",
                "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals12() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 0.5,
                "42", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals13() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "Status", "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals14() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                null, "42", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals15() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "Status", "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals16() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", null, "42", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals17() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "Status", "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals18() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", null, "42");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals19() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "Status");
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals20() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", null);
        assertFalse(claimDTO.equals(new ClaimDTO("42", "Status", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals21() {
        ClaimDTO claimDTO = new ClaimDTO(null, "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");
        ClaimDTO claimDTO1 = new ClaimDTO(null, "Status", "The characteristics of someone or something", "Remarks", 10.0,
                "42", "42", "42", "42");

        assertTrue(claimDTO.equals(claimDTO1));
        int expectedHashCodeResult = claimDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimDTO1.hashCode());
    }

    @Test
    void testEquals22() {
        ClaimDTO claimDTO = new ClaimDTO("42", null, "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42");
        ClaimDTO claimDTO1 = new ClaimDTO("42", null, "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42");

        assertTrue(claimDTO.equals(claimDTO1));
        int expectedHashCodeResult = claimDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimDTO1.hashCode());
    }

    @Test
    void testEquals23() {
        ClaimDTO claimDTO = new ClaimDTO("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");
        ClaimDTO claimDTO1 = new ClaimDTO("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");

        assertTrue(claimDTO.equals(claimDTO1));
        int expectedHashCodeResult = claimDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimDTO1.hashCode());
    }
}


