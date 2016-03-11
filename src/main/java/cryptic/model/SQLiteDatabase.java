package cryptic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains general model (MVC) functionality.
 *
 * @author Nathan Mackenzie
 */
public class SQLiteDatabase {

    private static final Logger LOGGER = Logger.getLogger(SQLiteDatabase.class.getName());

        /**
         * Forms a connection with the SQLite database.
         * WARNING: Connection should be closed following use.
         *
         * @return Database connection
         */
        public static Connection sqliteConnection(){
            Connection c = null;
            try{
                LOGGER.info("Establishing database connection...");
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:database.db");
            }catch (Exception e){
                LOGGER.log(Level.SEVERE, "Unable to connect to database!", e);
                System.exit(0);
            }
            return c;
        }
    }
