package ai.philterd.datagenerator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for DataGenerator.
 */
public class DataGeneratorTest {

    private DataGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new DataGenerator();
    }

    @Test
    public void testGenerateFirstName() {
        String firstName = generator.generateFirstName();
        assertNotNull("First name should not be null", firstName);
        assertFalse("First name should not be empty", firstName.isEmpty());
    }

    @Test
    public void testGenerateSurname() {
        String surname = generator.generateSurname();
        assertNotNull("Surname should not be null", surname);
        assertFalse("Surname should not be empty", surname.isEmpty());
    }

    @Test
    public void testGenerateFullName() {
        String fullName = generator.generateFullName();
        assertNotNull("Full name should not be null", fullName);
        assertTrue("Full name should contain a space", fullName.contains(" "));
        String[] parts = fullName.split(" ");
        assertEquals("Full name should have two parts", 2, parts.length);
    }

    @Test
    public void testGenerateSSN() {
        String ssn = generator.generateSSN();
        assertNotNull("SSN should not be null", ssn);
        assertTrue("SSN should match XXX-XX-XXXX format", ssn.matches("\\d{3}-\\d{2}-\\d{4}"));
    }

    @Test
    public void testGeneratePhoneNumber() {
        String phoneNumber = generator.generatePhoneNumber();
        assertNotNull("Phone number should not be null", phoneNumber);
        assertTrue("Phone number should match (XXX) XXX-XXXX format", 
                   phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}"));
    }

    @Test
    public void testGenerateEmail() {
        String email = generator.generateEmail();
        assertNotNull("Email should not be null", email);
        assertTrue("Email should contain @", email.contains("@"));
        assertTrue("Email should contain .", email.contains("."));
        String[] parts = email.split("@");
        assertEquals("Email should have two parts separated by @", 2, parts.length);
    }

    @Test
    public void testMultipleGenerations() {
        // Generate multiple instances to ensure randomness
        String name1 = generator.generateFullName();
        String name2 = generator.generateFullName();
        String ssn1 = generator.generateSSN();
        String ssn2 = generator.generateSSN();
        
        // Just verify they are all valid
        assertNotNull(name1);
        assertNotNull(name2);
        assertNotNull(ssn1);
        assertNotNull(ssn2);
    }
}
