package hospitalManagment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StaffDTO {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String role;
}
