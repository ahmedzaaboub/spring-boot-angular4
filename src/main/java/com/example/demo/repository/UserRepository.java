	package com.example.demo.repository;
	import java.awt.print.Pageable;
	import org.springframework.data.repository.query.Param;
	import org.springframework.data.domain.Page;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import com.example.demo.entity.Usermanger;
	
	public interface UserRepository  extends JpaRepository<Usermanger,Long>  {

		@Query("from Usermanger u where u.login =:x and u.password=:y" )
		public Usermanger authenticate(@Param("x")String name_user ,@Param("x")String password);
		@Query("from Usermanger u where u.login =:x" )
		public Usermanger findbyname(@Param("x")String login );
	}
