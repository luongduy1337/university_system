package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "subject_name")
    private String subjectName;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonBackReference
    private University university;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "major_id")
    @JsonBackReference
    private Major major;

    @OneToMany(mappedBy = "subjects")
    @JsonManagedReference
    private List<SubjectEnrollment> subjectEnrollments;

    // constructor without argument
    public Subjects(){};

    // constructor with argument


    public Subjects(int subjectId, String subjectName, Teacher teacher, University university, Category category, Major major, List<SubjectEnrollment> subjectEnrollments) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.university = university;
        this.category = category;
        this.major = major;
        this.subjectEnrollments = subjectEnrollments;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Major getSubjects() {
        return major;
    }

    public void setSubjects(Major major) {
        this.major = major;
    }


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<SubjectEnrollment> getSubjectEnrollments() {
        return subjectEnrollments;
    }

    public void setSubjectEnrollments(List<SubjectEnrollment> subjectEnrollments) {
        this.subjectEnrollments = subjectEnrollments;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teacher=" + teacher +
                ", university=" + university +
                ", category=" + category +
                ", major=" + major +
                ", subjectEnrollments=" + subjectEnrollments +
                '}';
    }
}
