package all.model;

import javax.persistence.*;


@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private Long password;

    public User() {

    }

    public User(String name, String mail, String role, Long password) {
        this.name = name;
        this.mail = mail;
        this.role = role;
        this.password = password;
    }

    public User(Long id, String name, String mail, String role, Long password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.role = role;
        this.password = password;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

}
