/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan8.MembershipORM.src.mapper;

import java.util.List;
import Pertemuan8.MembershipORM.src.Model.JenisMember;
import Pertemuan8.MembershipORM.src.Model.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {

        @Insert("INSERT INTO member (id, nama, jenis_member_id) VALUES (#{id}, #{nama}, #{jenisMemberId})")
        public Integer insert(Member member);

        @Update("UPDATE member SET nama = #{nama}, jenis_member_id = #{jenisMemberId} WHERE id = #{id}")
        public Integer update(Member member);

        @Delete("DELETE FROM member WHERE id = #{id}")
        public Integer delete(Member member);

        @Select("SELECT * FROM member")
        @Results(value = {
                        @Result(property = "id", column = "id"),
                        @Result(property = "nama", column = "nama"),
                        @Result(property = "jenisMember", column = "jenis_member_id", javaType = JenisMember.class, one = @One(select = "getJenisMember"))
        })
        List<Member> findAll();

        @Select("SELECT * FROM jenis_member WHERE id = #{id}")
        @Results(value = {
                        @Result(property = "id", column = "id"),
                        @Result(property = "nama", column = "nama")
        })
        JenisMember getJenisMember(String jenisMemberId);
}