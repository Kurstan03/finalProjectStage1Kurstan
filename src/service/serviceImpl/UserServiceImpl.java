package service.serviceImpl;

import enums.Gender;
import model.Book;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();
    @Override
    public String createUser(List<User> users) {
        this.users.addAll(users);
        return "Users created";
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public User findUserById(Long id) {
        User userStream = (User) this.users.stream().filter(x -> Objects.equals(x.getId(), id));
        return userStream;
    }

    @Override
    public String removeUserByName(String name) {
        User userStream = (User) this.users.stream().filter(x -> x.getName().equals(name));
        this.users.remove(userStream);
        return "User removed";
    }

    @Override
    public void updateUser(Long id) {
        User userStream = (User) this.users.stream().filter(x -> x.getId().equals(id));
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        System.out.println("""
                1.id
                2.name
                3.surname
                4.email
                5.phone number
                6.gender
                7.money
                8.books
                """);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                userStream.setId(new Scanner(System.in).nextLong());
                break;
            case 2:
                userStream.setName(new Scanner(System.in).nextLine());
                break;
            case 3:
                userStream.setSurname(new Scanner(System.in).nextLine());
                break;
            case 4:
                userStream.setEmail(new Scanner(System.in).nextLine());
                break;
            case 5:
                userStream.setPhoneNumber(new Scanner(System.in).nextLine());
                break;
            case 6:
                Scanner scanner1 = new Scanner(System.in);
                String gen = scanner.nextLine();
                userStream.setGender(Gender.valueOf(gen));
                break;
            case 7:
                userStream.setMoney(new BigDecimal(new Scanner(System.in).nextInt()));
                break;
        }
    }

    @Override
    public void groupUsersByGender() {
        for (User u : this.users) {
            if (u.getGender() == Gender.FEMALE){
                System.out.println(u);
            } else {
                System.out.println(u);
            }
        }
    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        User userStream = (User) this.users.stream().filter(x -> x.getName().equals(name));
        int sum = 0;
        for (Book b : books) {
            userStream.setMoney(userStream.getMoney().subtract(b.getPrice()));
            userStream.getBooks().add(b);
        }
        return "Books bayed";
    }
}
