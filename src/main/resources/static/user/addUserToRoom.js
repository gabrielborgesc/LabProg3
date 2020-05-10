import {sendCommand} from "../utils";

const addUser = () => {
    const username = document.getElementById("nome_cad").value;
    const roomName = document.getElementById("nome_sala").value;

    const addUserToRoomCommand = {
        username,
        roomName
    }

    console.log(addUserToRoomCommand);

    sendCommand('addUserToRoom', addUserToRoomCommand).then(callback)
}

const callback = (response) => {
    const data = response.text();

    if (data === "true")
        document.location.href = "userAddedToRoom.html";
    else
        window.alert('Failed')
}