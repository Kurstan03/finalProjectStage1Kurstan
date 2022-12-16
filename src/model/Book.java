package model;


import enums.Genre;
import enums.Language;
import exceptions.NegativeNumberException;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.EmptyStackException;

public class Book implements Comparable<Book>{
    private Long id;
    private String name;
    private Genre genre;
    private BigDecimal price;
    private String author;
    private Language language;
    private LocalDate publishedYear;

    public Book(Long id, String name, Genre genre, BigDecimal price, String author, Language language, LocalDate publishedYear) {
        try {
            this.id = id;
            this.name = name;
            this.genre = genre;
            if (price.intValue() > 0) {
                this.price = price;
            } else {
                throw new NegativeNumberException();
            }
            if (!author.equals("")) {
                this.author = author;
            } else {
                throw new EmptyStackException();
            }
            this.language = language;
            if (publishedYear.getYear() <= LocalDate.now().getYear()) {
                this.publishedYear = publishedYear;
            } else {
                throw new DateTimeException("error");
            }
        } catch (NegativeNumberException e){
            System.out.println("NegativeNumberException");
        } catch (EmptyStackException e){
            System.out.println("EmptyStackException");
        } catch (DateTimeException e){
            System.out.println("DateTimeException");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", language=" + language +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return o.getPrice().intValue() - getPrice().intValue();
    }
}
