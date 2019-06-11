package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Book;
import top.dbon.blackandwhite.mapper.BookMapper;
import top.dbon.blackandwhite.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Integer insert(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public Integer deleteByBookId(String bookId) {
        return bookMapper.deleteByBookId(bookId);
    }

    @Override
    public Book selectByBookId(String bookId) {
        return bookMapper.selectByBookId(bookId);
    }

    @Override
    public Integer updateByBookId(Book book) {
        return bookMapper.updateByBookId(book);
    }
}
