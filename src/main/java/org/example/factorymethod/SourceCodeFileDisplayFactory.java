package org.example.factorymethod;

public class SourceCodeFileDisplayFactory implements FileDisplayFactory {
    @Override
    public boolean supportsFileType(String filename) {
        return true;
    }

    @Override
    public FileDisplay create() {
        return new SourceCodeFileDisplay();
    }
}
