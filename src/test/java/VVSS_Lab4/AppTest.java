package VVSS_Lab4;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
import Service.ServiceStudent;

import Domain.Teme;
import Repository.TemeRepo;
import Validator.TemeValidator;
import Service.ServiceTeme;

import Domain.Nota;
import Repository.NoteRepo;
import Validator.NotaValidator;
import Service.ServiceNote;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private ServiceStudent studentServ;
    private ServiceNote noteServ;
    private ServiceTeme temeServ;

    @Before
    public void setUp() {
        studentServ = new ServiceStudent(new StudentRepo(new StudentValidator(), "testStud.xml"));
        noteServ = new ServiceNote(new NoteRepo(new NoteValidator()));
        temeServ = new ServiceTeme(new TemeRepo(new TemeValidator(), "testTeme.xml"));
    }

    public void testAddStudent() {
        Student stud = new Student("1234", "testName", 937, "email@email.com", "testTeacher");
        assertNotNull(studentServ.add(stud));
    }

    public void testAddAssignment() {
        Teme assignment = new Teme(1, "desc", 3, 5);
        assertNotNull(temeServ.add(assignment));
    }

    public void testAddGrade() {
        Student stud = new Student("1234", "testName", 937, "email@email.com", "testTeacher");
        Teme assignment = new Teme(1, "desc", 3, 5);

        Nota grade = new Nota(new AbstractMap.SimpleEntry<String, Integer>("1234", 1), stud, assignment, 10, 4);
    }
}
