package cryptic.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Nathan Mackenzie
 */
public class AddAccountModelTest {

    AddAccountModel acctModel;
    SQLiteDatabase db;

    @Before
    public void setUp() throws Exception {
        acctModel = new AddAccountModel();
        db = new SQLiteDatabase();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        acctModel.add(1, "This", "is", "just", "a", "test");
    }
}