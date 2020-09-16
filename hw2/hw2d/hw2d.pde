/**
* @author: Tiancheng Xu
*/
void setup() {
  size(800, 800);
}

final int N = 8;
int dx;

int [][] mark = new int[800][800];

void draw() {
  int c = 255;
  dx = width / N;
  for (int y = 0; y < height; y += dx) {
    for (int x = 0; x < width; x += dx) {
      fill(c = 255 - c);
      rect(x, y, dx, dx);
    }
    c = 255-c;
  }
  
  for(int i = 0; i < 800; i++){
    for(int j = 0; j < 800; j++){
      if (mark[i][j] == 1){
        fill(255, 0, 0);
        ellipse(i, j, dx,dx);
      }
    }
  }
}

void mousePressed() {
     fill(255,0,0);
     ellipse(mouseX/dx*dx+dx/2, mouseY/dx*dx+dx/2, dx,dx); 
     mark[mouseX/dx*dx+dx/2][mouseY/dx*dx+dx/2] = 1;
}
