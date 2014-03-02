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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Main class of Bowling kata. This class has the responsibility of instrument all the application dependencies and
 * create a facade to offer the implementation using a single access point. This class will get a string parameter
 * with a valid sequence of rolls for one line and will return an integer with the score.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Bowling {

    /*
     * Attributes
     */
    private LineParser lineParser;

    /*
     * Constructor
     */
    public Bowling() {
        initializeLineParser();
    }


    /**
     * Calculate the score of a roll sequence for a bowling match.
     *
     * @param rolls valid sequence of rolls in one line.
     * @return calculated score.
     */
    public int getScore(String rolls) {
        List<Frame> frames = lineParser.parse(rolls);
        return getScore(frames);
    }

    /*
     * Auxiliary methods
     */

    private void initializeLineParser() {
        Collection<FrameParser> parsers = new LinkedList<FrameParser>();
        parsers.add(new StrikeFrameParser());
        parsers.add(new SpareFrameParser());
        parsers.add(new NormalFrameParser());
        parsers.add(new ZeroFrameParser());
        lineParser = new LineParser(parsers);
    }

    private int getScore(final List<Frame> frames) {
        BowlingGame bowlingGame = createBowlingGame(frames);
        return bowlingGame.getScore();
    }

    private BowlingGame createBowlingGame(List<Frame> frames) {
        BowlingGame bowlingGame = new BowlingGame();
        for (Frame frame : frames) {
            bowlingGame.addFrame(frame);
        }
        return bowlingGame;
    }

}
