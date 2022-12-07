package com.example.board;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

    //JdbcTemplate jdbcTemplate;
    @Autowired
    SqlSession sqlSession;

//    Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD  where seq=?";
    private final String BOARD_GET = "select * from BOARD  where seq=?";
    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    //C
    public int insertBoard(BoardVO vo) {
        System.out.println("===> jdbcTemplate으로 insertBoard() 기능 처리");
        //return jdbcTemplate.update(BOARD_INSERT, new Object[]{vo.getTitle(), vo.getWriter(), vo.getContent()});

        return sqlSession.insert("BoardDAO.insertBoard", vo);
    }

    //D
    public int deleteBoard(int seq) {
        System.out.println("===> jdbcTemplate으로 deleteBoard() 기능 처리");
        //return jdbcTemplate.update(BOARD_DELETE, new Object[]{seq});
        return sqlSession.insert("BoardDAO.deleteBoard", seq);
    }

    //U
    public int updateBoard(BoardVO vo) {
        System.out.println("===> jdbcTemplate으로 updateBoard() 기능 처리");
        //return jdbcTemplate.update(BOARD_UPDATE, new Object[]{vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq()});
        return sqlSession.insert("BoardDAO.updateBoard", vo);
    }


    class BoardRowMapper implements RowMapper<BoardVO>{
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO vo = new BoardVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setWriter(rs.getString("writer"));
            vo.setContent(rs.getString("content"));
            vo.setRegdate(rs.getDate("regdate"));
            return vo;
        }
    }


    //R
    public BoardVO getBoard(int seq) {
        BoardVO one = new BoardVO();
        System.out.println("===> jdbcTemplate으로 getBoard() 기능 처리");
        //String sql = "select * from BOARD  where seq=" + seq;
        //return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
        return sqlSession.selectOne("BoardDAO.getBoard", seq);
    }


    //Rrrrr
    public List<BoardVO> getBoardList(){
        System.out.println("===> jdbcTemplate으로 getBoardList() 기능 처리");
        //String sql = "select * from BOARD ORDER BY regdate DESC";
        //return jdbcTemplate.query(sql, new BoardRowMapper());
        return sqlSession.selectList("BoardDAO.getBoardList");
    }




}