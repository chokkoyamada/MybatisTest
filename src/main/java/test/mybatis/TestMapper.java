package test.mybatis;

import java.util.List;

/**
 * User: a12353
 * Date: 2014/04/29
 * Time: 14:42
 */
public interface TestMapper {
    Test select(int id);
    List<Test> selectAll();
    void insert(Test t);
}
