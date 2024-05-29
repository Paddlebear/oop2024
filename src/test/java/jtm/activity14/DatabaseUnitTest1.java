package jtm.activity14;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import ch.qos.logback.classic.db.SQLBuilder;

import static org.mockito.Mockito.*;
import static jtm.activity14.StudentManager.user;
import static jtm.activity14.StudentManager.password;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseUnitTest1 {

    static StudentManager manager;
    static int id1;
    static Student test1, test2;
    static StudentManager mockedManager;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        id1 = 10;
        test1 = new Student(10, "Name10", "Surname10");
    }

    @Before
    public static void setUpBefore() throws Exception {
        manager = new StudentManager();
        mockedManager = mock(StudentManager.class);
        id1 = 10;
        test1 = new Student(10, "Name10", "Surname10");
    }

    @After
    public static void tearDownAfter() throws Exception {
        manager.closeConnecion();
    }

    @Test
    public void test00ChangeStudent() {
        test2 = new Student(0, "Name0", "Surname0");
        test2.setFirstName("Name20");
        test2.setLastName("Surname20");
        test2.setId(20);
        assertEquals(test2.getId(), 20);
        assertEquals(test2.toString(), "Name20 Surname20");
    }

    @Test
    public void test01InsertStudentStringString() {
        manager.insertStudent("Name", "Surname");
        List<Student> students = manager.findStudent("Name", "Surname");
        assertTrue(students.toString().contains("Name Surname"));
    }

    @Test
    public void test02InsertStudentStudent() {
        manager.insertStudent(test1);
        Student students = manager.findStudent(id1);
        assertTrue(students.toString().contains("Name10 Surname10"));
    }

    @Test
    public void test03FindStudentInt() {
        manager.findStudent(id1);
        Student students = manager.findStudent(id1);
        assertTrue(students.toString().contains("Name10 Surname10"));
    }

    @Test
    public void test04FindStudentStringString() {
        manager.findStudent("Name", "Surname");
    }

    @Test
    public void test05UpdateStudent() {
        test2 = new Student(20, "Name20", "Surname20");
        manager.updateStudent(test2);
    }

    @Test
    public void test06DeleteStudent() {
        manager.deleteStudent(id1);
        Student students = manager.findStudent(id1);
        assertTrue(students.toString().contains("null null"));
    }

    @Test
    public void test10Failures() {
        try {
            Connection mockedConn = Mockito.spy(DriverManager.getConnection("jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8", user, password));
            doThrow(new SQLException("Commit exception")).when(mockedConn).commit();
            doThrow(new SQLException("Prepare statement exception")).when(mockedConn).prepareStatement(Mockito.anyString());
            doThrow(new SQLException("Change autocommit exception")).when(mockedConn).setAutoCommit(false);
            doThrow(new SQLException("Close exception")).when(mockedConn).close();
            manager.conn = mockedConn;
            try {
                manager.insertStudent("", "");
                manager.insertStudent(new Student(0, "", ""));
                manager.findStudent(0);
                manager.findStudent("", "");
                manager.updateStudent(new Student(0, "", ""));
                manager.deleteStudent(0);
                manager.closeConnecion();
            } catch (Exception e) {
                System.err.println("Test10 expected failure:" + Arrays.asList(e.getStackTrace()));
            }
        } catch (Exception e) {
            Assert.fail("Test10 unexpected failure:" + Arrays.asList(e.getStackTrace()));
        }
    }

}
