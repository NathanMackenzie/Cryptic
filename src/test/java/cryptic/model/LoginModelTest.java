package cryptic.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LoginModelTest {

    private LoginModel db;

    @Before
    public void setUp() throws Exception {
        db = new LoginModel();
    }

    @After
    public void tearDown() throws Exception {
        //TODO: Write query to delete tables created during testing to avoid having to do so manually
    }

    @Test
    public void testLogin() throws Exception {

    }
}