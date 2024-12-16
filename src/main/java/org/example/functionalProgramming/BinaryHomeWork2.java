package org.example.functionalProgramming;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class BinaryHomeWork2 {
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
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("output.bin"))) {
            byte[] data = new byte[n * 2];
            stream.read(data);
            ByteBuffer buffer2 = ByteBuffer.wrap(data);
            for (int i = 1; i <= n; i++) {
                short y = buffer2.getShort();
                System.out.println(y * 3);
            }
        }
    }
}
