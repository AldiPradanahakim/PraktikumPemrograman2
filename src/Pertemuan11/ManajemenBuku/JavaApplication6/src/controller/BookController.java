package controller;

import model.Book;
import model.BookMapper;
import org.apache.ibatis.session.SqlSession;
import view.BookView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookController {
    private final BookView view;
    private final SqlSession sqlSession;
    private final BookMapper bookMapper;

    public BookController(BookView view, SqlSession sqlSession) {
        this.view = view;
        this.sqlSession = sqlSession;
        this.bookMapper = sqlSession.getMapper(BookMapper.class);

        loadTable();
        view.btnAdd.addActionListener(new AddListener());
        view.btnUpdate.addActionListener(new UpdateListener());
        view.btnDelete.addActionListener(new DeleteListener());
        view.btnClear.addActionListener(e -> clearInputFields());
    }

    private void loadTable() {
        List<Book> books = bookMapper.getAllBooks();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Genre", "Year"}, 0);
        for (Book book : books) {
            model.addRow(new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getYear()});
        }
        view.table.setModel(model);
    }

    private void clearInputFields() {
        view.txtId.setText("");
        view.txtTitle.setText("");
        view.txtAuthor.setText("");
        view.txtGenre.setText("");
        view.txtYear.setText("");
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = new Book();
            book.setTitle(view.txtTitle.getText());
            book.setAuthor(view.txtAuthor.getText());
            book.setGenre(view.txtGenre.getText());
            book.setYear(Integer.parseInt(view.txtYear.getText()));
            bookMapper.insertBook(book);
            sqlSession.commit();
            loadTable();
        }
    }

    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = new Book();
            book.setId(Integer.parseInt(view.txtId.getText()));
            book.setTitle(view.txtTitle.getText());
            book.setAuthor(view.txtAuthor.getText());
            book.setGenre(view.txtGenre.getText());
            book.setYear(Integer.parseInt(view.txtYear.getText()));
            bookMapper.updateBook(book);
            sqlSession.commit();
            loadTable();
        }
    }

    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.txtId.getText());
            bookMapper.deleteBook(id);
            sqlSession.commit();
            loadTable();
        }
    }
}
