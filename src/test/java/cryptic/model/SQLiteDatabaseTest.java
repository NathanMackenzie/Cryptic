package cryptic.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SQLiteDatabaseTest {

    private SQLiteDatabase db;

    @Before
    public void setUp() throws Exception {
        db = new SQLiteDatabase();
    }

    @Test
    public void testSqliteConnection() throws Exception {

    }
}