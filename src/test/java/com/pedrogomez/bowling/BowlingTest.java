/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pedrogomez.bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test created to check the correctness of Bowling class. This test contains integration tests to check the score
 * has been calculated properly.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BowlingTest {

    /*
     * Test data
     */

    private Bowling bowling;

    private Map<String, Integer> validRollsSequences;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        initializeBowling();
        initializeRollsSequences();
    }



    /*
     * Test methods
     */

    @Test
    public void shouldCalculateTheCorrectScore() {
        for (String key : validRollsSequences.keySet()) {
            int result = bowling.getScore(key);
            int expectedResult = validRollsSequences.get(key);

            assertEquals(expectedResult, result);
        }
    }

    /*
     * Auxiliary methods
     */

    private void initializeBowling() {
        bowling = new Bowling();
    }

    private void initializeRollsSequences() {
        validRollsSequences = new HashMap<String, Integer>();
        validRollsSequences.put("XXXXXXXXXXXX", 300);
        validRollsSequences.put("9-9-9-9-9-9-9-9-9-9-", 90);
        validRollsSequences.put("8-8-8-8-8-8-8-8-8-8-", 80);
        validRollsSequences.put("238143XX5/--189/XXX", 140);
        validRollsSequences.put("5/5/5/5/5/5/5/5/5/5/5/", 200);
    }

}
