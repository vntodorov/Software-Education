package bg.mobilele.model.mapper;

import bg.mobilele.model.dto.UserRegisterDTO;
import bg.mobilele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = " active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);
}
