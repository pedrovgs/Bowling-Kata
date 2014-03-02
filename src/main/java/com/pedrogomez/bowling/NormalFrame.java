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

/**
 * Frame implementation created to represent a normal frame.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class NormalFrame implements Frame {

    /*
     * Attributes
     */

    private final int firstThrow;
    private final int secondThrow;

    /*
     * Constructor
     */

    public NormalFrame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    /*
     * Implemented methods
     */

    @Override
    public int getScore() {
        return firstThrow + secondThrow;
    }

    @Override
    public boolean hasToDuplicateNextFrame() {
        return false;
    }


    @Override
    public int getDuplicationDuration() {
        return 0;
    }
}
