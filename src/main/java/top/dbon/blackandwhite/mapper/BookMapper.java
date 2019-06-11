package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Book;

/**
 * 数据层
 *
 */
public interface BookMapper {
    /**
     * 插入数据
     * @param book
     * @return
     */
    Integer insertBook(Book book);

    /**
     * 删除信息
     * @param bookId
     * @return
     */
    Integer deleteByBookId(String bookId);

    /**
     * 查找信息
     * @param bookId
     * @return
     */
    Book selectByBookId(String bookId);

    /**
     * 更新信息
     * @param book
     * @return
     */
    Integer updateByBookId(Book book);

}