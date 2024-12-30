package services;

import java.util.List;

import Dto.UserDto;
import models.User;

public interface UserService {

    User save (UserDto userDto);
    List<User> getallUsers();
}
