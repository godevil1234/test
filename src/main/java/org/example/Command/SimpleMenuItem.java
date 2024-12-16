package org.example.Command;


public class SimpleMenuItem extends MenuItem {
    private final Runnable action;
    public SimpleMenuItem(String title, Runnable action) {
        super(title);
        this.action = action;
    }

    @Override
    public void run() {
        action.run();
    }


}
