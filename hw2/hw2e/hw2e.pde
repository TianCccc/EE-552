/**
* @author: Tiancheng Xu
*/

void setup(){
  size(800, 800);
}

float x, y;
float a = 13, b = 15;
float t = 0;
float ts = 0;
float tt = 0.001;

void draw(){
  
  translate(width/2, height/2);
  scale(width/2-10, height/2-10);
  strokeWeight(0);
  x = cos(a*t);
  y = cos(b*t);
  
  fill(0,0,255);
  noStroke();
  ellipse(x, y, 0.01, 0.01);
  
  if(t < PI*2){
    t += tt;
  }else{
    t = 0;
    println("Finish!");
  }
}
