package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Book {
    private static int id;
    private static String bookName;
    private static String authorName;
    private static String language;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public static void Database() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "");
            if (connection != null) {
                System.out.println("Connected");

                String insertQuery = "INSERT INTO task1 (id,bookName, authorName,language) VALUES (?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, bookName);
                preparedStatement.setString(3, authorName);
                preparedStatement.setString(4, language);

                int rowsAffected = preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();

        }
    }
}
