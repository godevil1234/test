package org.example.functionalProgramming;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class BinaryHomeWork {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.print("Введите число: ");
        short n = scanner.nextShort();
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("output.bin"))) {
            ByteBuffer buffer = ByteBuffer.allocate(n * 2);
            for (short i = 1; i <= n; i++) {
                buffer.putShort(i);
            }
            byte[] data = buffer.array();

            stream.write(data);
        }
        File file = new File("output.bin");
        long fileSize = file.length();
        byte[] data = new byte[(int) fileSize];
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file))) {
            stream.read(data);
            ByteBuffer buffer2 = ByteBuffer.wrap(data);
            while (buffer2.hasRemaining()) {
                short y = buffer2.getShort();
                System.out.println(y * 3);
            }
        }
    }
}

