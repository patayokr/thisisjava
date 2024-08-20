# 인터페이스

## 디폴드 메소드

- 인터페이스에는 완전한 실행 코드를 가진 디폴트 메소드를 선언할 수 있다.
- 선언 방법은 클래스 메소드와 동일한데 차이점은 `default` 키워드가 리턴 타입 앞에 붙는다

> [public] default 리턴타입 메소드명(매개변수, ....) {...}

- 구현 클래스는 디폴트 메소드를 재정의 해서 자신에게 맞게 수정할 수도 있다.
- 재정의시 public 접근 제한자를 **반드시** 붙여야 하고 `default` 키워드를 생략해야 한다.

## 정적 메소드

- 추상메소드와 디폴트 메소드는 구현 객체가 필요하지만 정적 메소드는 구현 객체가 없어도 인터페이스만으로 호출할 수 있다.
- 선언 방법은 클래스 메소드와 동일하지만 `public`을 생략하더라도 자동으로 컴파일 과정에서 붙게된다.

## private 메소드

- 인터페이스의 상수필드,추상 메소드,디폴트 메소드,정적 메소드는 모두 `public` 접근 제한자를 가지지만 `private` 메소드 선언도 가능하다.
- `private` 메소드는 디폴트 메소드 안에서만 호출이 가능하다
- `private` 정적 메소드는 디폴트 메소드 뿐만 아니라 정적 메소드 안에서도 호출이 가능하다.

## 인터페이스 상속

- 인터페이스도 다른 인터페이스를 상속할 수 있으며 클래스와 달리 다중 상속을 허용한다.
```java public interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2 {...}```

## 봉인된 인터페이스

- 봉인된 클래스와 같이 인터페이스도 봉인할 수 있다.
- InterfaceA의 자식 인터페이스는 InterfaceB만 가능하고 그 이외에는 자식 인터페이스가 될수 없도록 할수 있다.
```java public sealed interface InterfaceA permits InterfaceB```
- 봉인된 InterfaceA를 상속하는 InterfaceB는 `non-sealed` 키워드로 다음과 같이 선언하거나 `sealed`키워드를 사용해서 또다른 봉인 인터페이스로 선언해야 한다.
```java non-sealed interface InterfaceB extends InterfaceA {...}```
- `non-sealed` 키워드는 봉인을 해제한다는 뜻으로 InterfaceB는 또다른 자식 인터페이스를 만들 수 있다.
```java public interface InterfaceC extends InterfaceB```
