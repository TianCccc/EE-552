/**
* @author: Tiancheng Xu
*/

int level = 0;

void setup() {
  size(900, 900);
  fill(0);
  stroke(1);
  background(255);
}

void draw() {
  translate(width/2, height/2);
  background(255);
  if(level > 6){
    level = 0;
  }
  KochSnow(level, 600);
  level ++;
  frameRate(1);
}


void KochSnow(int level, float size) {
  KochCurve(level, -size/2, -size*sqrt(3)/6, size/2, -size*sqrt(3)/6);
  KochCurve(level, 0, size*2*sqrt(3)/6, -size/2, -size*sqrt(3)/6);
  KochCurve(level, size/2, -size*sqrt(3)/6, 0, size*2*sqrt(3)/6);
}

void KochCurve(int level, float x1, float y1, float x2, float y2) {
  float d = dist(x1, y1, x2, y2);
  float l = d / 3;
  float angle = atan2(y2-y1, x2-x1);
  pushMatrix();
  translate(x1, y1);
  rotate(angle);

  if (level == 0) {
    line(0, 0, d, 0);
  } else {
    KochCurve(level - 1, 0, 0, l, 0);
    KochCurve(level - 1, l * 2, 0, d, 0);
    KochCurve(level - 1, l, 0, l + cos(-PI/3) * l, sin(-PI/3) * l);
    KochCurve(level - 1, l + cos(-PI/3) * l, sin(-PI/3) * l, l * 2, 0);
  }
  popMatrix();
}
