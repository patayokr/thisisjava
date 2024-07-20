package ch03.sec08;

public class BitLogitExample {

    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("----------------------");

        // 해당 값은 최상위비트를 값으로 사용하는 unsigned byte 값으로 원래는 136이다.
        // java 에서는 -120으로 인식한다
        byte receiveData = -120;

        // 방법1 : 비트 논리곱 연산으로 Unsigned 정수 얻기
        // 논리곱 하면 자기 자신이 나오고 255 리터럴과 연산하면 int로 자동 변환되기 때문에 원래 값이 나온다.
        int unsignedInt1 = receiveData & 255;

        System.out.println(unsignedInt1);

        // 방법2 :자바 API를 이용해서 Unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;

        // 바이트 형식으로 변환하여 값을 자르면 -120이 나온다.
        byte btest = (byte) test;
        System.out.println(btest);

    }
}