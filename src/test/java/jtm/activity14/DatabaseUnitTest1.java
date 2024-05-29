package jtm.activity14;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.mockito.Mockito.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseUnitTest1 {
    
    static StudentManager manager;
    static int id1;
    static Student test1, test2;
    static StudentManager mockedManager;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        manager = new StudentManager();
        mockedManager = mock(StudentManager.class);
        id1 = 10;
        test1 = new Student(10, "Name10", "Surname10");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
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
    public void test10NegativeTest() {
        Student test1 = new Student();
        mockedManager = mock(StudentManager.class);
        doThrow(new RuntimeException()).when(mockedManager).insertStudent(any(Student.class));
        try {
            mockedManager.insertStudent(test1);
            Assert.fail();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
