package cn.zyx.dao;

import cn.zyx.bean.Course;

public interface CourseDao {
    Course selectCourseStudentById(int id);
}
