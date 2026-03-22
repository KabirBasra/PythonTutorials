public class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public int getPriority() { return priority; }
    public String getName() { return name; }
    public void setPriority(int x) { this.priority = x; }
    public void setName(String x) { this.name = x; }

    public Task(String pname, int npriority) {
        this.name = pname; 
        this.priority = npriority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    } 

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}