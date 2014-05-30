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
 * Test created to check the correctness of ZeroFrameParser.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ZeroFrameParserTest {

    private static final String VALID_ZERO_FRAME = "--";
    private static final String INVALID_ZERO_FRAME = "4-";

    private ZeroFrameParser zeroFrameParser;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = zeroFrameParser.evaluate(VALID_ZERO_FRAME);

        assertTrue(result instanceof ZeroFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = zeroFrameParser.evaluate(INVALID_ZERO_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        zeroFrameParser = new ZeroFrameParser();
    }

}
