package com.bernardo.chat.repositories;

import com.bernardo.chat.domain.Useroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseroomRepository extends CrudRepository<Useroom, Integer> {
  //	public ArrayList<Useroom> findByUserId(Integer user_id); ///busca todos os pares de usuário
  // sala
  /// para um determinado usuário
}
