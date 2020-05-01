package com.bernardo.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardo.chat.domain.Useroom;

@Repository
public interface UseroomRepository extends JpaRepository<Useroom, Integer>
{
//	public ArrayList<Useroom> findByUserId(Integer user_id); ///busca todos os pares de usuário sala
	///para um determinado usuário
}
