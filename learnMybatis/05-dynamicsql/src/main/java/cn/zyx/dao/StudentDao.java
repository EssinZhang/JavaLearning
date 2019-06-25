package cn.zyx.dao;

import cn.zyx.bean.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectIf (Student student);
    List<Student> selectWhere(Student student);
    List<Student> selectChoose(Student student);
    List<Student> selectForEachArray(int[] ids);
    List<Student> selectForEachList(List<Integer> ids);
    List<Student> selectForEachStuList(List<Student> studentList);
    List<Student> selectWarn(List<Student> studentList);

}
