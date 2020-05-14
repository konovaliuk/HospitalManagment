package jdbc.model.dao;

import jdbc.model.entities.Staff;

import java.util.Optional;

public interface StaffDao extends GenericDao<Staff> {
	Optional<Staff> getStaffByEmail(String email);
}
