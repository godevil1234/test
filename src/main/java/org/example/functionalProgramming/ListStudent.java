package org.example.functionalProgramming;

import java.util.HashMap;

public class ListStudent {
    public String lastName;
    public String firstName;
    public String middleName;
    public String group;
    public HashMap<String,Integer> objects = new HashMap<>();

    ListStudent() {}

    ListStudent(String lastName, String firstName,String middleName, String group,HashMap<String, Integer> objects) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
        this.objects = objects;
    }
    ListStudent(String lastName,String firstName, String middleName, String group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
    }
}
