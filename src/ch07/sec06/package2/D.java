package ch07.sec06.package2;

import ch07.sec06.package1.A;

//클래스 D는 A를 상속 받았기 때문에 
public class D extends A {

    public D() {
        super(); // 자식이기 때문에 다 호출 가능한 것이 아니라 생성자 만큼은 super로 호출해 주어야 한다.
    }

    public void method1() {
        // A 필드값 변경
        this.field = "value";
        // A 메소드 호출
        this.method();
    }

    // 메소드 선언
    public void method2() {
        // A a = new A();
        // a.field = "value";
        // a.method();
    }
}
