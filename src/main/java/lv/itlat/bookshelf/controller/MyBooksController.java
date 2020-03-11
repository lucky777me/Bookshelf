package lv.itlat.bookshelf.controller;

import lv.itlat.bookshelf.persistence.domain.Book;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class MyBooksController {
    Logger logger= Logger.getLogger(MyBooksController.class);
    @Inject
    private Book book=new Book();



}
