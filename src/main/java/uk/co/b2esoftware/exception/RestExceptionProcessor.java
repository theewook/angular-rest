package uk.co.b2esoftware.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by TheEwook on 09/04/2014.
 */
@ControllerAdvice
public class RestExceptionProcessor extends ResponseEntityExceptionHandler
{
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestError taskNotFound(HttpServletRequest req, TaskNotFoundException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage("error.no.task.id", new Object [] {ex.getTaskId()}, locale);

        String errorURL = req.getRequestURL().toString();

        return new RestError(errorURL, errorMessage);
    }
}
