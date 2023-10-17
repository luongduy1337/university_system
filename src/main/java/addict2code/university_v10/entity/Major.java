package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private int majorId;

    @Column(name = "major_name")
    private String majorName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "major")
    @JsonBackReference
    private List<Student> students;

    @Column(name = "is_delete")
    private int isDelete;

    @OneToMany(mappedBy = "major")
    @JsonManagedReference
    private List<Subjects> subjects;

    public Major(){};


    public Major(int majorId, String majorName, Department department, List<Student> students, int isDelete, List<Subjects> subjects) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.department = department;
        this.students = students;
        this.isDelete = isDelete;
        this.subjects = subjects;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", department=" + department +
                ", students=" + students +
                ", isDelete=" + isDelete +
                ", subjects=" + subjects +
                '}';
    }
}
