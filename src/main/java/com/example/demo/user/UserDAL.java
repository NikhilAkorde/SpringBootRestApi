package com.example.demo.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAL {
	  public static final class Columns {

	        public static final String ID = "id";
	        public static final String FIRST_NAME = "first_name";
	        public static final String LAST_NAME = "last_name";
	        public static final String MOBILE_NUM = "mobile_num";
	        public static final String EMAIL_ID = "email_id";
	        public static final String ROLE = "role";
	        public static final String USERNAME = "username";
	        public static final String PASSWORD = "password";        
	    }

	    public static final String TABLE_NAME = "user";

	    private final SimpleJdbcInsert insertUser;
	    private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public UserDAL(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        insertUser = new SimpleJdbcInsert(jdbcTemplate)
	                .withTableName(TABLE_NAME)
	                .usingColumns(
	                        Columns.FIRST_NAME,
	                        Columns.LAST_NAME,
	                        Columns.MOBILE_NUM,
	                        Columns.EMAIL_ID,
	                        Columns.ROLE,
	                        Columns.USERNAME,
	                        Columns.PASSWORD
	                )
	                .usingGeneratedKeyColumns(Columns.ID);
	    }

	    public List<User> findAll(Integer offset) {

	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 5 OFFSET ?";
	        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(User.class));
	    }

	    public User findById(Integer id) {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME  + Columns.ID + " = ?";
	        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
	    }
	    
	    public User findByUsernamePassword(String uname, String pwd) {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.USERNAME + " = ?" + " AND ";
	        sqlQuery += Columns.PASSWORD + " = ? ";
	        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{uname,pwd}, new BeanPropertyRowMapper<>(User.class));
	    }
	    
	    public List<User> findLawyers() {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ROLE + " = 'ROLE_FIRM' or "+Columns.ROLE+" = 'ROLE_LAWYER'";
	        return jdbcTemplate.query(sqlQuery, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
	    }

	    public User findByUsername(String username) {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.USERNAME + " = ?";
	        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
	    }

	    public List<User> findByNameLike(String username) {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND lower(username) LIKE?";
	        String userNameLike = "%" + username.toLowerCase() + "%";
	        return jdbcTemplate.query(sqlQuery, new Object[]{userNameLike}, new BeanPropertyRowMapper<>(User.class));
	    }
	    
	    public List<User> findAdmins() {
	        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND "+Columns.ROLE+" = 'ROLE_ADMIN'";
	        return jdbcTemplate.query(sqlQuery, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
	    }

	    public User insert(User user) {
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put(Columns.FIRST_NAME, user.getFirstName());
	        parameters.put(Columns.LAST_NAME, user.getLastName());
	        parameters.put(Columns.MOBILE_NUM, user.getMobileNum());
	        parameters.put(Columns.EMAIL_ID, user.getEmailId());
	        parameters.put(Columns.ROLE, user.getRole().name());
	        parameters.put(Columns.USERNAME, user.getUsername());
	        parameters.put(Columns.PASSWORD, user.getPassword());                
	        Number newId = insertUser.executeAndReturnKey(parameters);
	        user = findById(newId.intValue());
	        return user;
	    }

	    public void delete(Integer id) {
	        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
	        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
	    }

	    public User update(User user) {
	        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
	                + Columns.FIRST_NAME + " = ?,"
	                + Columns.LAST_NAME + " = ?, "
	                + Columns.MOBILE_NUM + " = ?, "
	                + Columns.EMAIL_ID + " = ?, "
	                + Columns.ROLE + " = ?,"
	                + Columns.USERNAME + " = ?,"
	                + Columns.PASSWORD + " = ? WHERE " + Columns.ID + " = ?";
	        Number updatedCount = jdbcTemplate.update(sqlQuery,
	                new Object[]{
	                    user.getFirstName(),
	                    user.getLastName(),
	                    user.getMobileNum(),
	                    user.getEmailId(),
	                    user.getRole().name(),
	                    user.getUsername(),
	                    user.getPassword(),                    
	                    user.getId()
	                });
	        System.out.println("get count of user ::: "+user.getId());
	        user = findById(user.getId());
	        System.out.println("get count of user ::: "+user);
	        return user;
	    }
}
