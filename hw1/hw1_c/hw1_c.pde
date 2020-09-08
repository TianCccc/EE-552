/**
* @author: Tiancheng Xu
*/
final int N = 8;
void setup(){
  size (512, 512);
}

void draw(){
  float j = 512 / N;
  for (float m = 0; m <= 512; m = m + j){
    line(m, 0, m, 512);
  }
  
  for (float k = 0; k <= 512; k = k + j){
    line(0, k, 512, k);
  }
}
