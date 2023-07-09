import basic.Array;
import basic.Autoboxing;
import basic.MoreLists;
import basic.MyIterator;
import exercise.section11.*;

public class Main {

    public static void main(String[] args) {

        SearchTree list = new SearchTree(null);
        list.traverse(list.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
//        list.removeItem(new Node("Sydney"));
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("Perth"));
//        list.traverse(list.getRoot());
    }

}
