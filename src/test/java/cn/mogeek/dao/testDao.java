package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import sun.security.util.DisabledAlgorithmConstraints;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class testDao {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(DiscipleDao.class);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Disciple disciple = new Disciple();
        disciple.setMajor_subject("无限奥义循环");
        disciple.setCome_from("英国");
        disciple.setDaily_report("https://baike.baidu.com/item/%E5%A5%87%E5%BC%82%E5%8D%9A%E5%A3%AB/2492942");
        disciple.setBrother("古一法师");
        disciple.setSlogan("多玛姆，我是来找你谈判的！");
        disciple.setGraduated_school("格林威治村");

        Disciple temp = null;
        try {
            temp = (Disciple)disciple.clone();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
            return;
        }

        try {
            DiscipleDao discipleDao = sqlSession.getMapper(DiscipleDao.class);
            long num, ass;
            for (int i = 1; i <= 10; i ++){
                num = System.currentTimeMillis();
                temp.setQq_num((int)(num % 100000));
                temp.setStudent_id((int)(num % 10000));
                temp.setStudent_name("奇异博士-NO:" + i);
                ass = discipleDao.insert(temp);
                Assert.assertTrue(ass != -1);
            }

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }

    public List<Disciple> testQuery(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscipleDao discipleDao = sqlSession.getMapper(DiscipleDao.class);

        List<Disciple> discipleList = discipleDao.query(id);
        for (Disciple d :
                discipleList) {
            System.out.println(d);
        }

        System.out.println("Count: " + discipleList.size());
        return discipleList;
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscipleDao discipleDao = sqlSession.getMapper(DiscipleDao.class);

        int id = 30000493;
        Disciple disciple = testQuery(id).get(0);
        disciple.setStudent_name("testUpdate");
        discipleDao.update(disciple);
        sqlSession.commit();

        Assert.assertEquals(testQuery(id).get(0).getStudent_name(), disciple.getStudent_name());
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscipleDao discipleDao = sqlSession.getMapper(DiscipleDao.class);
        int id = 30000496;
        discipleDao.delete(id);
        sqlSession.commit();

        Assert.assertTrue(testQuery(id).size() == 0);
        sqlSession.close();
    }

}
