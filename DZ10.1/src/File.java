
class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Файл: " + name + " (Размер: " + size + ")");
    }

    @Override
    public int getSize() {
        return size;
    }
}
