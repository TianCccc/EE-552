int level = 2;

void sierpinski(float x1, float y1, float x2, float y2, float x3, float y3, int level) {
  if (level == 1) {
    triangle(x1,y1,x2,y2,x3,y3);
    return;
  }
  else {
    sierpinski((x1+x2)/2,(y1+y2)/2,(x2+x3)/2,(y2+y3)/2,(x3+x1)/2,(y3+y1)/2, level-1);
  }
}
//  sierpinski( , , , , ,  level-1);
//  sierpinski( level-1);
//  sierpinski( level-1);



void setup() {
  size(800,800);
}

void draw() {
  //background(0);
  sierpinski(0,height, width/2,0, width,height, level);
  sierpinski(0,height, width/2,0, width,height, level-1);

  //level--;
  //if (level == 8)
  //  level = 0;
}
