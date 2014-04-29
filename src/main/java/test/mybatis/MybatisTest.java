package test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * User: a12353
 * Date: 2014/04/29
 * Time: 14:35
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(Class.class.getResourceAsStream("/test/mybatis/mybatis-config.xml")));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(br);
        SqlSession session = sqlSessionFactory.openSession(true);
        TestMapper mapper = session.getMapper(TestMapper.class);

        Test t1 = mapper.select(1);
        System.out.println(t1.getId() + ":" + t1.getName());

        Test t2 = new Test();
        t2.setId(3);
        t2.setName("oro");
        mapper.insert(t2);

        List<Test> list = mapper.selectAll();
        for(Test t : list){
            System.out.println(t.getId() + ":" + t.getName());
        }
        session.close();
    }
}
