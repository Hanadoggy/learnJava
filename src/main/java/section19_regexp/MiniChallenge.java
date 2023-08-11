package section19_regexp;

public class MiniChallenge {

    public static void main(String[] args) {

        String sentence = "Hello, World!";
        boolean matches = sentence.matches("Hello, World!");
        // matches는 문자열의 모든 문자를 매치함
        System.out.println(matches);

        System.out.println("-----------------------");
        String[] params = {
                "The bike is red.",
                "I am a new student.",
                "hello World.",
                "How are you?"
        };
        for (String param : params) {
            boolean check = param.matches("[A-Z].*\\.");
            System.out.println(check + " : " + param);
        }

        System.out.println("-----------------------");
        String[] params2 = {
                "The bike is red, and has flat tires.",
                "I love being a new L.P.A. student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?"
        };
        for (String param : params2) {
            boolean check = param.matches("^[A-Z][\\p{all}]+[.!]$");
            System.out.println(check + " : " + param);
        }
    }

}
