package section11_abstraction.exercise;

/**
 * interface는 자동으로 public, abstract 선언됨
 * 접근 지정자는 하위 구현체에서 상속받아 구현할때 변경, 인터페이스에서는 오직 public
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
