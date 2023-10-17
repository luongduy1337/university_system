package addict2code.university_v10.dto;

public class UpdateMajorDTO {
    private int majorId;

    private String majorName;

    private int departmentId;

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


    @Override
    public String toString() {
        return "UpdateMajorDTO{" +
                "majorId=" + majorId +
                ", majorName=" + majorName +
                ", departmentId=" + departmentId +
                '}';
    }
}
