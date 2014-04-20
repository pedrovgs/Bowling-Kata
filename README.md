Bowling [![Build Status](https://travis-ci.org/pedrovgs/Bowling-Kata.svg?branch=master)](https://travis-ci.org/pedrovgs/Bowling-Kata)
=======

Bowling kata implemented in java:

Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

Here are some things that the program <em>will not do</em>:

* We will not check for valid rolls.
* We will not check for correct number of rolls and frames.
* We will not provide scores for intermediate frames.

Depending on the application, this might or might not be a valid way to define a complete story, but we do it here for purposes of keeping the kata light. I think you'll see that improvements like those above would go in readily if they were needed for real.

We can briefly summarize the scoring for this form of bowling:

* Each game, or "line" of bowling, includes ten turns, or "frames" for the bowler.
* In each frame, the bowler gets up to two tries to knock down all the pins.
* If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
* If in two tries he knocks them all down, this is called a "spare" and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
* If on his first try in the frame he knocks down all the pins, this is called a "strike". His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
* If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
* The game score is the total of all frame scores.

More info on the rules at: <a href="www.topendsports.com/sport/tenpin/scoring.htm">www.topendsports.com/sport/tenpin/scoring.htm</a>

What makes this game interesting to score is the look ahead in the scoring for strike and spare. At the time we throw a strike or spare, we cannot calculate the frame score: we have to wait one or two frames to find out what the bonus is.

Suggested Test Cases:

When scoring +X+ indicates a strike, <tt>/</tt> indicates a spare, <tt>-</tt> indicates a miss:

* <b>12 rolls: 12 strikes:</b> +XXXXXXXXXXXX+  <tt>= 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 = 300</tt>
* <b>20 rolls: 10 pairs of 9 and miss:</b> <tt>9-9-9-9-9-9-9-9-9-9- = 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 = 90</tt>
* <b>21 rolls: 10 pairs of 5 and spare, with a final 5:</b> <tt>5/5/5/5/5/5/5/5/5/5/5 = 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 = 150</tt>


Developed By
------------

* Pedro Vicente Gómez Sánchez - <pedrovicente.gomez@gmail.com>

<a href="https://twitter.com/pedro_g_s">
  <img alt="Follow me on Twitter" src="http://imageshack.us/a/img812/3923/smallth.png" />
</a>
<a href="http://www.linkedin.com/in/pedrovg">
  <img alt="Add me to Linkedin" src="http://imageshack.us/a/img41/7877/smallld.png" />
</a>



License
-------

    Copyright 2014 Pedro Vicente Gómez Sánchez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.