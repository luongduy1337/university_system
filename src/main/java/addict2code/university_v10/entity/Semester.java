package addict2code.university_v10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private int semesterId;
    @Column(name = "semester_name")
    private String semesterName;
    @Column(name = "semester_code")
    private String semesterCode;

    @Column(name = "is_delete")
    private int isDelete;

    // initialize constructor without argument
    public Semester(){};

    // initialize constructor with argument

    public Semester(int semesterId, String semesterName, String semesterCode, int isDelete) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.semesterCode = semesterCode;
        this.isDelete = isDelete;
    }


    // getters and setters

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }



    @Override
    public String toString() {
        return "Semester{" +
                "semesterId=" + semesterId +
                ", semesterName='" + semesterName + '\'' +
                ", semesterCode='" + semesterCode + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
