package basic;

/**
 * Record는 Java 16에 도입
 * parameter로 record header를 구성
 * header를 참조하여 field로 생성 (private, final = 불변객체)
 * get 대신 해당 필드의 이름으로 접근
 */
public record Student(String id, String name, String clazz) {
}
