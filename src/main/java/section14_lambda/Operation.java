package section14_lambda;

@FunctionalInterface
public interface Operation<T> {

    /**
     * Functional Interface 구현
     * Single Abstract Method 가짐
     * 람다 표현식을 사용하면 자바가 알아서 타입등을 추론하여 메서드를 실행시킴
     */
    T operate(T value1, T value2);
}
