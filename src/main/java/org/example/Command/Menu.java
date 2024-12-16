package org.example.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends MenuItem{
    private final List<MenuItem> items = new ArrayList<>();
    private boolean running = true;
    private final boolean menuMain;
    private Runnable onHookStart = null;
    private Runnable onHookShow = null;
    private Runnable onHookClose = null;

    public Menu(){
        super("");
        menuMain = true;
    }
    private Menu(String title) {
        super(title);
        menuMain = false;
    }

    public MenuItem addItem(String title, Runnable action){
        SimpleMenuItem item = new SimpleMenuItem(title,action);
        items.add(item);
        return item;
    }
    public Menu addSubMenu(String title) {
        Menu subMenu = new Menu(title);
        items.add(subMenu);
        return subMenu;
    }

    @Override
    public void run() {
        onHook(onHookStart);
        while (running){
            onHook(onHookShow);
            showMenu();
            selectedItem();
        }
        onHook(onHookClose);
    }
    private void showMenu(){
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + "." + " " + items.get(i).getTitle());
        }
        if (menuMain) {
            System.out.println(items.size() + 1 + "." + " " + "Выход");
        } else {
            System.out.println(items.size() + 1 + "." + " " + "Назад");
        }
    }
    private void selectedItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер пункта: ");
        int number = scanner.nextInt();
        if(number <= 0 || number > items.size() + 1) {
            System.out.println("Такого пункта нет!");
        } else if (number == items.size() + 1){
            running = false;
        } else {
            items.get(number - 1).run();
        }
    }
    private void onHook(Runnable onHook){
        if(onHook != null) onHook.run();
    }
    public void setOnHookStart(Runnable onHookStart) {
        this.onHookStart = onHookStart;
    }

    public void setOnHookShow(Runnable onHookShow) {
        this.onHookShow = onHookShow;
    }

    public void setOnHookClose(Runnable onHookClose) {
        this.onHookClose = onHookClose;
    }
}
