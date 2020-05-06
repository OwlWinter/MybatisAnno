package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DiscipleDao {

    @Select("select * from registery_info where id = #{id}")
    List<Disciple> query(int id);

    @Insert("INSERT INTO registery_info (qq_num, student_id, student_name, major_subject, graduated_school,\n" +
            "            brother, come_from, daily_report, slogan, create_time)\n" +
            "        VALUES (#{qq_num}, #{student_id}, #{student_name}, #{major_subject}, #{graduated_school},\n" +
            "            #{brother}, #{come_from}, #{daily_report}, #{slogan}, now())")
    int insert(Disciple disciple);

    @Update("update registery_info set qq_num = #{qq_num}, student_id = #{student_id}, student_name = #{student_name}, " +
            "major_subject = #{major_subject}, graduated_school = #{graduated_school}, brother = #{brother}, " +
            "come_from = #{come_from}, daily_report = #{daily_report}, slogan = #{slogan} where id = #{id}")
    int update(Disciple disciple);

    @Delete("delete from registery_info where id = #{id}")
    int delete(int id);
}
