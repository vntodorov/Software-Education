package bg.pathfinder.pathfinder.model;

import bg.pathfinder.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Level level;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String username, String password, String email, String fullName, int age) {
        this();

        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
