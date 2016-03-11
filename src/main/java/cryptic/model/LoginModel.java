package cryptic.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the model (MVC) functionality of adding a new user.
 *
 * @author Nathan Mackenzie
 */
public class LoginModel extends SQLiteDatabase{

    private static final Logger LOGGER = Logger.getLogger(SQLiteDatabase.class.getName());

    /**
     * Gets id for the user which matches the entered username and password.
     * WARNING: Arguments should still be sanitized of possible SQL injections, despite use of prepared statements.
     *
     * @param userName defines username
     * @param password defines password
     * @return users ID or -1 if matching entry could not be found
     */
    public int login(String userName, String password) {
        int userID;
        Connection conn = sqliteConnection();

        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE userName = ? AND password = ?;");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if(rs.isBeforeFirst()){
                userID = rs.getInt("id");
            }else{
                userID = -1;
            }

            stmt.close();
            rs.close();
            conn.close();
        }catch (Exception e){
            userID = -1;
            LOGGER.log(Level.WARNING, "Something went wrong while executing the query!", e);
        }
        return userID;
    }
}
