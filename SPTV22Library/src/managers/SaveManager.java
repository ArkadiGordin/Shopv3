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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SaveManager {
    public void saveBooks(List<Book> books){
        Path path = Paths.get("books");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            ObjectOutputStream oos = new ObjectOutputStream(
                    Files.newOutputStream(path));
            oos.writeObject(books);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Book> loadBooks(){
        Path path = Paths.get("books");
        if(Files.exists(path)){
            try {
                ObjectInputStream ois = new ObjectInputStream(
                        Files.newInputStream(path));
                List<Book> books = (List<Book>)ois.readObject();
                ois.close();
                return books;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArrayList<>();
    }
    
    public void saveReaders(List<User> users){
        Path path = Paths.get("users");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            ObjectOutputStream oos = new ObjectOutputStream(
                    Files.newOutputStream(path));
            oos.writeObject(users);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<User> loadUsers(){
        Path path = Paths.get("users");
        if(Files.exists(path)){
            try {
                ObjectInputStream ois = new ObjectInputStream(
                        Files.newInputStream(path));
                List<User> users = (List<User>)ois.readObject();
                ois.close();
                return users;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArrayList<>();
    }
    
    public void saveHistories(List<History> histories){
        Path path = Paths.get("histories");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            ObjectOutputStream oos = new ObjectOutputStream(
                    Files.newOutputStream(path));
            oos.writeObject(histories);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<History> loadHistories(){
        Path path = Paths.get("histories");
        if(Files.exists(path)){
            try {
                ObjectInputStream ois = new ObjectInputStream(
                        Files.newInputStream(path));
                List<History> histories = (List<History>)ois.readObject();
                ois.close();
                return histories;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArrayList<>();
    }
}