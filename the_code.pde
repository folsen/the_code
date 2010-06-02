PFont fontA;
String msg = "Find the code.";
PImage[] images = new PImage[10];
int count = 0;
int[] correct_code = {1,1,2,2,3,4,3,4,5,6};
int[] keys = new int[10];
boolean complete = false;
int attempt = 1;

void setup()
{
  size(284, 130);
  noStroke();
  background(200);
  fontA = loadFont("HelveticaNeue-CondensedBold-15.vlw");
  textFont(fontA, 15);
  textMode(SCREEN);
  println("-----------------");
}

void draw()
{ 
  background(200);
  for(int i = 0;i<count;i++) {
    image(images[i],4+(i*(24+4)),4);
  }
  fill(40);
  text(msg, 10,50);
  text("Attempt #" + attempt, 170, 100);
}

void keyPressed()
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



