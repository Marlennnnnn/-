import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s (ISBN: %s) - %s",
                title, author, isbn, isAvailable ? "Доступно" : "Занят");
    }
}

// Класс Reader
class Reader {
    private String name;
    private List<Book> rentedBooks;
    private static final int MAX_RENTED_BOOKS = 3;

    public Reader(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean borrowBook(Book book) {
        if (rentedBooks.size() >= MAX_RENTED_BOOKS) {
            System.out.println(name + " не может брат болше " + MAX_RENTED_BOOKS + " книг.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Книга  '" + book.getTitle() + "' не доступно.");
            return false;
        }
        book.rent();
        rentedBooks.add(book);
        System.out.println(name + " Взял: " + book.getTitle());
        return true;
    }

    public void returnBook(Book book) {
        if (rentedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " вернул книгу: " + book.getTitle());
        } else {
            System.out.println(name + " не брал книгу напрокат: " + book.getTitle());
        }
    }

    public void showRentedBooks() {
        System.out.println(name + "'книги, взятые напрокат:");
        for (Book book : rentedBooks) {
            System.out.println("- " + book);
        }
    }
}


class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println(name + " Добавил книгу: " + book.getTitle());
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
        System.out.println(name + " Удалил книгу: " + book.getTitle());
    }
}


class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void showAllBooks() {
        System.out.println("Все книги:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Кайрат");
        Reader reader = new Reader("Серикбол");

        Book book1 = new Book("Меним атым кожа", "Бердибек Сокпакбаев", "1234");
        Book book2 = new Book("Абай жолы ", "Мухтар Ауезов", "9876");
        Book book3 = new Book("Война и мир", "Лев Толстой", "1111");

        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);


        library.showAllBooks();


        reader.borrowBook(book1);
        reader.borrowBook(book2);


        reader.showRentedBooks();


        library.showAllBooks();


        reader.returnBook(book1);


        library.showAllBooks();


        System.out.println("Результаты поиска по запросу:");
        for (Book book : library.searchBooks("great")) {
            System.out.println("- " + book);
        }
    }
}
