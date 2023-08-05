package section16_etc;

public class BaseClass {

    public final void recommendedMethod() {

        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod]: Customize optional method");
    }

    private void mandatoryMethod() {
        System.out.println("[BaseClass.mandatoryMethod]: NON_NEGOTIABLE!");
    }

    public static void recommendedStatic() {

        System.out.println("[BaseClass.recommendedStatic] BEST way to do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic() {
        System.out.println("BaseClass.optionalStatic]: Optional");
    }

    private static void mandatoryStatic() {
        System.out.println("BaseClass.mandatoryStatic]: Mandatory");
    }
}
