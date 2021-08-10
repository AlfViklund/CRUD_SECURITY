package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public void add(User user) { userDao.add(user); }

    @Override
    public void delete(User user) { userDao.delete(user); }

    @Override
    public List<User> listUsers() { return userDao.listUsers(); }

    @Override
    public User getUserById(long id) { return userDao.getUserById(id); }

    @Override
    public void update(User user) { userDao.update(user); }
}
