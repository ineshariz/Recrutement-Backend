package com.recrutement.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.recrutement.dao.RecruteurRepository;
import com.recrutement.dao.UserRepository;
import com.recrutement.models.Candidat;
import com.recrutement.models.Recruteur;
import com.recrutement.models.User;

@Service(value= "userService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RecruteurRepository recruteurRepository;
	
	@Autowired
	static RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	public Recruteur addRecruteur(Recruteur recruteur) {
		recruteur.setPass(bCryptPasswordEncoder.encode(recruteur.getPass()));
		recruteur.setDateRecrutement(new Date());
		//recruteur.setRole(roleService.findById(1));
		System.out.println(recruteur);
		return userRepository.save(recruteur);
	}

	@Override
	public List<Recruteur> getListRecruteur() {
		return recruteurRepository.findAll();
	}

	@Override
	public Recruteur editRecruteur(Recruteur recruteur) {
		return userRepository.save(recruteur);
	}

	@Override
	public Candidat addCandidat(Candidat candidat) {
		candidat.setPass(bCryptPasswordEncoder.encode(candidat.getPass()));
		candidat.setDateInscription(new Date());
		return userRepository.save(candidat);
	}

	
}
