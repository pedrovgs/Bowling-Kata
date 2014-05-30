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
 * FrameParser implementation created to return an SpareFrame parser if the frame analyzed contains only one "/" at the second char.
 * This FrameParser will return null if the analyzed frame is not an "/" at the second char.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class SpareFrameParser implements FrameParser {

    private static final String SPARE = "/";

    @Override
    public Frame evaluate(String frame) {
        Frame result = null;
        if (isValidFrame(frame)) {
            result = new SpareFrame();
        }
        return result;
    }

    private boolean isValidFrame(String frame) {
        return SPARE.equals(frame.charAt(1) + "");
    }

}
