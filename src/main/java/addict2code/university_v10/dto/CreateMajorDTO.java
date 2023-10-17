package addict2code.university_v10.dto;

import addict2code.university_v10.entity.Department;

public class CreateMajorDTO {
    private String majorName;

    private int departmentId;
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "CreateMajorDTO{" +
                "majorName='" + majorName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
