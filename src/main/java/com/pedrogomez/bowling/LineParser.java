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
 * Class created to parse an String representing a bowling line and return Frames with different implementations.
 * This implementation it's based in a FrameParser collection that will be evaluated to get the concrete Frame.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class LineParser {

    /*
     * Constants
     */

    public static final char ONE_CHAR_VALID_FRAME = 'X';

    /*
     * Attributes
     */

    private final Collection<FrameParser> parsers;
    private int parsingIndex;

    /*
     * Constructor
     */

    public LineParser(Collection<FrameParser> parsers) {
        this.parsers = parsers;
    }


    /**
     * Analyze one line and return a List<Frame> with the associated value for each frame.
     *
     * @param line to split in different frames.
     * @return List<Frame>
     */
    public List<Frame> parse(final String line) {
        List<Frame> frames = new LinkedList<Frame>();
        for (parsingIndex = 0; parsingIndex < line.length(); parsingIndex++) {
            Frame frame = parseFrame(line);
            frames.add(frame);
        }
        return frames;
    }


    /*
     * Auxiliary methods
     */

    private boolean isOneCharFrame(String line, int i) {
        return line.charAt(i) == ONE_CHAR_VALID_FRAME;
    }

    private Frame parseFrame(String line) {
        String frameToAnalyze;
        if (isOneCharFrame(line, parsingIndex)) {
            frameToAnalyze = line.charAt(parsingIndex) + "";
        } else {
            frameToAnalyze = line.substring(parsingIndex, parsingIndex + 2);
            parsingIndex++;
        }
        return getFrame(frameToAnalyze);
    }

    private Frame getFrame(String frameToAnalyze) {
        Frame result = null;
        for (FrameParser frameParser : parsers) {
            Frame frame = frameParser.evaluate(frameToAnalyze);
            if (frame != null) {
                result = frame;
                break;
            }
        }
        return result;
    }

}
