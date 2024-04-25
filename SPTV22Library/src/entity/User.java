/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author admin
 */
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 8186207658102977829L;
    private Reader reader;
    private String login;
    private String password;

    public User() {
    }

    public User(Reader reader, String login, String password) {
        this.reader = reader;
        this.login = login;
        this.password = password;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.reader);
        hash = 71 * hash + Objects.hashCode(this.login);
        hash = 71 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" 
                + "reader=" + reader.getFirstname() 
                + " " + reader.getLastname() 
                + ", login=" + login 
                + ", password=" + password 
                + '}';
    }
    
}