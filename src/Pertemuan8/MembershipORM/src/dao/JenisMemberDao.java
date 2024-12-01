/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan8.MembershipORM.src.dao;


import Pertemuan8.MembershipORM.src.Model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class JenisMemberDao {

    private final SqlSessionFactory sqlSessionFactory;
    
    public JenisMemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // Insert
    public int insert(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.insert("mapper.JenisMemberMapper.insert", jenisMember);
        }
    }

    // Update
    public int update(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.update("mapper.JenisMemberMapper.update", jenisMember);
        }
    }

    // Delete
    public int delete(JenisMember jenisMember) {
        int result;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.delete("mapper.JenisMemberMapper.delete", id);
        }
    }

    // Find all
    public List<JenisMember> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.JenisMemberMapper.findAll");
        }
    }
}