package ch07.sec06.package2;

import ch07.sec06.package1.A;

//다른 패키지 이기 때문에 protected 접근제한자를 붙인 변수,생성자,메소드를 접근할 수 없다.
public class C {
    public void method() {
        // A a = new A();
        // a.field = "value";
        // a.method();
    }
}
