# 11 예외 처리

## 예외와 예외 클래스

- 일반 예외(Exception) : 컴파일러가 예외처리 코드 여부를 검사하는 예외
- 실행 예외(Runtime Exception) : 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
- ![예외 리스트](/src/ch11/image/exception_list.jpg)

## 예외 처리 코드

- 예외 처리 코드는 `try-catch-finally` 블록으로 구성된다
- `try` 블록에서 예외가 발생하면 `catch` 블록이 실행되고 연이어 `finally`블록이 실행된다
- **예외 발생 여부와 상관 없이** `finally` 블록은 항상 실행된다(`try` 블록에서 `return` 하더라도!!)
- `catch` 블록이 여러개라도 실행은 단 하나만 된다 그 이유는 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 `catch`블록으로 이동하기 때문
- 두가지 예외를 동일하게 처리하고 싶다면 `|`기호를 이용해 두 예외를 연결하면 된다 (exception1 | exception2 e)
- catch 문에서 받은 `e` 객체에서 에러 정보를 얻을때
  1.  e.getMessage() :예외가 발생한 이유만 리턴
  2.  e.toString() :예외의 종류도 리턴
  3.  e.printStackTrace() : 예외가 어디서 발생했는지 추적한 내용까지 출력

## 리소스 자동 닫기

- `resource`란 데이터를 제공하는 객체를 의미한다.
- 사용하기 위해 열어야 하며 사용이 끝난 후엔 닫아야 한다.
- 리소스를 사용하다가 예외가 발생하더라도 해당 리소스를 닫는것이 중요하다.
- `try-with-resource` 블록은 예외 발생과 상관없이 리소스를 자동으로 닫아준다.

```java
try(
    FileInputStream fis1 = new FileInputStream("file1.txt"); //파일2개는 ;를 이용해서 분리
    FileInputStream fis2 = new FileInputStream("file2.txt")
){

}catch(Exception e){

}
```

- `try-with-resource`는 리소스가 `AutoCloserble` 인터페이스를 재정의 해야지만 사용할 수 있다.
- java 8 이전에는 try괄호 안에서 반드시 변수를 선언해야 했지만 java 9이후에는 외부 리소스 변수를 사용할 수 있다.

```java
    FileInputStream fis1 = new FileInputStream("file1.txt"); //파일2개는 ;를 이용해서 분리
    FileInputStream fis2 = new FileInputStream("file2.txt");

    try(fis1;fis2){
        ...
    }catch(IOException e){

    }
```

## 예외 떠넘기기

- 예외는 `try-catch` 문으로 처리하는게 기본이지만 `throws` 키워드를 통해 호출한 곳으로 예외를 떠넘길 수 있다.

```java

//method2 의 예외처리를 method1에서 처리하는 예제 코드
public void method1(){
    try{
        method2();
    }catch(ClassNotFoundException e)    {
        System.out.println("예외 처리 :"+ e.getMessage());
    }
}

public void method2() throws ClassNotFoundException{
    Class.forName("java.lang.String2");
}

```

- 나열해야 하는 클래스가 많은 경우 `throws Exception` 혹은 `throws Throwable` 만으로 모든 예외를 간단히 떠넘길 수 있다.
- `main` 메소드에서도 `throws` 키워드를 사용할 수 있는데, 결국 `JVM`이 최종적으로 처리를 하고 예외의 내용을 출력하는 것으로 처리한다.

## 사용자 정의 예외

- 사용자 정의 예외는 일반예외,실행 예외 둘다 선언할 수 있다.
- 일반 예외는 `Exception`의 자식 클래스로 선언하고 실행 예외는 `RuntimeException`의 자식 클래스로 선언한다.

```java
// 기본 생성자와 예외 메시지를 입력받는 생성자 선언
public class XXXException extends [Exception | RuntimeException]{
    public XXXException(){

    }

    public XXXException(String message) {
        super(message)
    }
}

```
