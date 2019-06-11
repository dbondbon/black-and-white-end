package top.dbon.blackandwhite.domain;

import lombok.Data;

/**
 * 表 book
 */
@Data
public class Book {
    private static final long serialVersionUID = 1L;

    /** 图书ID */
    private String bookId;
    /** 出版社 */
    private String publisher;
    /** 作者 */
    private String author;

}