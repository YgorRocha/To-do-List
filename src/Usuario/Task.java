package Usuario;

public class Task {
    private String title;
    private boolean finish;

    //GETTER AND SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFinish() {
        return finish;
    }

    public boolean setFinish(boolean finish) {
        this.finish = finish;
        return finish;
    }
}
