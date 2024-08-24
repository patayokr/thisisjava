package ch09.sec04.exam03;

import ch07.sec06.package1.B;

public class A {
    // 메소드
    public void method(int arg) { // final int arg
        // 로컬 변수
        int var = 1; // final int var =1;

        // 로컬 클래스
        class B {
            // 메소드
            void method2() {
                // 로컬 변수 읽기
                System.out.println("arg: " + arg); // (O)
                System.out.println("var: " + var); // (O)
            }

            // 로컬 변수 수정
            // arg = 2; (X)
            // var = 2; (X)
        }

        // 로컬 객체 생성
        B b = new B();
        // 로컬 객체 메소드 호출
        b.method2();

        // 로컬 변수 수정
        /*
         * Local variable arg defined in an enclosing scope must be final or effectively
         * final 에러발생
         */
        // arg = 3;
        // var = 3;
    }

}
