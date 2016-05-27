package ru.kpfu.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vlad.M on 05.04.2016.
 */
public class TestForm {
    @NotNull(message = "OMG!!!")
    @Size (min = 6, message = "sdafgha")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public TestForm(){

    }
}
