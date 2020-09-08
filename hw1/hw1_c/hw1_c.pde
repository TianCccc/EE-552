/**
* @author: Tiancheng Xu
*/
final int N = 8;
void setup(){
  size (512, 512);
}

void draw(){
  int j = 512 / N;
  for (int m = 0; m <= 512; m = m + j){
    line(m, 0, m, 512);
  }
  
  for (int k = 0; k <= 512; k = k + j){
    line(0, k, 512, k);
  }
}
