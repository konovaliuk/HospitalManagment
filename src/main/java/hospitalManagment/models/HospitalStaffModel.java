package hospitalManagment.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "HospitalStaff")
@RequiredArgsConstructor
public class HospitalStaffModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String login;
    private String password;

    private String name;
    private Role role;

    public enum Role {
        DOCTOR, NURSE
    }
}
