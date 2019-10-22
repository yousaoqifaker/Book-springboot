package com.qin.community.mapper;

import com.qin.community.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Qin
 */
@Mapper
@Service
public interface BookMapper {
    @Select("SELECT * FROM book")
    ArrayList<Book> getBook();

    /**
     * 
     * @return
     */
    @Select("select count(*) from book")
    int getBookCount();
    @Insert(" insert into book(isbn, name, zuo, chu, jia, ce) VALUES (#{isbn},#{name},#{zuo},#{chu},#{jia},#{ce})")
    void addBook(Book book);
    @Delete("delete from book where id=#{id}")
    void deleteBook(int id);
    @Select("select * from book where book.id = #{id}")
    Book findBookById(int id);

    @Update("update book set isbn=#{isbn},name=#{name},zuo=#{zuo},chu=#{chu},jia=#{jia},ce=#{ce} where id=#{id}")
    void updateBook(Book book);
}
