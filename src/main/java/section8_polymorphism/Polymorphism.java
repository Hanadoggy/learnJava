package section8_polymorphism;

public class Polymorphism {

    public static void run() {

//        Object movie1 = Movie.getMovie("C", "Airplane");
//        movie1.watchComedy();

        var movie2 = Movie.getMovie("C", "Airplane");
        movie2.watchMovie();

        Object unknownObject = Movie.getMovie("C", "Airplane");
        if (unknownObject.getClass() ==  Comedy.class) {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction scienceFiction) {
            scienceFiction.watchScienceFiction();
        }
    }
}

class Movie {

    protected String title;

    public Movie(String title) {
        this.title = title;
    }

    public static Movie getMovie(String type, String title) {

        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }

    public void watchMovie() {
        System.out.println("Watch a Movie" + title);
    }
}

class Adventure extends Movie {

    public Adventure(String title) {
        super(title);
    }

    public void watchAdventure() {
        System.out.println("Watch an Adventure" + title);
    }
}

class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    public void watchComedy() {
        System.out.println("Watch a Comedy" + title);
    }
}

class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    public void watchScienceFiction() {
        System.out.println("Watch a ScienceFiction Thriller!" + title);
    }
}
