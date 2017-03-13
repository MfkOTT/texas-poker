package com.taikang.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.taikang.exercise.dao.RoleDao;
import com.taikang.exercise.dto.Role;

/**
 * @author maoyl05
 * 
 */
@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public List<Role> findRole(String name) {
		// 分页查询
		PageHelper.startPage(3, 4, "id asc");
		return roleDao.findRole(name);
	}
	
	
	/**
	 * 测试事务
	 * @param role
	 * @throws Exception
	 */
	public void saveData(Role role) throws Exception {
		try {
			if (role.getId() == null) {
				role.setId(15);
				roleDao.insertRole(role);
			} else {
				roleDao.updateRole(role);
			}
//			int i = 1 / 0;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Role findData(int id) {
		return roleDao.findRoleById(id);
	}
}
