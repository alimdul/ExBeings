package by.pivovarevich.ex_beings.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Entity, Serializable {

    private int id;
    private String login;
    private String password;
    private String mail;
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = result * prime + id;
        result = result * prime + ((login == null) ? 0 : login.hashCode());
        result = result * prime + ((password == null) ? 0 : password.hashCode());
        result = result * prime + ((mail == null) ? 0 : mail.hashCode());
        result = result * prime + (!isAdmin ? 0 : Boolean.hashCode(isAdmin));

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login=" + login +
                ", password=" + password +
                ", mail=" + mail +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
