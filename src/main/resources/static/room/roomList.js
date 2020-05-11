var success;

function appendRoom(room)
{
	// Cria o elemento para uma nova linha da tabela
	var row = document.createElement("tr");					

	// Cria a coluna de sala
	var roomColumn = document.createElement("td");
	var room = document.createTextNode(room.roomName);
	roomColumn.appendChild(room);
	row.appendChild(roomColumn);

	// Adiciona a linha criada na tabela
	document.getElementById("listTable").appendChild(row);
}

function retrieveList()
{
	fetch("/getRoomList",
	        {
	            method: 'GET',
	            headers: {
	                'access-control-allow-origin': '*'
	            }
	        })
	        .then(response => response.json())
	        .then(data => roomList = data)
	        .then(loadList);
}

function loadList()
{
	roomList.forEach(appendRoom);
}

$("document").ready(retrieveList);