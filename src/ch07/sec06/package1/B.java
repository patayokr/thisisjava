package ch07.sec06.package1;

//같은 패키지에 있으므로 default 처럼 접근 가능
public class B {
    public void method() {
        A a = new A();
        a.field = "value";
        a.method();
    }
}
