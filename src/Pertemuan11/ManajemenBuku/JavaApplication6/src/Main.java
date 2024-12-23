import controller.BookController;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import view.BookView;

import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            BookView view = new BookView();
            new BookController(view, sqlSession);
            view.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
