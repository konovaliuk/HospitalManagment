package hospitalManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class AuthStaffDTO {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

}
