package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "semester_student")
public class SemesterStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_student_id")
    private int semesterStudentId;

    @Column(name = "semester_id")
    private int semesterId;


    @Column(name = "student_id")
    private int studentId;

    @Column(name = "is_delete")
    private int isDelete;



    // initialize constructor without argument

    public SemesterStudent(){};

    // initialize constructor with argument

    public SemesterStudent(int semesterStudentId, int semesterId, int studentId, int isDelete) {
        this.semesterStudentId = semesterStudentId;
        this.semesterId = semesterId;
        this.studentId = studentId;
        this.isDelete = isDelete;
    }


    // getters and setters

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSemesterStudentId() {
        return semesterStudentId;
    }

    public void setSemesterStudentId(int semesterStudentId) {
        this.semesterStudentId = semesterStudentId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "SemesterStudent{" +
                "semesterStudentId=" + semesterStudentId +
                ", semesterId=" + semesterId +
                ", studentId=" + studentId +
                ", isDelete=" + isDelete +
                '}';
    }
}
