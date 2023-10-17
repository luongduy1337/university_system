package addict2code.university_v10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private int universityId;


    @OneToMany(mappedBy = "university")
    @JsonManagedReference
    private List<Subjects> subjects;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "unit_number")
    private Integer unitNumber;

    @Column(name = "street_number")
    private Integer streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "university_code")
    private String universityCode;

    @Column(name ="country")
    private String country;

    @Column(name = "is_delete")
    private int isDelete;

    // constructor without argument
    public University(){};

    // constructor with argument


    public University(int universityId, String universityName, Integer unitNumber, Integer streetNumber, String streetName, String suburb, String city, String state, String universityCode, String country, List<Subjects> subjects, List<Teacher> teachers, int isDelete) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.universityCode = universityCode;
        this.country = country;
        this.subjects = subjects;
        this.isDelete = isDelete;

    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
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

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }



    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", subjects=" + subjects +
                ", universityName='" + universityName + '\'' +
                ", unitNumber=" + unitNumber +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", universityCode='" + universityCode + '\'' +
                ", country='" + country + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
