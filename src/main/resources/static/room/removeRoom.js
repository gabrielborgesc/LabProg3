function removeRoom() {
    const roomName = document.getElementById("nome_cad").value;

    const removeRoomCommand = {
        roomName: roomName
    }

    console.log(removeRoomCommand);

    fetch("http://localhost:8081/removeRoom",
        {
            method: 'POST',
            body: JSON.stringify(removeRoomCommand),
            headers: {
                'Content-Type': 'application/json',
                'access-control-allow-origin': '*'
            }
        })
        .then(response => response.text())
        .then(data => success = data)
        .then(callback);
}

function callback() {
    if (success === "true")
        document.location.href = "roomRemoved.html";
    else
        window.alert("Não foi possível realizar essa operação");
}