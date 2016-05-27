package ru.kpfu.entities;

import javax.persistence.*;

/**
 * Created by Vlad.M on 31.03.2016.
 */
@Entity
@Table(name = "users")
public class MyUser {

    /**
     * Auto-increment parametr, primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * Variables from form, need to write them all
     */
    @Column (name = "username")
    private String username;
    @Column (name = "surname")
    private String surname;

    @Column (name = "mail")
    private String mail;
    @Column (name = "hashpassword")
    private String hashPassword;
    @Column (name = "userrole")
    private String role;


    /**
     * Nullable variables
     */
    @Column( name = "age")
        private Integer age;
    @Column (name =  "avatar")
        private String avatar;

    @Column (name = "checked")
    private Boolean checked;

        public MyUser() {
        }
    /*public MyUser(String name, String surname, int age, String login, boolean check){
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.check = check;
        this.hashPassword = "asda";
        this.avatar = "";
        this.role = "ROLE_USER";

    }*/


        public String getLogin() {
            return mail;
        }

        public void setLogin(String login) {
            this.mail = login;
        }

        public String getHashPassword() {
            return hashPassword;
        }

        public void setHashPassword(String hashPassword) {
            this.hashPassword = hashPassword;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}

