package section10_list;

public class Autoboxing {

    public static void run() {

        Integer boxedInt = Integer.valueOf(15);         // preferred but unnecessary
        Integer deprecatedBoxing = new Integer(15);  // deprecated since JDK 9
        int unboxedInt = boxedInt.intValue();              // unnecessary

        // Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
//        System.out.println(autoUnboxed.getClass().getName());

    }
}
