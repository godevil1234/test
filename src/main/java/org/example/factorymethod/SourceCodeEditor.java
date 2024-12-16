package org.example.factorymethod;

import org.example.factorymethod.Editor;

public class SourceCodeEditor extends Editor {
    @Override
    protected FileDisplay createFileDisplay(String filename) {
        return new SourceCodeFileDisplay();
    }
}
