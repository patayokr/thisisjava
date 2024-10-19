# 12 java.base 모듈

## 12.1 API 도큐먼트

- 라이브러리가 클래스와 인터페이스의 집합이라면 API도큐먼트는 이를 사용하기 위한 방법을 기술한 것이다.
- [API 도큐먼트 링크](https://docs.oracle.com/en/java/javase/index.html)

## 12.2 java.base 모듈

- java.base는 모든 모듈이 의존하는 기본 모듈로 유일하게 `requires` 하지 않아도 사용할 수 있다.

![java.lang 구성요소](/src/ch12/image/java.lang.jpg)

## 12.3 Object 클래스

- 클래스를 선언할 때 `extends` 키워드로 다른 클래스를 상속하지 않으면 암시적으로 `java.lang.Object`클래스를 상속하게 된다
- 따라서 모든 클래스는 `Object` 클래스의 자식이거나 자손 클래스이다.
- `Object` 클래스가 가지고 있는 주요 메소드
  - `boolean equals(Object obj)` : 객체의 번지를 비교하고 결과를 리턴
  - `int hashCode()` : 객체의 해시코드를 리턴
  - `String toString()` : 객체의 문자 정보를 리턴
- 일반적으로 `Object`의 `equals`메소드는 재정의 해서 동등 비교용으로 사용된다

```java
Object obj1 = new Object();
Object Obj2  = new Object();
boolean result1  = obj1.equals(obj2);
boolean result2 = (obj1==obj2);
//result1 과 result2는 결과가 동일함
```

### 객체 해시코드

- 객체 해시코드란 객체를 식별하는 정수를 말한다.
- `Object`의 `hashCode`메소드는 객체의 메모리 번지를 이용해서 해시코드를 생성하기 때문에 객체마다 다른 정수값을 리턴한다.
- 메소드의 용도는 `equals`메소드와 비슷한데 두 객체가 동등한지 비교할 때 주로 사용된다
- [예제](/src/ch12/sec03/exam02/Student.java)

### 객체 문자 정보

- `Object`의 `toString()` 메소드는 객체의 문자 정보(기본적으로 **클래스명@16진수해시코드**)로 구성된 문자열을 리턴한다.
- 객체의 문자정보가 중요한 경우에는 `Object의 `의 `toString()` 메소드를 재정의해서 간결하고 유익한 정보를 리턴하도록 변경할 수 있다.

### 레코드 선언

- 데이터 전달을 위한 `DTO(Data transfer Object)`를 작성할 때 반복적으로 사용되는 코드를 줄이기 위해 Java 14부터 **레코드(record)** 가 도입되었다.

```java

/**
 * 1. 읽기만 가능한 필드
*2. 필드이름과 동일한 Getter 메소드
*3. 동등 비교를 위해 hashCode(),equals()메소드 재정의
*4. 문자열 출력을 위한 toString()메소드 재정의
*/

public class Person{
private final String name;
private final int age;

public Person(String name,int age) {
    this.name=name;
    this.age= age;
}

public String name() {return this.name;}
public int age() {return this.age;}

@Override
public int hashCode{...}

@Override
public boolean equals(Object obj){...}

@Override
public String toString(){...}
}

```

- 다음 코드는 위와 동일한 코드를 선언하는 레코드 선언이다.

```java

public record Person(String name, int age){}
```

### 롬복

- `lombok(롬복)`은 JDK에 포함된 표준 라이브러리는 아니지만 개발자들이 즐겨쓰는 자동 코드생성 라이브러리이다.
- `dto`클래스를 작성할때 Getter,Setter,hashCode(),equals(),toString()메소드를 자동 생성한다.
- `record`와의 차이점은 필드가 `final`이 아니며 값을 읽는 getter ,setter는 각각 `getXXX()`,`setXXX()`,`isXXX()` 로 명명된다.
- [lombok 예시](/src/ch12/sec03/exam05/Member.java)