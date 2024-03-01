package LMS.dao;

import LMS.model.User;

public interface UserDaoInterface {
    public boolean addUser(User user);
    public boolean loginUser(String username, String password);
}
