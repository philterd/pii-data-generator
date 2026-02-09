# PII Data Generator

A Java library for generating fake PII data of various types.

This code is similar to the code used by [Phileas](https://www.github.com/philterd/phileas) but is not the exact same code.

## Features

The `data-generator` library provides methods to generate:

- **Names**: First names, surnames, and full names (loaded from external resource files)
- **SSNs**: Random Social Security Numbers in XXX-XX-XXXX format
- **Phone Numbers**: Random US phone numbers in (XXX) XXX-XXXX format
- **Email Addresses**: Random email addresses
- **Ages**: Random ages between 0 and 100
- **Bank Routing Numbers**: Random 9-digit routing numbers
- **Credit Card Numbers**: Random credit card numbers
- **Dates**: Random dates in YYYY-MM-DD format
- **IBANs**: Random IBANs
- **IP Addresses**: Random IPv4 addresses
- **MAC Addresses**: Random MAC addresses
- **Passport Numbers**: Random passport numbers
- **States**: Random US state names and abbreviations
- **Zip Codes**: Random 5-digit US zip codes
- **Bitcoin Addresses**: Random Bitcoin addresses
- **VINs**: Random Vehicle Identification Numbers
- **URLs**: Random URLs
- **Driver's License Numbers**: Random 9-digit driver's license numbers
- **Hospitals**: Random hospital names and abbreviations
- **Tracking Numbers**: Random UPS and FedEx tracking numbers
- **Cities**: Random US city names
- **Counties**: Random US county names
- **Custom IDs**: Random IDs matching a user-defined pattern (e.g., `xxx-XXX-xxx`)

## Usage

```java
DataGenerator generator = new DefaultDataGenerator();

// Generate a random name
String name = generator.fullNames().random();

// Generate a random SSN
String ssn = generator.ssn().random();

// Generate a custom ID
String customId = generator.customId("ABC-123").random();
```

## Generating CSV Data

You can also generate CSV files of fake data:

```java
DataGenerator generator = new DefaultDataGenerator();

CsvGenerator csvGenerator = new CsvGenerator()
    .addColumn("First Name", generator.firstNames())
    .addColumn("Last Name", generator.surnames())
    .addColumn("SSN", generator.ssn());

try (Writer writer = new FileWriter("data.csv")) {
    csvGenerator.generate(writer, 100);
}
```

### Options

You can customize the CSV output:

```java
CsvGenerator csvGenerator = new CsvGenerator()
    .withDelimiter("|")
    .withQuotes(true)
    .addColumn("First Name", generator.firstNames())
    .addColumn("Last Name", generator.surnames());
```

## Building

Build the project using Maven:

```bash
mvn clean package
```

## Data Sources

* Cities - https://github.com/kelvins/US-Cities-Database/
* Counties - US Census
* Names - https://github.com/hadley/data-baby-names