package cn.zyx.dao;

import cn.zyx.bean.Student;

import java.util.List;

public interface StudentDao {
    void insertStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(Student student);

    List<Student> selectAllStudent();

    Student selectStudentById(int id);

    List<Student> selectStudentByName(String name);

    Student selectStudentPwd(int id);
}
