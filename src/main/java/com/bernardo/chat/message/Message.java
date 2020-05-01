package com.bernardo.chat.message;

import com.bernardo.chat.room.Room;
import com.bernardo.chat.user.User;
import com.bernardo.chat.user.UserType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private LocalDateTime created_at;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Room room;
}
