package tasks;

public abstract class Task {

    public Task() {
        super();
    }

    public abstract boolean activate();

    public abstract void execute();

    public abstract String status();

    public abstract void init();

}
