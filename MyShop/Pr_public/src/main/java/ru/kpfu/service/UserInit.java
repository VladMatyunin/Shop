package ru.kpfu.service;

import ru.kpfu.entities.MyUser;

/**
 * Created by Vlad.M on 02.04.2016.
 */
public class UserInit {

    public MyUser setUserValues(String name, String surname, String checked, String age, String mail){
        MyUser user = new MyUser();
        user.setName(name);
        user.setSurname(surname);
        if (checked == "true"){
            user.setChecked(true);
        }
        else user.setChecked(false);
        if (age == null) user.setAge(null);
        else user.setAge(Integer.parseInt(age));
        user.setLogin(mail);

        user.setHashPassword("afd"); //!!!!!!!!!!
        return user;
    }

}
