package top.dbon.blackandwhite.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.dbon.blackandwhite.domain.Book;
import top.dbon.blackandwhite.service.BookService;
import top.dbon.blackandwhite.util.UUIDUtils;


public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private Book book = null;

    @Before
    public void init() {
        book.setBookId(UUIDUtils.getInstance().nextId());
        book.setAuthor("钱钟书");
        book.setPublisher("凤凰出版社");
    }

    @Test
    public void insert() {
        bookService.insert(book);
    }

    @Test
    public void deleteByBookId() {
        bookService.deleteByBookId(book.getBookId());
    }

    @Test
    public void selectByBookId() {
        Book book1 = bookService.selectByBookId(book.getBookId());
        System.out.println(book1);
    }

    @Test
    public void updateByBookId() {
        book.setAuthor("杨绛");
        bookService.updateByBookId(book);
    }
}