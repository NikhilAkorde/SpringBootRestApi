/*
 * package com.example.demo.user;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.dao.EmptyResultDataAccessException; import
 * org.springframework.security.access.hierarchicalroles.RoleHierarchy; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service public class UserService implements UserDetailsService { private
 * final Logger logger = LoggerFactory.getLogger(this.getClass());
 * 
 * @Autowired private UserDAL userDAL;
 * 
 * @Autowired private RoleHierarchy roleHierarchy;
 * 
 * private List<User> users;
 * 
 * public List<User> findByRole(Role role) { List<User> found = new
 * ArrayList<>();
 * 
 * for (User u : users) { if (u.getRole().equals(role)) { found.add(u); } }
 * return found; }
 * 
 * @Override public UserDetails loadUserByUsername(String string) throws
 * UsernameNotFoundException {
 * 
 * try {
 * 
 * User user = userDAL.findByUsername(string);
 * 
 * SimpleGrantedAuthority sga = new
 * SimpleGrantedAuthority(user.getRole().name());
 * 
 * List<SimpleGrantedAuthority> authorities = new ArrayList<>();
 * authorities.add(sga);
 * 
 * UserDetails ud = new org.springframework.security.core.userdetails.User(
 * user.getUsername(), user.getPassword(),
 * roleHierarchy.getReachableGrantedAuthorities(authorities)); return ud; }
 * catch (EmptyResultDataAccessException se) { se.printStackTrace(); throw new
 * UsernameNotFoundException("SQL Error", se); } }
 * 
 * public User getLoggedInUser(){
 * org.springframework.security.core.userdetails.User user = (
 * org.springframework.security.core.userdetails.User
 * )SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 * 
 * System.out.println("user"+user.getUsername()); return
 * userDAL.findByUsername(user.getUsername()); } }
 */