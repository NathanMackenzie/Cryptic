package cryptic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the model (MVC) functionality of add account window.
 *
 * @author Nathan Mackenzie
 */
public class AddAccountModel extends SQLiteDatabase{

    private static Logger LOGGER = Logger.getLogger(WindowModel.class.getName());

    /**
     * This method adds a new account to the 'accounts' database table.
     *
     * @param userID current users ID
     * @param name accounts name
     * @param website accounts website
     * @param username accounts username
     * @param password accounts password
     * @param category sections which the account belongs to
     */
    public void add(int userID, String name, String website, String username, String password, String category){

        Connection conn = sqliteConnection();

        try {
            LOGGER.info("Creating accounts table");
            // Create an accounts table if it doesn't already exist
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS accounts(id INTEGER NOT NULL, " +
                    "name TEXT NOT NULL, website TEXT, username TEXT, password TEXT, category TEXT NOT NULL);");

            LOGGER.info("Adding a new account to the database...");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO accounts(id, name, website, username, password, category)" +
                    " VALUES (?, ?, ?, ?, ?, ?);");

            stmt.setString(1, String.valueOf(userID));
            stmt.setString(2, name);
            stmt.setString(3, website);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, category);

            stmt.executeUpdate();
            stmt.close();

            conn.close();
        }catch (Exception e){
            LOGGER.log(Level.WARNING, "Something went wrong while executing the query!", e);
        }
    }
}
