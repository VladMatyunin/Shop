package ru.kpfu.form;


import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.entities.MyUser;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Gataullin Kamil
 * 13.03.2016 0:10
 */
public class RegForm {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String username;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String surname;


    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String mail;

    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    private String phone;

    //@Size(min = 1, max = 2, message = "Возраст не верно введен")
    private Integer age;
    @Size(min = 2, max = 20, message = "Введите корректный город")
    private String city;
    @AssertTrue(message = "Примите условия договора")
    private Boolean checked;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String password;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String confirmpass;

    public RegForm() {
    }
    public MyUser makeUser(){
        MyUser user = new MyUser();
        user.setLogin(this.getMail());
        user.setAge(this.getAge());
        user.setHashPassword(this.getPassword());
        user.setChecked(this.getChecked());
        user.setName(this.getUsername());
        user.setSurname(this.getSurname());
        user.setRole("ROLE_USER");
        return user;
    }
    public RegForm(String firstName, String lastName, String email, String phone, Boolean signIn, String password, String confirmPassword, String city, Integer age) {
        this.username = firstName;
        this.surname = lastName;
        this.mail = email;
        this.phone = phone;
        this.checked = signIn;
        this.city = city;
        this.password = password;
        this.confirmpass = confirmPassword;
        this.age = age;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
