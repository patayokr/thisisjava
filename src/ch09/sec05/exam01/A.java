package ch09.sec05.exam01;

public class A {
    // A 인스턴스 필드와 메소드
    int field1;

    void method1() {
    }

    // A의 정적 필드와 메소드
    static int field2;

    static void method2() {
    };

    // 인스턴스 멤버 클래스
    class B {
        void method() {
            // A의 인스턴스 필드와 메소드 사용
            field1 = 10; // (O)
            method1(); // (O)

            // A의 정적 필드와 메소드 사용
            field2 = 10;
            method2();
        }
    }

    // 정적 멤버 클래스
    static class C {
        void method() {
            // A의 인스턴스 필드와 메소드 사용
            // field1=10; //(X) Cannot make a static reference to the non-static field
            // field1
            // method1(); //(X)

            // A의 정적 필드와 메소드 사용
            field2 = 10; // (O)
            method2(); // (O)
        }
    }
}
