package ch11.sec02;

/**
 * ExceptionHandlingExample2
 */
public class ExceptionHandlingExample2 {

    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자수 :" + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // 예외 정보 얻는 법 1
            // System.out.println(e.toString()); //예외 정보 얻는 법 2
            // e.printStackTrace(); //예외 정보 얻는 법 3
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");

    }
}