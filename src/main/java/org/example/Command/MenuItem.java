package org.example.Command;

public abstract class MenuItem {
    private final String title;

    public abstract void run();

    public String getTitle() {
        return title;
    }
    public MenuItem(String title) {
        this.title = title;
    }
}
