package com.example.demo.user;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/user")
public class UserRest {
	 @Autowired
	    private UserDAL userDAL;
	    
	     @Autowired 
	    private HttpSession httpSession;
	    Logger logger = Logger.getLogger(UserRest.class);
		
	    /*
		 * @RequestMapping(value = "/current", method = RequestMethod.GET) public
		 * org.springframework.security.core.userdetails.User getPrincipal(
		 * 
		 * @AuthenticationPrincipal org.springframework.security.core.userdetails.User
		 * user) { return user; }
		 */

	    @RequestMapping(method = RequestMethod.GET)
	    public List<User> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
	        System.out.println("======================================");
	        System.out.println("======================================");
	        System.out.println("Calling findByAll in UserRest ");
	        System.out.println("======================================");
	        System.out.println("======================================");
	        return userDAL.findAll(offset);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public User findById(@PathVariable("id") Integer id) throws SQLException {
	        System.out.println("======================================");
	        System.out.println("Calling findById in UserRest ");
	        System.out.println("Id :: "+id);
	        System.out.println("======================================");

	        return userDAL.findById(id);

	    }
	    
	    @RequestMapping(value="/register", method = RequestMethod.POST)
	    public User insert(@RequestBody User user) throws JsonProcessingException, ParseException {
	        System.out.println("======================================");
	        System.out.println("======================================");
	        System.out.println("Calling insert in UserRest ");
	        System.out.println("First Name:: "+user.getFirstName());
	        System.out.println("Last Name:: "+user.getLastName());
	        System.out.println("Username:: "+user.getUsername());
	        System.out.println("EmailId:: "+user.getEmailId());
	        System.out.println("Mobile Number:: "+user.getMobileNum());
	        System.out.println("Role:: "+user.getRole());
	        System.out.println("======================================");
	        System.out.println("======================================");
	        
	        return userDAL.insert(user);
	    }
	    
		/*
		 * @RequestMapping(value="/login", method = RequestMethod.POST) public User
		 * login(@RequestParam("username") String username, @RequestParam("password")
		 * String pwd) throws JsonProcessingException, ParseException {
		 * System.out.println("======================================");
		 * System.out.println("Calling insert in UserRest ");
		 * 
		 * System.out.println("======================================");
		 * UsernamePasswordAuthenticationToken authReq = new
		 * UsernamePasswordAuthenticationToken(username, pwd); // AuthenticationManager
		 * a = new AuthenticationManager ();
		 * 
		 * // Authentication auth = authManager.authenticate(authReq); User u
		 * =userDAL.findByUsernamePassword(username, pwd);
		 * SecurityContextHolder.getContext().setAuthentication(authReq);
		 * httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY,
		 * SecurityContextHolder.getContext()); //HttpSession session =
		 * req.getSession(true); //session.setAttribute(SPRING_SECURITY_CONTEXT_KEY,
		 * sc); // return userDAL.findByUsernamePassword(username, pwd); return u; }
		 */
	    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
	    public User update(@RequestBody User user) throws Exception {
	        System.out.println("======================================");
	        System.out.println("Calling update in UserRest ");
	        System.out.println("First Name:: "+user.getFirstName());
	        System.out.println("Last Name:: "+user.getLastName());
	        System.out.println("Username:: "+user.getUsername());
	        System.out.println("EmailId:: "+user.getEmailId());
	        System.out.println("Mobile Number:: "+user.getMobileNum());
	        System.out.println("Role:: "+user.getRole());
	        System.out.println("======================================");
	        
	        return userDAL.update(user);
	    }

//	    @RolesAllowed("ROLE_SUPER_ADMIN")
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void delete(@PathVariable("id") Integer id) throws Exception {
	        System.out.println("======================================");
	        System.out.println("Calling delete in UserRest ");
	        System.out.println("Id :: "+id);
	        System.out.println("======================================");
	        userDAL.delete(id);
	    }

	    @RequestMapping(value = "/find/username", method = RequestMethod.GET)

	    public User findByUsername(@RequestParam("username") String username) throws Exception {
	        System.out.println("======================================");
	        System.out.println("Calling findByUsername in UserRest ");
	        System.out.println("Username :: "+username);
	        System.out.println("======================================");
	        return userDAL.findByUsername(username);
	    }
	    
	    @RequestMapping(value = "/find/user_like", method = RequestMethod.GET)
	    public List<User> findByNameLike(@RequestParam("username") String username) {
	        System.out.println("======================================");
	        System.out.println("Calling findByNameLike in UserRest ");
	        System.out.println("Username :: "+username);
	        System.out.println("======================================");
	        
	        return userDAL.findByNameLike(username);
	    }
	    
	    @RequestMapping(value = "/find/admins", method = RequestMethod.GET)
	    public List<User> findAdmins() {
	        System.out.println("======================================");
	        System.out.println("Calling findAdmins in UserRest ");
	        System.out.println("======================================");
	        
	        return userDAL.findAdmins();
	    }
	    
	    @RequestMapping(value = "/find/lawyers", method = RequestMethod.GET)
	    public List<User> findLawyers() {
	        System.out.println("======================================");
	        System.out.println("Calling findLawyers in UserRest ");
	        System.out.println("======================================");
	        
	        return userDAL.findLawyers();
	    }

}
