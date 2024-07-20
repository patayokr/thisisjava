package ch03.sec06;

public class CompareOperatorExample {
    public static void main(String[] args) {
        // 0.1f 와 0.1을 비교하면 true가 나올것 같지만 그렇지 않다
        /*
         * 0.1f 가 double 형태로 바뀌고 0.1 리터럴과 비교할시
         * 1. 부동소수점 타입은 소수를 온전히 표현 할 수 없음
         * 2. float 와 double 의 정밀도 가 다르기 때문
         * 
         * 따라서 피연산자를 float 형식으로 강제변환 하면 의도한 결과가 나온다.
         */

        boolean result1 = 0.1f == 0.1;

        System.out.println("result1: " + result1);

        boolean result2 = 0.1f == (float) 0.1;

        System.out.println("result2:" + result2);

    }
}
