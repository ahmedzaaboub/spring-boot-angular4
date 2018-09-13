package com.example.demo.serviceImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Usermanger;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;



@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public Usermanger save(Usermanger user) {
		// TODO Auto-generated method stub
		
		
		return userRepository.save(user);
		
	}

	@Override
	public List<Usermanger> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	

	@Override
	public Usermanger findBylogin(String login  ,String password)
	{
		
		return userRepository.authenticate(login, password);
		
	}

	@Override
	public Usermanger findByusername(String login) {
		// TODO Auto-generated method stub
		return userRepository.findbyname(login) ;
	}

	@Override
	public Usermanger updateUser(Usermanger user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Boolean deleteUser(long code_user) {
		// TODO Auto-generated method stub
	 userRepository.delete(code_user);;
	return true;
	}

	


	




}
