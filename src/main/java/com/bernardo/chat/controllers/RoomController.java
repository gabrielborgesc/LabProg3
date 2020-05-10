package com.bernardo.chat.controllers;

import com.bernardo.chat.dto.AddUserToRoomCommand;
import com.bernardo.chat.dto.CreateRoomCommand;
import com.bernardo.chat.dto.DeleteRoomCommand;
import com.bernardo.chat.dto.RemoveUserFromRoomCommand;
import com.bernardo.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/createRoom", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String createRoom(@RequestBody CreateRoomCommand command) {
        Boolean created = this.roomService.create(command);
        return String.valueOf(created);
    }

    @RequestMapping(value = "/deleteRoom", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String deleteRoom(@RequestBody DeleteRoomCommand command) {
        Boolean deleted = this.roomService.delete(command);
        return String.valueOf(deleted);
    }


    @RequestMapping(value = "/addUserToRoom", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String addUserToRoom(@RequestBody AddUserToRoomCommand command) {
        Boolean added = this.roomService.addUser(command);
        return String.valueOf(added);
    }

    @RequestMapping(value = "/removeUserFromRoom", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String removeUserFromRoom(@RequestBody RemoveUserFromRoomCommand command) {
        Boolean removed = this.roomService.removeUser(command);
        return String.valueOf(removed);
    }
}
