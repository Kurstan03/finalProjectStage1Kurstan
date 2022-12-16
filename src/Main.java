import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.


        List<Book> books = new ArrayList<>();
        books.add(
                new Book(123L, "JAVA", Genre.HISTORICAL,
                        new BigDecimal(77000), " James Concerns",
                        Language.ENGLISH, LocalDate.of(2017, 11, 11)));
        List<User> users = new ArrayList<>();
//        users.add(
//                new User(222, "Kurstan", "kurstan@gmail", "+996777889966", Gender.MALE, )
//        )
        

    }
}