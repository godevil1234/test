package org.example.factorymethod;

public class VisualEditor extends Editor {
    @Override
    protected FileDisplay createFileDisplay(String filename) {
        if (!filename.endsWith(".xml")) return null;
        return new VisualFileDisplay();
    }
}
