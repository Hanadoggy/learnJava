package basic.nested;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar");
        System.out.println(regularMeal);

        // 환율 하드코딩
        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

    }

}
