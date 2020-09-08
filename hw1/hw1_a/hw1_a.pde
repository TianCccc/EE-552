/**
* @author: Tiancheng Xu
*/
void setup(){
  size (500, 500);
}

int x = 50, y = 50, dx = 1;

void draw(){
  background (225, 225, 225);
  noStroke();
  circle (x, y, 100);
  fill (50);

  if (y == 50){
    x = x + dx;
  }
  
  if (x >= width - 50){
    y = y + dx;
  }
  
  if (y >= height - 50){
    x = x - dx;
  }
  
  if (x == 50){
    y = y - dx;
  }
}

void mousePressed() {
  exit(); 
}
