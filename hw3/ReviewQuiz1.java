public class ReviewQuiz1 {
	public static void main(String[] args) {
	}
}

interface A {
	public void f();
}

abstract class B implements A {
  public abstract void g();
}

abstract class C implements A {

}

class D implements A {
	public void f() {
		System.out.println("test");
	}
}

abstract class E extends B {
	public void f() {
		System.out.println("test2");
	}
}

class F extends E {
	public void g() {
		System.out.println("test3");
	}
}