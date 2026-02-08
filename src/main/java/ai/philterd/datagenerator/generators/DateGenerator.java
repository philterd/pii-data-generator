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
import java.util.Random;

public class DateGenerator implements DataGenerator.Generator<String> {
    private final Random random;
    private final int minYear;
    private final int maxYear;

    public DateGenerator(final Random random) {
        this(random, 1970, 2030);
    }

    public DateGenerator(final Random random, final int minYear, final int maxYear) {
        this.random = random;
        this.minYear = minYear;
        this.maxYear = maxYear;
    }

    @Override
    public String random() {
        final int year = minYear + random.nextInt(maxYear - minYear);
        final int dayOfYear = 1 + random.nextInt(365);
        return LocalDate.ofYearDay(year, dayOfYear).toString();
    }

    @Override
    public long poolSize() {
        return (long) (maxYear - minYear) * 365L;
    }
}
