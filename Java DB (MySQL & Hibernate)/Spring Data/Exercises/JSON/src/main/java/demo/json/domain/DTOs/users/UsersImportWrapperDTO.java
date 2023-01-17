package demo.json.domain.DTOs.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportWrapperDTO {

    @XmlElement(name = "user")
    private List<UserImportDTO> users;

}
