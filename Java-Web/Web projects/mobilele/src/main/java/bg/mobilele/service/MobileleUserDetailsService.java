package bg.mobilele.service;

import bg.mobilele.model.entity.UserEntity;
import bg.mobilele.model.entity.UserRoleEntity;
import bg.mobilele.model.user.MobileleUserDetails;
import bg.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MobileleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " doesn't exist!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new MobileleUserDetails(
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity
                        .getUserRoles()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(UserRoleEntity userRole){
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
