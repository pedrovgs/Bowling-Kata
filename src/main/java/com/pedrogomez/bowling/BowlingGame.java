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

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a bowling game. This entity will be used to simulate a bowling game with only one player. The client code
 * will be able to use this entity to indicate a new Frame and will return the result using getScore() method.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class BowlingGame {

    private static final int FRAMES_PER_GAME = 10;

    private List<Frame> frames = new LinkedList<Frame>();

    void addFrame(Frame frame) {
        frames.add(frame);
    }


    int getScore() {
        int score = 0;
        for (int currentFrame = 0; currentFrame < FRAMES_PER_GAME; currentFrame++) {
            Frame frame = frames.get(currentFrame);
            score = incrementScore(score, frame);
            if (shouldDuplicateNextScores(frame)) {
                score = duplicateNextScores(score, currentFrame, frame);
            }
        }
        return score;
    }

    private int incrementScore(int score, Frame frame) {
        return score + frame.getScore();
    }

    private boolean shouldDuplicateNextScores(Frame frame) {
        return frame.hasToDuplicateNextFrame() && frame.getDuplicationDuration() > 0;
    }

    private int duplicateNextScores(int score, int currentFrame, Frame frame) {
        final int topNextFrame = currentFrame + 1;
        int nextFrame = topNextFrame;
        while (nextFrame < (topNextFrame + frame.getDuplicationDuration())) {
            score = incrementScore(score, frames.get(nextFrame));
            if (frames.get(nextFrame).getDuplicationDuration() == 1 && frame.getDuplicationDuration() != 1) {
                nextFrame++;
            }
            nextFrame++;
        }
        return score;
    }

}
