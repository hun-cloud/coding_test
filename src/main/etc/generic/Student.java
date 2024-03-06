package main.etc.generic;

public class Student <T>{

//  static T name; static 변수는 사용할 수 없음
    /*
    * Student 클래스가 인스턴스가 되기 전에 static은 메모리에 올라가는데
    * 이 때 name 타입인 T가 결정되지 않았기 떄문에 사용할 수 없다.
    * */

//    static T getName(T name) {
//        return name;
//    } 에러 발생
    /*
    * static 변수와 마찬가지로 Student 클래스가 인스턴스화 되기 전에 메모리에 올라가는데
    * T의 타입이 정해지지 않았기 때문이다.
    * */

    static <T> T getOneStudent(T id) {
        return id;
    }

    /*
    * 제네릭 메서드는 static이 가능하다. 호출 시에 매개 타입을 지정하기 때문에
    * static이 가능하다.
    * 주의할 점은 Student 클래스에 지정한 제네릭타입 T와 지네릭 메소드에 붙은 T는
    * 같은 T를 사용하더라도 전혀 별개라는 것이다.
    *
    * 클래스에 표시하는 T는 인스턴스 변수라고 생각하자. 인스턴스가 생성될 때마다 지정되기 때문이다.
    * 그리고 제네릭 메서드가 붙은 T는 지역변수를 선언한 것과 같다고 생각하다.
    * (메서드에 붙은 모든 T는 클래스에 붙은 T와 다르다.)
    * */

}
