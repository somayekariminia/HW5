package tamrin_hw5.jdbc;

import java.sql.Date;

public class Article {
    private int id;
    private String title;
    private String breif;
    private String content;
    private Date creatDate;
    private int user_id;
    private boolean isPublish;

    public Article(int id, String title, String breif, String content, Date creatDate, boolean isPublish, int user_id) {
        this.id = id;
        this.title = title;
        this.breif = breif;
        this.content = content;
        this.creatDate = creatDate;
        this.user_id = user_id;
        this.user_id = user_id;
        this.isPublish = isPublish;
    }

    public Article() {
    }
//    public boolean isPublished() {
//        return isPublished;
//    }

    public int getUse_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBreif() {
        return breif;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public int getUser_id() {
        return user_id;
    }

    public Article(String breif, String content) {
        this.breif = breif;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", breif='" + breif + '\'' +
                ", content='" + content + '\'' +
                ", creatDate=" + creatDate +
                ", isPublished=" + isPublish +
                ", user_id=" + user_id +
                '}';
    }

    public String toString1() {
        return "Article{" +
                ", breif='" + breif + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public boolean isPublished() {
        return isPublish;
    }

}
