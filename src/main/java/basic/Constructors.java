package basic;

public class Constructors {

    static class Account {

        private String name;
        private int age;
        private String phone;

        /**
         * 생성자는 다른 생성자를 호출 가능 (Constructor chaining)
         * this 키워드로 사용, 무조건 맨 첫 줄에서 호출해야 함
         * 여러 대의 생성자를 사용하는 경우 full param constructor 하나에서만 초기화 하고 나머지는
         * 해당 main constructor를 호출하는 형식으로 구성하는 것이 바람직
         */
        public Account() {
            this("Default Name", 20);
            System.out.println("Call empty constructor");
        }

        public Account(String name, int age) {
            this(name, age, "010-1234-1234");
            System.out.println("Call name, age constructor");
            // default 값을 주고 싶은 내용을 넣고 나머지는 param 전달
        }

        public Account(String name, int age, String phone) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            System.out.println("Call full param constructor");
            // 생성자 내에서 다른 메서드나 setter 호출하는 것은 부적절
//            setName(name);
//            setAge(age);
//            setPhone(phone);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
