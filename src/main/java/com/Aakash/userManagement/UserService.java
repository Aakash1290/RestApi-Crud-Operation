package com.Aakash.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public List<User> getUserList() {
        return repo.findAll();
    }

    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public List<User> createUserList(List<User> users) {
        return repo.saveAll(users);
    }
    public User deleteUser(int id) {

        Optional<User> user = repo.findById(id);

        if (user.isPresent()) {
            repo.deleteById(id);
            return user.get();
        } else {

            return null;
        }
    }


    public User updateUser(User user) {
        Optional<User> userfound = repo.findById(user.getId());
        if(userfound.isPresent()){
            User userupdate = userfound.get();

            userupdate.setFname(user.getFname());
            userupdate.setLname(user.getLname());
            userupdate.setAge(user.getAge());
            return repo.save(user);
        }
        return null;
    }


}