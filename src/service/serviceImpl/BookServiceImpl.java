package service.serviceImpl;

import model.Book;
import service.BookService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class BookServiceImpl implements BookService {
    List<Book> books = new ArrayList<>();
    @Override
    public List<Book> createBooks(List<Book> books) {
//        Scanner scannerInt = new Scanner(System.in);
//        Scanner scannerStr = new Scanner(System.in);
//        System.out.println("ID");
//        Long id = scannerInt.nextLong();
//        System.out.println("name: ");
//        String name = scannerStr.nextLine();
//        System.out.println("genre");
//        String genre = scannerStr.nextLine();
//        BigDecimal price = BigDecimal.valueOf(scannerInt.nextInt());
//        String author = scannerStr.nextLine();
//        System.out.println("language");
//        String language = scannerStr.nextLine();
//        System.out.println();
        this.books.addAll(books);
        return this.books;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return this.books.stream().filter(x -> x.getGenre().name().equals(genre)).toList();
    }

    @Override
    public Book removeBookById(Long id) {
        Book bookStream = (Book) this.books.stream().filter(x -> x.getId().equals(id));
        this.books.remove(bookStream);
        return bookStream;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        return this.books.stream().sorted().toList();
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return this.books.stream().filter(x -> x.getPublishedYear().getYear() > 2012).toList();
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        Scanner scanner = new Scanner(System.in);
        return this.books.stream().filter(x -> x.getName().charAt(0) == scanner.next().charAt(0)).toList();
    }

    @Override
    public Book maxPriceBook() {
        List<Book> sorted = this.books.stream().sorted().toList();
        return sorted.get(0);
    }
}
