package exercise.section11;

import java.util.List;

public interface ISaveable {

    List<String> write();

    void read(List<String> input);
}
