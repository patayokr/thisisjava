package ch12.sec03.exam02;

/**
 * 객체를 동등 비교하기 위해 hashCode 메소드와 equals 메소드를 재정의 함
 */
public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    /**
     * Object의 hashCode를 재정의해서 학생 번호와 이름 해시코드를 조합해 새로운 해시코드를 리턴하도록 함
     */
    @Override
    public int hashCode() {
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    /**
     * Student 객체인지 확인하고 학생번호와 이름이 같다면 true를 리턴하도록 함
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student target) {
            if (no == target.getNo() && name.equals(target.getName())) {
                return true;
            }
        }
        return false;
    }
}
