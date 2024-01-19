package com.generation.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.generation.model.entities.User;

public class UserRepoMock 
{
    private static List<User> users = new ArrayList<User>();
    static
    {
        users.add(new User(1, "Step", "calice"));
        users.add(new User(2, "Gast", "difuoco"));
    }


    public User login(String username,String password)
    {
        User res = null;
        //Cercare utente per username
        for(User u:users)
            if(u.getUsername().equals(username))
                res=u;

        if(res==null)
            return null;

        if(res.getPassword().equals(password))
            return res;
        else
            return null;
    }
}
