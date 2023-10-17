package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "subject_enrollment")
public class SubjectEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonManagedReference
    private Subjects subjects;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonManagedReference
    private Student student;


    // initialize constructor without argument
    public SubjectEnrollment(){};

    // initialize constructor with argument

    public SubjectEnrollment(int id, Subjects subjects, Student student) {
        this.id = id;
        this.subjects = subjects;
        this.student = student;
    }


    // getters and sellers


    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // toString()


    @Override
    public String toString() {
        return "SubjectEnrollment{" +
                "id=" + id +
                ", subjects=" + subjects +
                ", student=" + student +
                '}';
    }
}



