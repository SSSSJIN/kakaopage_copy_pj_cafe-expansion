package com.kakaopage.expansion.dao;

import java.sql.*;
import org.springframework.stereotype.Repository;
import com.kakaopage.expansion.dao.MemberDAO;
import com.kakaopage.expansion.vo.MemberVO;
import com.kakaopage.expansion.util.DBUtil;  // 여러분의 DBUtil 클래스 위치에 맞춰 수정

@Repository
public class MemberDAOImpl implements MemberDAO {

    /** findById: 로그인 시 아이디 유무/비번 확인용 */
    @Override
    public MemberVO findById(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVO member = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT id, password FROM members WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, conn);
        }
        return member;
    }

    /** insertMember: 회원가입 프로세스에서 호출 */
    @Override
    public int insertMember(MemberVO member) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO members(id, password) VALUES(?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(pstmt, conn);
        }
        return result;
    }
}
