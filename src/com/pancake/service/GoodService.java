package com.pancake.service;

import java.util.List;

import com.pancake.entity.Good;
import com.pancake.entity.User;

public interface GoodService {
    List<Good> getAllGoodsByUser(User user);
    Good save(Good book);
    Good update(Good book);
    Good get(int id);
}
