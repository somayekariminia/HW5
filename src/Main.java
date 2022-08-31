import tamrin_hw5.jdbc.Article;
import tamrin_hw5.work.WorkArticle;
import tamrin_hw5.work.menu.Menue;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorkArticle workArticle = new WorkArticle();
        workArticle.creatTableArticle();
        Menue menue = new Menue();
        menue.runMenue();
    }
}
