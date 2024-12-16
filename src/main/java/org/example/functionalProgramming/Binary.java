package org.example.functionalProgramming;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArrayList<MyStudent> students = new ArrayList<>();
        int mark = 0;
        String surname = " ";
        MyStudent student = new MyStudent(surname, mark);
        boolean noStudent = true;
        System.out.print("Введите фамилию: ");
        surname = scanner.next();
        while (!surname.equals("выход")) {
            System.out.print("Введите оценку: ");
            mark = scanner.nextInt();
            student = new MyStudent(surname, mark);
            students.add(student);
            System.out.print("Введите Фамилию: ");
            surname = scanner.next();
        }

        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("data.bin"))) {
            short size = (short) students.size();
            ByteBuffer buffer1 = ByteBuffer.allocate(2);
            buffer1.putShort(size);
            byte[] data2 = buffer1.array();
            stream.write(data2);
            for (int i = 0; i < students.size(); i++) {
                MyStudent student1 = students.get(i);
                byte[] nameBytes = student1.name.getBytes();
                ByteBuffer buffer = ByteBuffer.allocate(2 + nameBytes.length + 1);
                buffer.putShort((short) nameBytes.length);
                buffer.put(nameBytes);
                buffer.put(student1.mark);

                byte[] data = buffer.array();

                stream.write(data);
            }
        }
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("data.bin"))) {
            ArrayList<MyStudent> students1 = new ArrayList<>();
            byte[] sizeStudents1 = new byte[2];
            short size1 = ByteBuffer.wrap(sizeStudents1).getShort();
            byte[] nameData1 = new byte[size1];
            stream.read(nameData1);

            for (int i = 0; i < nameData1.length; i++) {
                byte[] sizeStudents = new byte[2];
                stream.read(sizeStudents);

                short size = ByteBuffer.wrap(sizeStudents).getShort();
                byte[] nameData = new byte[size];
                stream.read(nameData);

                String name = new String(nameData);
                byte mark1 = (byte) stream.read();
                MyStudent student1 = new MyStudent(name,mark1);
                students1.add(student1);
            }
            System.out.print("Введите фамилию ученика :");
            String SearchName = scanner.next();
            for (int i = 0; i < students1.size(); i++) {
                if (students1.get(i).name.equals(SearchName)) {
                    System.out.println("Оценка этого студента: " + student.mark);
                    noStudent = false;
                }
            }
            if (noStudent) {
                System.out.println("Такого ученика нет в списке!");
            }
        }
    }
}

class MyStudent {
    String name;
    byte mark;

    public MyStudent(String name, int mark) {
        this.name = name;
        this.mark = (byte) mark;
    }
}