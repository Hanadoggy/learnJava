package section15_collections.challenge_set_operation;

enum Status {ASSIGNED, IN_PROGRESS, IN_QUEUE}
enum Priority {HIGH, MEDIUM, LOW}

public class Task implements Comparable<Task> {

    private String assignee;
    private String project;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String project, String description, Priority priority, String assignee, Status status) {
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Task(String project, String description, Priority priority, String assignee) {
        this(project, description, priority, assignee,
                assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        this(project, description, priority, null);
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(
                project, description, priority, assignee, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!getProject().equals(task.getProject())) return false;
        return getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {

        int result = this.project.compareTo(o.project);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }

        return result;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
