package org.example.factorymethod;

public interface FileDisplayFactory {
    boolean supportsFileType(String filename);
    FileDisplay create();
}
