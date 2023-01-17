package demo.json.domain.DTOs.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithProductWrapperDTO {

    @XmlAttribute(name = "count")
    private int usersCount;

    @XmlElement(name = "user")
    private List<UserWithProductsDTO> users;

    public UsersWithProductWrapperDTO(List<UserWithProductsDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }


}
