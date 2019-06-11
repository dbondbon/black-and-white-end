package top.dbon.blackandwhite;

import org.springframework.beans.factory.annotation.Autowired;
import top.dbon.blackandwhite.domain.Book;
import top.dbon.blackandwhite.service.BookService;
import top.dbon.blackandwhite.util.UUIDUtils;

/**
 * 测试
 */
public class Test {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("钱钟书");
        book.setAuthor("凤凰出版社");
        book.setBookId(UUIDUtils.getInstance().nextId());
        bookService.insert(book);
    }

}
