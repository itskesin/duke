package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String saveTask() {
        return "T | " + (super.isDone ? 1 : 0) + " | " + super.description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}