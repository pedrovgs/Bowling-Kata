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
 * FrameParser implementation created to return a ZeroFrame if the frame analyzed contains is equals to "--".
 * This FrameParser will return null if the analyzed frame is not an "__".
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class ZeroFrameParser implements FrameParser {

    /*
     * Constants
     */

    private static final String ZERO = "/";

    /*
     * Implemented methods
     */

    @Override
    public Frame evaluate(String frame) {
        return null;
    }

}
