import java.util.ArrayList;
import java.util.List;


class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }


    public void addComponent(FileSystemComponent component) {
        if (!components.contains(component)) {
            components.add(component);
        } else {
            System.out.println("Компанет \"" + component.name + "\" уже существует в\"" + name + "\".");

        }
    }



    @Override
    public void display(String indent) {
        System.out.println(indent + "Каталог: " + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "  ");
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
