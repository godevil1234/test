package org.example.factorymethod;

public class VisualFileDisplayFactory implements FileDisplayFactory {
    @Override
    public boolean supportsFileType(String filename) {
        return filename.endsWith(".xml");
    }

    @Override
    public FileDisplay create() {
        return new VisualFileDisplay();
    }
}
