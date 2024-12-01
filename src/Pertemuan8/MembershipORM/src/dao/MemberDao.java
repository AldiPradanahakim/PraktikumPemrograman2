/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan8.MembershipORM.src.dao;


import Pertemuan7.MembershipORM.src.Model.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class MemberDao {

    private final SqlSessionFactory sqlSessionFactory;

    public MemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // Insert
    public int insert(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.insert("mapper.MemberMapper.insert", member);
        }
    }

    // Update
    public int update(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.update("mapper.MemberMapper.update", member);
        }
    }

    // Delete
    public int delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.delete("mapper.MemberMapper.delete", id);
        }
    }

    // Find all
    public List<Member> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.MemberMapper.findAll");
        }
    }
}