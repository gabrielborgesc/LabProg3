package com.bernardo.chat.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "rooms")
  private Set<User> users = new HashSet<>();

  //
  // Métodos de acesso
  //

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String roomName) {
    this.name = roomName;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
