package tamrin_hw5.work;

import tamrin_hw5.jdbc.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkArticle {
    private Article article;

    public void creatTableArticle() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        String test = "create table article (id int primary key,  title varchar(250), brief varchar(250),content varchar(250),creatData DATE, user_id int not null , isPublish boolean)";
        PreparedStatement preparedStatement = connection.prepareStatement(test);
        preparedStatement.executeUpdate();

    }

    public void insertTable(Article article) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into article values(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, article.getId());
        preparedStatement.setString(2, article.getTitle());
        preparedStatement.setString(3, article.getBreif());
        preparedStatement.setString(4, article.getContent());
        preparedStatement.setDate(5, article.getCreatDate());
        preparedStatement.setInt(6, article.getUse_id());
        preparedStatement.setBoolean(7, article.isPublished());
        preparedStatement.executeUpdate();
    }

    //
    public void editeArticle(Article article) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article " +
                " set title=?,brief=?,content=?,isPublish=?" +
                "where id= ?");
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getBreif());
        preparedStatement.setString(3, article.getContent());
        preparedStatement.setBoolean(4, article.isPublished());
        preparedStatement.setInt(5, article.getId());
        preparedStatement.executeUpdate();
    }

    //
    public List<Article> view() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");

        List<Article> articleList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from public.article where isPublish=?");
        statement.setBoolean(1,true);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Article article = new Article(resultSet.getString("content"),
                    resultSet.getString("brief"));
            articleList.add(article);
        }
        return articleList;
    }

    public List<Article> completView(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement statement = connection.prepareStatement("select * from public.article where user_id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        List<Article> list = new ArrayList<>();
        while (resultSet.next()) {
            Article article = new Article(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getBoolean(7),
                    resultSet.getInt(6));
            list.add(article);
        }
        return list;
    }
}


