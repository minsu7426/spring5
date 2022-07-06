package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import dto.MemberDto;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(MemberDto memberDto) {
		jdbcTemplate.update("insert into Member values(?,?,?)", memberDto.getId(), memberDto.getName(),
				memberDto.getAge());
	}

	public List<MemberDto> searchAll() {
		List<MemberDto> result = jdbcTemplate.query("select * from member", new RowMapper<MemberDto>() {
			@Override
			public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				return member;
			}
		});
		return result;
	}
	
	public List<MemberDto> search(String title, String text) {
		String sql = "select * from member where "+title+" like '%"+text+"%'";
		List<MemberDto> result = jdbcTemplate.query(sql, new RowMapper<MemberDto>() {
			@Override
			public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				return member;
			}
		});
		return result;
	}
}
