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

import static org.junit.Assert.assertEquals;

/**
 * Class created to check the correct behaviour of BowlingGame class. This test class contains integration tests to cover
 * the interaction between frames and BowlingGame class.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BowlingGameTest {

    /*
     * Test data
     */

    private BowlingGame bowlingGame;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        initializeBowlingGame();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldReturnZeroScore() {
        for (int i = 0; i < 10; i++) {
            ZeroFrame zeroFrame = generateZeroFrame();
            bowlingGame.addFrame(zeroFrame);
        }

        assertEquals(0, bowlingGame.getScore());
    }


    @Test
    public void shouldReturnSumOfNormalFramesAsScore() {
        for (int i = 0; i < 10; i++) {
            NormalFrame normalFrame = generateNormalFrame(i);
            bowlingGame.addFrame(normalFrame);
        }

        assertEquals(45, bowlingGame.getScore());
    }


    @Test
    public void shouldReturnPerfectScore() {
        for (int i = 0; i < 12; i++) {
            StrikeFrame strikeFrame = generateStrikeFrame();
            bowlingGame.addFrame(strikeFrame);
        }

        assertEquals(300, bowlingGame.getScore());
    }

    @Test
    public void souldReturnPerfectSpareScore() {
        for (int i = 0; i < 11; i++) {
            SpareFrame spareFrame = generateSpareFrame();
            bowlingGame.addFrame(spareFrame);
        }

        assertEquals(200, bowlingGame.getScore());
    }


    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithSpares() {
        bowlingGame.addFrame(new NormalFrame(2, 3));
        bowlingGame.addFrame(new NormalFrame(8, 1));
        bowlingGame.addFrame(new NormalFrame(4, 3));
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new SpareFrame());
        bowlingGame.addFrame(new ZeroFrame());
        bowlingGame.addFrame(new NormalFrame(1, 8));
        bowlingGame.addFrame(new SpareFrame());
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());

        assertEquals(140, bowlingGame.getScore());
    }

    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithStrikes() {
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());

        assertEquals(111, bowlingGame.getScore());
    }

    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithSparesAndStrikes() {
        bowlingGame.addFrame(new SpareFrame());
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new SpareFrame());
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new NormalFrame(5, 4));
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());
        bowlingGame.addFrame(new StrikeFrame());

        assertEquals(131, bowlingGame.getScore());
    }


    /*
     * Auxiliary methods
     */

    private void initializeBowlingGame() {
        bowlingGame = new BowlingGame();
    }

    private ZeroFrame generateZeroFrame() {
        return new ZeroFrame();
    }

    private NormalFrame generateNormalFrame(int puntuation) {
        return new NormalFrame(puntuation, 0);
    }

    private StrikeFrame generateStrikeFrame() {
        return new StrikeFrame();
    }

    private SpareFrame generateSpareFrame() {
        return new SpareFrame();
    }

}
