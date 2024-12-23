package model;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Select("SELECT * FROM books")
    List<Book> getAllBooks();

    @Insert("INSERT INTO books (title, author, genre, year) VALUES (#{title}, #{author}, #{genre}, #{year})")
    void insertBook(Book book);

    @Update("UPDATE books SET title=#{title}, author=#{author}, genre=#{genre}, year=#{year} WHERE id=#{id}")
    void updateBook(Book book);

    @Delete("DELETE FROM books WHERE id=#{id}")
    void deleteBook(int id);
}
