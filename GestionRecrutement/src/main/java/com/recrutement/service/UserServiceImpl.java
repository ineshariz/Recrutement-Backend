package com.recrutement.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.recrutement.dao.UserRepository;
import com.recrutement.models.Offre;
import com.recrutement.models.User;

@Service(value= "userService")
public class UserServiceImpl implements UserService, UserDetailsService{
	@PersistenceContext()
	EntityManager em ;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getListUser() {
		return userRepository.findAll();
	}
	
	

	@Override
	public User findById(Integer id) {
	    return userRepository.getOne(id);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = findById(id);
		if(user != null){
			userRepository.delete(user);
		}		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.print(email);
		Optional<User> optionalUsers = userRepository.findByEmail(email);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("email not found"));
        //return optionalUsers
          //      .map(CustomUserDetails::new).get();
        return new org.springframework.security.core.userdetails.User(optionalUsers.get().getEmail(), optionalUsers.get().getPass(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public Optional<User> findByEmail(String email) {
		Optional<User> findUser = userRepository.findByEmail(email);
		return findUser;
	}

	@Override
	public List<Number> nombreCandidat(Offre offre) {
				Query query = em.createQuery("SELECT COUNT(a.id) FROM Demande a  WHERE a.offre.id ="+offre.getId());
		        System.out.println(query.toString());       
				return  query.getResultList();

	
	}

	
}
