package cn.zyx.dao;

import cn.zyx.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> selectUnderlingByMgr(int mgr);
    List<Employee> selectUnderlingById(int id);
}
