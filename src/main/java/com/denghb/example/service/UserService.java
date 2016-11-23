package com.denghb.example.service;

import com.denghb.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppd on 16/11/23.
 */
public interface UserService {


    User queryByName(String name);
}
