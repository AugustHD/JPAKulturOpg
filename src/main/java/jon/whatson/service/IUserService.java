package jon.whatson.service;

import jon.whatson.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long> {
    List<User> findByName(String string);
}
