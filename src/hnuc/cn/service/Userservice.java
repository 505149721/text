package hnuc.cn.service;

import hnuc.cn.entity.User;

public interface Userservice {
	User findUserByLogin(User u);
}
