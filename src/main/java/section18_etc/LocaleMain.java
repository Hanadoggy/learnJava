package section18_etc;

import java.util.Locale;

public class LocaleMain {

    public static void main(String[] args) {

        Locale.setDefault(Locale.JAPAN);
        System.out.println("Default Locale = " + Locale.getDefault());
    }

}
