/**
* @author: Tiancheng Xu
*/
void setup(){
  for(int i = 1; i < 100; i= i+2){
    print(i,"");
  }
  
  println();
  
  for(long j = 1; j<=32768; j=j*2){
    print(j,"");
  }
  
  exit();
}
