void setup(){
  size(600, 600);
}

//float x = 60, y = 60, vx = 0, vy = 0, r1 = 50;
float x = 60, y = 60 , r1 = 50, q1 = 1;
float vx= 1, vy = 1;

//float m = 100, n = 100, vm = 0, vn = 0, r2 = 25;

float m = 500, n = 500, r2 = 25, q2 = 3;
float vm = 2, vn = 5;

void draw(){
  background(225, 225, 225);
  noStroke();
  circle (x, y, 2*r1);
  fill(225, 0, 0);
  
  x += vx;
  y += vy;
  
  if ( y < r1 ){
    y = r1;
    vy = - vy;
  } else if ( y > height-r1){
    y = height - r1;
    vy = - vy;
  } else if ( x < r1 ){
    x = r1;
    vx = - vx;
  } else if ( x > width-r1){
    x = width-r1;
    vx = - vx;
  }
  
  noStroke();
  circle (m, n, 2*r2);
  fill(0, 0, 255);
  
  m += vm;
  n += vn;
  
  if ( n < 25 ){
    n = 25;
    vn = - vn;
  } else if ( n > height-25){
    n = height - 25;
    vn = - vn;
  } else if ( m < 25 ){
    m = 25;
    vm = - vm;
  } else if ( m > width-25){
    m = width - 25;
    vm = - vm;
  }
  
  //// Two ball Collision
  float dis = sqrt(pow( x - m, 2) + pow( y - n, 2));
  
  if ( dis <= r1 + r2){
  
  float t1 = vx;
  float t2 = vm;
  vx = (vx*(q1-q2)+2*q2*vm)/(q1+q2);
  vy = (vy*(q1-q2)+2*q2*vn)/(q1+q2);
  vm = (vm*(q2-q1)+2*q1*t1)/(q1+q2);
  vn = (vy*(q2-q1)+2*q1*t2)/(q1+q2);
  
  }
  
}
