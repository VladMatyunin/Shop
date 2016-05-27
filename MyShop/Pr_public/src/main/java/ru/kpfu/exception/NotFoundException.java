package ru.kpfu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,  reason = "Object Not Found")
public class NotFoundException extends RuntimeException {
}
