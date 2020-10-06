package domains;

import base.domians.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "user")
public class Employee extends BaseEntity<Long> {
    public Employee(String firstName, String lastName, long nationalCode, LocalDate birthday, String password) {
        super(nationalCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private long nationalCode;
    @Column
    private LocalDate birthday;
    @Column
    private  String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_role")
    private Role role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
/* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column
    private String userName;
    @Column(unique = true)
    private long nationalCode;
    @Column
    private LocalDate birthday;
    @Column
    private  String password;
    @ManyToMany()
    private List<Article> articles = new ArrayList<>();


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
        this.password = String.valueOf(nationalCode);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }*/
}
