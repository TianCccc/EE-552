/**
* @author: Tiancheng Xu
*/

void setup(){
  size(800, 800);
}

// Scale image 50 from the edge
int AX = (800/2) - 50;
int BX = (800/2) - 50;

float x, y;
float a = 13, b = 15;
float t = 0;
float ts = 0;
float tt = 0.001;

void draw(){
  
  x = AX*sin(PI/2 - a*t) + 800/2;
  y = BX*sin(PI/2 - b*t) + 800/2;
  
  //fill(255, 0, 0);
  //ellipse(AX*sin(PI/2 - a*ts) + 800/2, BX*sin(PI/2 - b*ts) + 800/2, 7, 7);
  
  fill(0,0,255);
  noStroke();
  ellipse(x, y, 2, 2);
  
  if(t < PI*2){
    t += tt;
  }else{
    t = 0;
    println("Finish!");
  }
  
}
