package org.example.Command;

@FunctionalInterface
public interface StudentAddedListener {
    void onAdded(String lastName, String firstName, String middleName, String group);
}
