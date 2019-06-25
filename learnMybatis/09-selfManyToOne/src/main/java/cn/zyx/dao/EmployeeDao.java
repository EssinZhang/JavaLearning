package cn.zyx.dao;

import cn.zyx.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee selectLeaderByPid (int id);
}
