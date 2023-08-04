package section15_collections.challenge_set_operation;

import java.util.*;

public class TaskMain {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> result = new HashSet<>(tasks);
        result.addAll(annsTasks);
        result.addAll(bobsTasks);
        result.addAll(carolsTasks);
        sortAndPrint("full task list", result, sortByPriority);

        Set<Task> result2 = new HashSet<>(annsTasks);
        result2.addAll(bobsTasks);
        result2.addAll(carolsTasks);
        sortAndPrint("assigned tasks", result2, sortByPriority);

        Set<Task> result3 = new HashSet<>(result);
        result3.removeAll(result2);
        sortAndPrint("not assigned tasks", result3, sortByPriority);

        Set<Task> result4_1 = new HashSet<>(annsTasks);
        result4_1.retainAll(bobsTasks);
        Set<Task> result4_2 = new HashSet<>(annsTasks);
        result4_2.retainAll(carolsTasks);
        Set<Task> result4 = new HashSet<>(bobsTasks);
        result4.retainAll(carolsTasks);
        result4.addAll(result4_1);
        result4.addAll(result4_2);
        sortAndPrint("multiple tasks", result4, sortByPriority);

        Set<Task> result5 = new HashSet<>(result);
        result5.removeAll(tasks);
        sortAndPrint("missing tasks", result5, sortByPriority);
    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> result = new HashSet<>();
        sets.forEach(result::addAll);
        return result;
    }

    private static Set<Task> getIntersect(Set<Task> setA, Set<Task> setB) {
        Set<Task> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
    }

    private static Set<Task> getDifference(Set<Task> setA, Set<Task> setB) {
        Set<Task> result = new HashSet<>(setA);
        result.removeAll(setB);
        return result;
    }


    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collections, Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collections);
        list.sort(sorter);
        list.forEach(System.out::println);
    }



}
