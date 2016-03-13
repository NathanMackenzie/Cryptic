package cryptic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddAccountModel extends SQLiteDatabase{

    private static Logger LOGGER = Logger.getLogger(WindowModel.class.getName());

    public void addEmail(int userID, String website, String userName, String password){

        Connection conn = sqliteConnection();

        try {
            LOGGER.info("Creating table");
            // Create a Email table if it doesn't already exist
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS email(id INTEGER NOT NULL, " +
                    "website TEXT NOT NULL, userName TEXT NOT NULL, password TEXT NOT NULL);");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO email(id, website, userName, password)" +
                    " VALUES (?, ?, ?, ?);");

            stmt.setString(1, String.valueOf(userID));
            stmt.setString(2, website);
            stmt.setString(3, userName);
            stmt.setString(4, password);

            stmt.executeUpdate();
            stmt.close();

            conn.close();
        }catch (Exception e){
            LOGGER.log(Level.WARNING, "Something went wrong while executing the query!", e);
        }
    }
}
