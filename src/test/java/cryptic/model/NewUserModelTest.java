package cryptic.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class NewUserModelTest {

    private NewUserModel db;

    @Before
    public void setUp() throws Exception {
        db = new NewUserModel();
    }

    @After
    public void tearDown() throws Exception {
        //TODO: Write query to delete tables created during testing to avoid having to do so manually
    }

    @Test
    public void testAddUser() throws Exception {
        assertTrue("Add user", db.addUser("username", "password"));
        assertFalse("Duplicit user", db.addUser("username", "password"));
    }
}