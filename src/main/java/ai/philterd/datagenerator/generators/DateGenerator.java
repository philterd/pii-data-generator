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
package ai.philterd.datagenerator.generators;

import ai.philterd.datagenerator.DataGenerator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class DateGenerator implements DataGenerator.Generator<String> {
    private final Random random;
    private final LocalDate startDate;
    private final long days;

    public DateGenerator(final Random random) {
        this(random, 1970, 2030);
    }

    public DateGenerator(final Random random, final int minYear, final int maxYear) {
        this.random = random;
        this.startDate = LocalDate.of(minYear, 1, 1);
        final LocalDate endDate = LocalDate.of(maxYear, 1, 1);
        this.days = ChronoUnit.DAYS.between(startDate, endDate);
    }

    @Override
    public String random() {
        return startDate.plusDays(random.nextInt((int) days)).toString();
    }

    @Override
    public long poolSize() {
        return days;
    }

}
