import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class the_code extends PApplet {

PFont fontA;
String msg = "Find the code.";
PImage[] images = new PImage[10];
int count = 0;
int[] correct_code = {1,1,2,2,3,4,3,4,5,6};
int[] keys = new int[10];
boolean complete = false;
int attempt = 1;

public void setup()
{
  size(284, 130);
  noStroke();
  background(200);
  fontA = loadFont("HelveticaNeue-CondensedBold-15.vlw");
  textFont(fontA, 15);
  textMode(SCREEN);
  println("-----------------");
}

public void draw()
{ 
  background(200);
  for(int i = 0;i<count;i++) {
    image(images[i],4+(i*(24+4)),4);
  }
  fill(40);
  text(msg, 10,50);
  text("Attempt #" + attempt, 170, 100);
}

public void keyPressed()
{
  if(!complete) {
    switch(keyCode) {
    case 65:
      images[count] = loadImage("a.png");
      keys[count] = 6;
      count++;
      break;
    case 66:
      images[count] = loadImage("b.png");
      keys[count] = 5;
      count++;
      break;
    case 38:
      images[count] = loadImage("up.png");
      keys[count] = 1;
      count++;
      break;
     case 40:
      images[count] = loadImage("down.png");
      keys[count] = 2;
      count++;
      break;
     case 37:
      images[count] = loadImage("left.png");
      keys[count] = 3;
      count++;
      break;
     case 39:
      images[count] = loadImage("right.png");
      keys[count] = 4;
      count++;
      break;
    }
    if(count == 10) {
      if(Arrays.equals(keys, correct_code)) {
        msg = "Correct! Your reward:\nThe password is \"Gradius Nintendo\"";
        complete = true;
      } else {
        msg = "Nope, that's not it. Try again!";
        attempt++;
        for(int i = 0;i<10;i++) {
          images[i] = null;
        }
        count = 0;
      }
    }
  }
}




  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#c0c0c0", "the_code" });
  }
}
