package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
//		return map.get(email);
		List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}
		}, email);

		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member member) {
//		member.setId(++nextId);
//		map.put(member.getEmail(), member);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE)" + "values (?,?,?,?)",
						new String[] { "ID" });
					pstmt.setString(1, member.getEmail());
					pstmt.setString(2, member.getPassword());
					pstmt.setString(3, member.getName());
					pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
					return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());

	}

	public void update(Member member) {
//		map.put(member.getEmail(), member);
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", member.getName(),
				member.getPassword(), member.getEmail());

	}

	public List<Member> selectAll() {
//		return map.values();
		List<Member> results = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
		return results;
	}

	public int count() {
//결과가 1행인 경우 실행할 수 있는 메서드
//		List<Integer> results = jdbcTemplate.query("select count(*) from MEMBER",
//				new RowMapper<Integer>() {
//
//					@Override
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return rs.getInt(1);
//					}
//		});
//		return results.get(0);
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}
}
