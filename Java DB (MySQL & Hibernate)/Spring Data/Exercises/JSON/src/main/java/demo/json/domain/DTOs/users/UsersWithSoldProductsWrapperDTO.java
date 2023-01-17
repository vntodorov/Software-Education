package demo.json.domain.DTOs.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsWrapperDTO {

    @XmlElement(name = "user")
    private List<UsersWithSoldProductsXmlWrapperDTO> users;

    public void ofListOfUsersWithSoldProductsDTO (List<UsersWithSoldProductsDTO> input){
        this.users = UsersWithSoldProductsDTO.toUsersWithSoldProductsDTO(input);
    }

}
