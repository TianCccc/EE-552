/**
* @author: Tiancheng Xu
*/
void setup(){
  size(900, 900);
  smooth();
}
int level = 0;
void draw(){
  background(225);
  if(level>8){
    level = 0;
  }
  level ++;
  sierpinski(0, height, width/2, 0, width, height, level);
  frameRate(1);
}


// draw triangle start with (x,y)    l is length of side
void sierpinski(float x1, float y1, float x2, float y2, float x3, float y3, int level){
  if (level == 1){
    triangle (x1,y1,x2,y2,x3,y3);
    fill(1);
  } else {
    sierpinski(x1,y1,(x1+x2)/2,(y1+y2)/2,(x1+x3)/2,(y1+y3)/2, level-1);
    sierpinski((x1+x2)/2,(y1+y2)/2, x2, y2,(x2+x3)/2, (y2+y3)/2,level-1);
    sierpinski((x1+x3)/2,(y1+y3)/2,(x2+x3)/2, (y2+y3)/2,x3,y3, level-1);
  }
}
