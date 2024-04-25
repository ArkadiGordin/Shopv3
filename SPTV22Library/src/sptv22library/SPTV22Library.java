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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class SPTV22Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SaveManager sm = new SaveManager();
        List<Book> books = sm.loadBooks();
        List<User> users = sm.loadUsers();
        List<History> histories = sm.loadHistories();
        Shop shop = new Shop(books, users, histories);
        shop.run();
        sm.saveBooks(shop.books);
        sm.saveReaders(shop.users);
        sm.saveHistories(shop.histories);
    }
}