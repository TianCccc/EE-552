/**
* @author: Tiancheng Xu
*/
void setup(){
  double sum1 = 0;
  for(double i = 1; i<=100; i++){
    sum1 = sum1 + 1/i;
  }
  String s1 = "Sum1 is";
  println(s1, sum1);
    
  double sum2 = 0;
  for(double i = 100; i>=1; i--){
    sum2 = sum2 + 1/i;
  }
  String s2 = "Sum2 is";
  println(s2, sum2);  
  
  double diff = sum2 - sum1;
  String s3 = "Difference between two sums is:";
  println(s3, diff);
  
  exit();
}
