# EarTraining

A simple programm made in processing to practice your precise recognition of the variance of 2 notes.
On startup you will see the frequency of the first sinewave and how it could look like (just for educational perpuses).
There are some german words in the userinterface because this was made to teach young students the way tones are created.

## Interface

### Sliders

#### Addition
This slider will add its value to the frequency of the second sinewave

#### Multiplikation
This slider will multiply the frequency of the second sinewave
Maths: 1 + (value / 100)

## Buttons

#### setRandomFreq
The frequency of the first sinewave will be given a random value between 220hz and 440hz

#### cover
Hides the second frequency and sinewave

#### reveal
reveals the second frequency and sinewave

#### startFreq1
Starts the playback of the first sinewave continuously

#### startFreq2
Starts the playback of the second sinewave continuously

#### stoping
Stops both sinewaves
Note: Calling the function "stop" instead of "stopping" doesn't work because of processing's premade functions

## How to use
On startup you create a random sinewave with "setRandomFreq" which you can start listening to by clicking "startFreq1".
Then you start the second sinewave by clicking "startFreq2".
Now your task is to modify the frequency of the second sinewave by changing the values of the two sliders at the top.
You need to get both frequencies as close as possible.
If you think you got the same frequency you click "reveal" and check your result. "Abweichung" (engl: variance) should be as low as possible.
Click "reveal" and "stopping" to try again.
