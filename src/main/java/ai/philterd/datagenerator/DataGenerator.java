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

/**
 * Interface for generating fake PII data.
 */
public interface DataGenerator {

    /**
     * Interface for a generator that can provide a random value and its pool size.
     * @param <T> The type of data generated.
     */
    interface Generator<T> {
        
        /**
         * Generates a random value.
         * @return A random value.
         */
        T random();

        /**
         * Gets the maximum number of unique values that can be generated.
         * @return The maximum pool size.
         */
        long poolSize();

    }

    Generator<String> firstNames();
    Generator<String> surnames();
    Generator<String> fullNames();
    Generator<String> ssn();
    Generator<String> phoneNumbers();
    Generator<String> emailAddresses();
    Generator<Integer> age();
    Generator<String> bankRoutingNumbers();
    Generator<String> creditCardNumbers();
    Generator<String> dates();
    Generator<String> iban();
    Generator<String> ipAddresses();
    Generator<String> macAddresses();
    Generator<String> passportNumbers();
    Generator<String> states();
    Generator<String> stateAbbreviations();
    Generator<String> zipCodes();
    Generator<String> bitcoinAddresses();
    Generator<String> vin();
    Generator<String> urls();
    Generator<String> driversLicenseNumbers();
    Generator<String> hospitals();
    Generator<String> hospitalAbbreviations();
    Generator<String> trackingNumbers();
    Generator<String> cities();
    Generator<String> counties();
    Generator<String> customId(String pattern);

}
