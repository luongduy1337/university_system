package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;


    @Column(name ="country")
    private String country;

    @Column(name = "is_delete")
    private int isDelete;

    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<SubjectEnrollment> subjectEnrollments;


    // constructor without argument

    @ManyToOne
    @JoinColumn(name = "major_id")
    @JsonBackReference
    private Major major;


    public Student(){};

    // constructor with argument


    public Student(int studentId, String firstName, String lastName, Date dateOfBirth, String streetNumber, String streetName, String suburb, String city, String state, String country, int isDelete, List<SubjectEnrollment> subjectEnrollments, List<Subjects> subjects, Major major, SemesterStudent semesterStudent) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.country = country;
        this.isDelete = isDelete;
        this.subjectEnrollments = subjectEnrollments;
//        this.subjects = subjects;
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<SubjectEnrollment> getSubjectEnrollments() {
        return subjectEnrollments;
    }

    public void setSubjectEnrollments(List<SubjectEnrollment> subjectEnrollments) {
        this.subjectEnrollments = subjectEnrollments;
    }

//    public List<Subjects> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(List<Subjects> subjects) {
//        this.subjects = subjects;
//    }


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", isDelete=" + isDelete +
                ", subjectEnrollments=" + subjectEnrollments +
                ", major=" + major +
                '}';
    }
}
