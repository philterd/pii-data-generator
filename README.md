# data-generator

A Java library for generating fake PII (Personally Identifiable Information) data for testing purposes.

## Features

The `data-generator` library provides methods to generate:
- **Names**: First names, surnames, and full names (loaded from external resource files)
- **SSNs**: Random Social Security Numbers in XXX-XX-XXXX format
- **Phone Numbers**: Random US phone numbers in (XXX) XXX-XXXX format
- **Email Addresses**: Random email addresses

## Building

Build the project using Maven:

```bash
mvn clean package
```

## Testing

Run the test suite:

```bash
mvn test
```

## Usage

```java
import ai.philterd.datagenerator.DataGenerator;

// Create a generator instance
DataGenerator generator = new DataGenerator();

// Generate fake data
String firstName = generator.generateFirstName();
String surname = generator.generateSurname();
String fullName = generator.generateFullName();
String ssn = generator.generateSSN();
String phone = generator.generatePhoneNumber();
String email = generator.generateEmail();

System.out.println("Name: " + fullName);
System.out.println("SSN: " + ssn);
System.out.println("Phone: " + phone);
System.out.println("Email: " + email);
```

## Maven Coordinates

```xml
<dependency>
    <groupId>ai.philterd</groupId>
    <artifactId>data-generator</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## License

See LICENSE file for details.