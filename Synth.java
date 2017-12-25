import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Synth extends PApplet {




PFont font;
ControlP5 ui;

SinOsc sine;
SinOsc sine2;
float freq1;
float freq2;
float freq2Start;

float freq2Add;
float freq2Mult;

boolean revealed = false;

public void setup() {
  
  //Basic Settings
  
  background(155);
  textSize(50);
  strokeWeight(1);
  
  // Create UI
  ui = new ControlP5(this);
  ui.addSlider("freq2Add").setPosition(40, 50).setSize(1500, 80).setRange(-200, 200).setValue(0).setColorCaptionLabel(color(20,20,20));
  ui.addSlider("freq2Mult").setPosition(40, 150).setSize(1500, 80).setRange(-99, 100).setValue(0).setColorCaptionLabel(color(20,20,20));
  ui.addButton("setRandomFreq").setValue(0).setPosition(40, 300).setSize(200,50); 
  ui.addButton("reveal").setValue(0).setPosition(40, 500).setSize(200,50);
  ui.addButton("cover").setValue(0).setPosition(40, 400).setSize(200,50);
  ui.addButton("startFreq1").setValue(0).setPosition(40, 600).setSize(200, 50);
  ui.addButton("startFreq2").setValue(0).setPosition(40, 700).setSize(200, 50);
  ui.addButton("stoping").setValue(0).setPosition(40, 800).setSize(200, 50);
  
  //Create Frequencies
  freq1 = random(220) + 220;
  freq2Start = random(220) + 220;
  freq2 = freq2Start;
    
  // Create the sine oscillator.
  sine = new SinOsc(this);
  sine2 = new SinOsc(this);
  sine.freq(freq1);
  sine2.freq(freq2);
}


public void setRandomFreq() {
  freq1 = random(220) + 220;
  sine.freq(freq1);
}

public void reveal() {
    revealed = true;
}

public void cover() {
    revealed = false; 
}

public void setFreq(float f) {
   freq1 = f;
   sine.freq(freq1); 
}

public void updateFreq2() {
  freq2 = (((1 + (freq2Mult / 100)) * freq2Start) + freq2Add);
  sine2.freq(freq2);
}

public void drawSineWave1() {
   for(float f = 0; f < 5 * PI; f+=0.002f) {
      point(400 + (int) (f * 100), sin(-((freq1/100) * f)) * 50 + 500);
   }
}

public void drawSineWave2() {
   for(float f = 0; f < 5 * PI; f+=0.002f) {
      point(400 + (int) (f * 100), sin(-((freq2/100) * f)) * 50 + 800);
   }
}

public void startFreq1() {
   sine.play();
}

public void startFreq2() {
  sine2.play();
}

public void stoping() {
  sine.stop();
  sine2.stop();
}

public void draw() {
  background(155);
  updateFreq2();
  text(freq1, 800, 200);
  if(revealed) {
    drawSineWave2();
    text("2. Frequenz: " + freq2, 400, 700);
    text("Abweichung: " + abs((freq2 - freq1)), 400, 950);
  }
  
  text("Addition", 1590, 110);
  text("Multiplikation", 1590, 205);
  
  text("1. Frequenz: " + freq1, 400, 400);
  text("2. Frequenz: ", 400, 700);
  
  drawSineWave1();
}

  public void settings() {  size(1920, 1080, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Synth" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
