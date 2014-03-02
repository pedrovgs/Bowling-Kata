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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Test created to check the correctness of NormalFrameParser.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NormalFrameParserTest {

    /*
     * Constants
     */
    private static final String VALID_FRAME = "81";
    private static final String INVALID_FRAME = "X";


    /*
     * Attributes
     */

    private NormalFrameParser normalFrameParser;

    /*
     * After and before methods
     */

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = normalFrameParser.evaluate(VALID_FRAME);

        assertTrue(result instanceof NormalFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = normalFrameParser.evaluate(INVALID_FRAME);

        assertNull(result);
    }

    /*
     * Auxiliary methods
     */

    private void initializeStrikeFrameParser() {
        normalFrameParser = new NormalFrameParser();
    }

}
