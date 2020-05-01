package com.bernardo.chat.room;

import com.bernardo.chat.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "user_room")
    private Set<User> users;
}
