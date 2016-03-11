package cryptic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the model (MVC) functionality of for logging in.
 *
 * @author Nathan Mackenzie
 */
public class NewUserModel extends LoginModel{

    private static final Logger LOGGER = Logger.getLogger(SQLiteDatabase.class.getName());

    /**
     * Adds a new users information to the 'users' table within the database.
     * WARNING: Arguments should still be sanitized of possible SQL injections, despite use of prepared statements.
     *
     * @return true for successful database entry
     */
    public boolean addUser(String userName, String password){
        boolean success;
        Connection conn = sqliteConnection();

        try {
            // Create a user table if it doesn't already exist
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY NOT NULL," +
                    " userName TEXT UNIQUE NOT NULL, password TEXT NOT NULL);");

            // Check if username is already in use
            PreparedStatement stmt = conn.prepareStatement("SELECT userName FROM users WHERE userName = ?;");
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if(rs.isBeforeFirst()){
                success = false;
                stmt.close();
                rs.close();
            }else{
                // Add the user to database
                success = true;
                stmt.close();
                rs.close();

                PreparedStatement add = conn.prepareStatement("INSERT INTO users (username, password) values (?, ?)");
                add.setString(1, userName);
                add.setString(2, password);
                add.executeUpdate();
                add.close();
            }

            conn.close();
        }catch (Exception e){
            success = false;
            LOGGER.log(Level.WARNING, "Something went wrong while executing the query!", e);
        }

        return success;
    }
}
