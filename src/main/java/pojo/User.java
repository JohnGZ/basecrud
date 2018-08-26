package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class User {
    @Id
    @GenericGenerator(strategy="uuid",name="uuid")
    @GeneratedValue(generator="uuid")
    private String id;

    @Column
    private String name;
    @Column
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date birth;
    @Column
    private String picture;
    @Column
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String name, String password, Date birth, String picture, String sex) {
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.picture = picture;
        this.sex = sex;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                ", picture='" + picture + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
