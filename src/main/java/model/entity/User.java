package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Entity{
    private static final long serialVersionUID = -7704312194658555099L;
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;
    private boolean blocked;

    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public boolean isBlocked() { return blocked; }
    public void setBlocked(boolean blocked) { this.blocked = blocked; }

    public User() {}

    public User(int id, String firstName, String lastName, String login, String password, Role role, boolean blocked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
        this.blocked = blocked;
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private Role role;
        private boolean blocked;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }
        public Builder setBlocked(boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        public User build() { return new User(id, firstName, lastName, login, password, role, blocked); }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && blocked == user.blocked && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, login, password, role, blocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", blocked=" + blocked +
                '}';
    }

    public enum Role implements Serializable {
        STUDENT,TUTOR, ADMIN, GUEST
    }
}
