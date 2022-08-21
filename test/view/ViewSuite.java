/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Hasnayen
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({view.View_orderStatusTest.class, view.DeleteItemTest.class, view.UpdateStatusTest.class, view.User_loginTest.class, view.User_pannelTest.class, view.AddNewItemTest.class, view.Opening_pageTest.class, view.Admin_LoginTest.class, view.User_SignUpTest.class, view.User_SignInTest.class, view.Admin_PannelTest.class})
public class ViewSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
