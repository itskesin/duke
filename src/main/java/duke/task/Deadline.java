package duke.task;

public class Deadline extends Task {

    protected String by;
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String saveTask() {
        return "D | " + (super.isDone ? 1 : 0) + " | " + super.description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by + ")";
    }
}
