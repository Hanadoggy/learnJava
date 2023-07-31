package section11_abstraction.exercise;

import java.util.List;

public interface ISaveable {

    List<String> write();

    void read(List<String> input);
}
