/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv22library;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Shop {

    public static User user;
    List<Book> books;
    List<User> users;
    List<History> histories;
    
    public Shop(List<Book> books, List<User> users, List<History> histories) {
        this.books = books;
        this.users = users;
        this.histories = histories;
    }
    
    public void run() {
        boolean repeat = true;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Показать книги на складе.");
            System.out.println("2. Добавить книгу.");
            System.out.println("3. Удалить книгу.");
            System.out.println("4. Зарегистрировать пользователя.");
            System.out.println("5. Показать пользователей.");
            System.out.println("6. Удалить пользователя.");
            System.out.println("7. Выдать книгу.");
            System.out.println("8. Принять книгу.");
            System.out.println("9. Показать выданные книги.");
            System.out.println("0. Выход.");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("До свидания!");
                    repeat = false;
                    break;
                case "1":
                    this.showBooks();
                    break;
                case "2":
                    this.addBook();
                    break;
                case "3":
                    this.deleteBook();
                    break;
                case "4":
                    this.addUser();
                    break;
                case "5":
                    this.showUsers();
                    break;
                case "6":
                    this.deleteUser();
                    break;
                case "7":
                    this.giveBook();
                    break;
                case "8":
                    this.returnBook();
                    break;
                case "9":
                    this.showHistory();
                    break;
                default:
                    System.out.println("Неверное действие, попробуйте еще раз.");
                    break;
            }
        } while (repeat);
    }
    
    private void showBooks() {
        for (int i = 0; i < this.books.size(); i++) {
            System.out.println(i+1+". "+this.books.get(i).toString());
        }
    }
    
    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Введите название книги:");
        book.setTitle(scanner.nextLine());
        System.out.println("Введите год издания книги:");
        book.setPublishedYear(scanner.nextInt());
        System.out.println("Введите количество авторов:");
        int countAuthors = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthors; i++) {
            System.out.println("Введите имя автора:");
            String firstname = scanner.nextLine();
            System.out.println("Введите фамилию автора:");
            String lastname = scanner.nextLine();
            book.getAuthors().add(new entity.Author(firstname, lastname));
        }
        System.out.println("Введите количество книг:");
        book.setQuantity(scanner.nextInt());
        this.books.add(book);
    }
    
    private void deleteBook() {
        this.showBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер книги для удаления:");
        int delNumber = scanner.nextInt();
        this.books.remove(delNumber - 1);
    }
    
    private void addUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Введите логин пользователя:");
        user.setLogin(scanner.nextLine());
        System.out.println("Введите пароль пользователя:");
        user.setPassword(scanner.nextLine());
        System.out.println("Введите имя пользователя:");
        String firstname = scanner.nextLine();
        System.out.println("Введите фамилию пользователя:");
        String lastname = scanner.nextLine();
        user.setReader(new Reader(firstname, lastname));
        this.users.add(user);
    }
    
    private void showUsers() {
        for (int i = 0; i < this.users.size(); i++) {
            System.out.println(i+1+". "+this.users.get(i).toString());
        }
    }
    
    private void deleteUser() {
        this.showUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер пользователя для удаления:");
        int delNumber = scanner.nextInt();
        this.users.remove(delNumber - 1);
    }
    
    private void giveBook() {
        this.showUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер пользователя для выдачи книги:");
        int userNumber = scanner.nextInt();
        this.showBooks();
        System.out.println("Выберите номер книги для выдачи:");
        int bookNumber = scanner.nextInt();
        Book book = this.books.get(bookNumber - 1);
        User user = this.users.get(userNumber - 1);
        History history = new History();
        history.setBook(book);
        history.setUser(user);
        history.setTakeOutBook(new Date());
        this.histories.add(history);
        book.setCount(book.getCount() - 1);
    }
    
    private void returnBook() {
        this.showHistory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер выданной книги для возврата:");
        int historyNumber = scanner.nextInt();
        History history = this.histories.get(historyNumber - 1);
        history.setReturnBook(new Date());
        Book book = history.getBook();
        book.setCount(book.getCount() + 1);
    }
    
    private void showHistory() {
        for (int i = 0; i < this.histories.size(); i++) {
            System.out.println(i+1+". "+this.histories.get(i).toString());
        }
    }
}
