package bg.battle.service;

import bg.battle.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final CurrentUser currentUser;

    @Autowired
    public AuthService(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


    public boolean isLoggedIn() {
        return currentUser.getId() > 0;
    }

    public long getCurrentUserId() {
        return currentUser.getId();
    }
}
