package TaskTrackingProj;

public class Task {

    private boolean completed = false;
    private String task;

    public Task(String task) {
        this.task = task;
    }

    public void taskCompleted(){
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void updateTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}
