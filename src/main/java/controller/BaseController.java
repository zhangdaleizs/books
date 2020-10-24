package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.IBooksService;
import service.IBorrowService;
import service.IMainClassService;
import service.IUserService;

import java.util.Scanner;

@Component
public class BaseController
{
    @Autowired
    protected IUserService          userService         ;
    @Autowired
    protected IBorrowService        borrowService       ;
    @Autowired
    protected IBooksService         booksService        ;
    @Autowired
    protected IMainClassService     mainClassService    ;

    protected Scanner scanner = new Scanner(System.in)  ;

    protected void print    (String str)
    {
        System.out.print    (str);
    }
    protected void println  (String str)
    {
        System.out.println  (str);
    }
}
