package hnuc.cn.test;

import hnuc.cn.dao.Authordao;
import hnuc.cn.entity.Author;
import hnuc.cn.service.Authorservice;

public class Authortext {
	
	public static void main(String[] args) {
		Authorservice as=new Authorservice();
		Author a=as.findDetail(4);
		System.out.println(a);
	}
}
