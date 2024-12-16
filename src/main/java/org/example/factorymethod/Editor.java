package org.example.factorymethod;

public abstract class Editor {
    private FileDisplay fileDisplay = null;
    private final FileDisplayFactory[] factories = new FileDisplayFactory[] {
            new VisualFileDisplayFactory(),
            new SourceCodeFileDisplayFactory()
    };

    void open() {
        System.out.println("Запросить у пользователя имя открываемого файла");
        String name = "main_window.xml";
        fileDisplay = createFileDisplay(name);
        fileDisplay.open(name);
    }

    void save() {
        System.out.println("Запросить у пользователя имя сохраняемого файла");
        String name = "...";
        fileDisplay.save(name);
    }

    void show() {
        fileDisplay.display();
    }

//    private FileDisplay createFileDisplay(String name) {
//        for (FileDisplayFactory factory : factories) {
//            if (factory.supportsFileType(name)) {
//                return factory.create();
//            }
//        }
//
//        return null;
//    }

    abstract protected FileDisplay createFileDisplay(String filename);
}
