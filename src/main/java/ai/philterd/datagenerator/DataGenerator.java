package ai.philterd.datagenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generator for creating fake PII data including names, SSNs, phone numbers, and email addresses.
 */
public class DataGenerator {

    private final List<String> firstNames;
    private final List<String> surnames;
    private final Random random;

    /**
     * Creates a new DataGenerator instance.
     * @throws IOException if name data files cannot be loaded
     */
    public DataGenerator() throws IOException {
        this.random = new Random();
        this.firstNames = loadNames("/first-names.txt");
        this.surnames = loadNames("/surnames.txt");
    }

    /**
     * Loads names from a resource file.
     * @param resourcePath path to the resource file
     * @return list of names
     * @throws IOException if file cannot be read
     */
    private List<String> loadNames(String resourcePath) throws IOException {
        List<String> names = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    names.add(line);
                }
            }
        }
        return names;
    }

    /**
     * Generates a random first name.
     * @return a random first name
     */
    public String generateFirstName() {
        return firstNames.get(random.nextInt(firstNames.size()));
    }

    /**
     * Generates a random surname.
     * @return a random surname
     */
    public String generateSurname() {
        return surnames.get(random.nextInt(surnames.size()));
    }

    /**
     * Generates a random full name.
     * @return a random full name (first name + surname)
     */
    public String generateFullName() {
        return generateFirstName() + " " + generateSurname();
    }

    /**
     * Generates a random Social Security Number in the format XXX-XX-XXXX.
     * @return a random SSN
     */
    public String generateSSN() {
        int area = random.nextInt(900) + 100; // 100-999
        int group = random.nextInt(100); // 00-99
        int serial = random.nextInt(10000); // 0000-9999
        return String.format("%03d-%02d-%04d", area, group, serial);
    }

    /**
     * Generates a random US phone number in the format (XXX) XXX-XXXX.
     * @return a random phone number
     */
    public String generatePhoneNumber() {
        int areaCode = random.nextInt(900) + 100; // 100-999
        int exchange = random.nextInt(900) + 100; // 100-999
        int subscriber = random.nextInt(10000); // 0000-9999
        return String.format("(%03d) %03d-%04d", areaCode, exchange, subscriber);
    }

    /**
     * Generates a random email address.
     * @return a random email address
     */
    public String generateEmail() {
        String firstName = generateFirstName().toLowerCase();
        String surname = generateSurname().toLowerCase();
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];
        return firstName + "." + surname + "@" + domain;
    }
}
