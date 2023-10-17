package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateMajorDTO;
import addict2code.university_v10.dto.UpdateMajorDTO;
import addict2code.university_v10.entity.Major;

import java.util.List;

public interface MajorDAO {
    List<Major> findAll();

    Major findOne(int majorId);

    void add(CreateMajorDTO createMajorDTO);

    void update(UpdateMajorDTO updateMajorDTO);

    void delete(int majorId);
}
