package id.ac.ui.cs.mobileprogramming.activity1;

public class Item {
    private String course;
    private String task;
    private String details;

    public Item(String course, String task, String details) {
        this.course = course;
        this.task = task;
        this.details = details;
    }

    public String getCourse() {
        return course;
    }

    public String getTask() {
        return task;
    }

    public String getDetails() {
        return details;
    }
}
