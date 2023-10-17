package addict2code.university_v10.dto;

public class CreateDepartmentDTO {
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "CreateDepartmentDTO{" +
                ", departmentName=" + departmentName +
                '}';
    }
}
