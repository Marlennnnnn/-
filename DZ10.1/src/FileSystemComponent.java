
abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }


    public abstract void display(String indent);


    public abstract int getSize();
}
