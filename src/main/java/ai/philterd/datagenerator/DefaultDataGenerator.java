/*
 * Copyright 2026 Philterd, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ai.philterd.datagenerator;

import ai.philterd.datagenerator.generators.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * Generator for creating fake PII data including names, SSNs, phone numbers, and email addresses.
 */
public class DefaultDataGenerator extends AbstractGenerator<Object> implements DataGenerator {

    private final List<String> firstNamesList;
    private final List<String> surnamesList;
    private final Random random;

    public final Generator<String> firstNames;
    public final Generator<String> surnames;
    public final Generator<String> fullNames;
    public final Generator<String> ssn;
    public final Generator<String> phoneNumbers;
    public final Generator<String> emailAddresses;
    public final Generator<Integer> age;
    public final Generator<String> bankRoutingNumbers;
    public final Generator<String> creditCardNumbers;
    public final Generator<String> dates;
    public final Generator<String> iban;
    public final Generator<String> ipAddresses;
    public final Generator<String> macAddresses;
    public final Generator<String> passportNumbers;
    public final Generator<String> states;
    public final Generator<String> stateAbbreviations;
    public final Generator<String> zipCodes;
    public final Generator<String> bitcoinAddresses;
    public final Generator<String> vin;
    public final Generator<String> urls;
    public final Generator<String> driversLicenseNumbers;
    public final Generator<String> hospitals;
    public final Generator<String> hospitalAbbreviations;
    public final Generator<String> trackingNumbers;
    public final Generator<String> cities;
    public final Generator<String> counties;

    /**
     * Creates a new DefaultDataGenerator instance.
     * @throws IOException if name data files cannot be loaded
     */
    public DefaultDataGenerator() throws IOException {
        this(new SecureRandom());
    }

    /**
     * Creates a new DefaultDataGenerator instance with a given {@link Random}.
     * @param random The {@link Random} to use.
     * @throws IOException if name data files cannot be loaded
     */
    public DefaultDataGenerator(final Random random) throws IOException {
        this.random = random;
        this.firstNamesList = loadNames("/first-names.txt");
        this.surnamesList = loadNames("/surnames.txt");

        this.firstNames = new FirstNameGenerator(firstNamesList, random);
        this.surnames = new SurnameGenerator(surnamesList, random);
        this.fullNames = new FullNameGenerator(firstNames, surnames);
        this.ssn = new SSNGenerator(random);
        this.phoneNumbers = new PhoneNumberGenerator(random);
        this.emailAddresses = new EmailAddressGenerator(firstNames, surnames, random);
        this.age = new AgeGenerator(random);
        this.bankRoutingNumbers = new BankRoutingNumberGenerator(random);
        this.creditCardNumbers = new CreditCardNumberGenerator(random);
        this.dates = new DateGenerator(random);
        this.iban = new IBANGenerator(random);
        this.ipAddresses = new IPAddressGenerator(random);
        this.macAddresses = new MACAddressGenerator(random);
        this.passportNumbers = new PassportNumberGenerator(random);
        this.states = new StateGenerator(random);
        this.stateAbbreviations = new StateAbbreviationGenerator(random);
        this.zipCodes = new ZipCodeGenerator(random);
        this.bitcoinAddresses = new BitcoinAddressGenerator(random);
        this.vin = new VINGenerator(random);
        this.urls = new URLGenerator(firstNames, random);
        this.driversLicenseNumbers = new DriversLicenseGenerator(random);
        this.hospitals = new HospitalGenerator(random);
        this.hospitalAbbreviations = new HospitalAbbreviationGenerator(random);
        this.trackingNumbers = new TrackingNumberGenerator(random);
        this.cities = new CityGenerator(loadNames("/cities.txt"), random);
        this.counties = new CountyGenerator(loadNames("/counties.txt"), random);
    }

    @Override public Generator<String> firstNames() { return firstNames; }
    @Override public Generator<String> surnames() { return surnames; }
    @Override public Generator<String> fullNames() { return fullNames; }
    @Override public Generator<String> ssn() { return ssn; }
    @Override public Generator<String> phoneNumbers() { return phoneNumbers; }
    @Override public Generator<String> emailAddresses() { return emailAddresses; }
    @Override public Generator<Integer> age() { return age; }
    @Override public Generator<String> bankRoutingNumbers() { return bankRoutingNumbers; }
    @Override public Generator<String> creditCardNumbers() { return creditCardNumbers; }
    @Override public Generator<String> dates() { return dates; }
    @Override public Generator<String> iban() { return iban; }
    @Override public Generator<String> ipAddresses() { return ipAddresses; }
    @Override public Generator<String> macAddresses() { return macAddresses; }
    @Override public Generator<String> passportNumbers() { return passportNumbers; }
    @Override public Generator<String> states() { return states; }
    @Override public Generator<String> stateAbbreviations() { return stateAbbreviations; }
    @Override public Generator<String> zipCodes() { return zipCodes; }
    @Override public Generator<String> bitcoinAddresses() { return bitcoinAddresses; }
    @Override public Generator<String> vin() { return vin; }
    @Override public Generator<String> urls() { return urls; }
    @Override public Generator<String> driversLicenseNumbers() { return driversLicenseNumbers; }
    @Override public Generator<String> hospitals() { return hospitals; }
    @Override public Generator<String> hospitalAbbreviations() { return hospitalAbbreviations; }
    @Override public Generator<String> trackingNumbers() { return trackingNumbers; }
    @Override public Generator<String> cities() { return cities; }
    @Override public Generator<String> counties() { return counties; }
    @Override public Generator<String> customId(final String pattern) { return new CustomIdGenerator(random, pattern); }

    @Override
    public Object random() {
        return null;
    }

    @Override
    public long poolSize() {
        return 0;
    }

}
