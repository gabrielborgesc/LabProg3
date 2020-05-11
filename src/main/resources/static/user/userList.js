var success;

function appendUser(user)
{
	// Cria o elemento para uma nova linha da tabela
	var row = document.createElement("tr");					

	// Cria a coluna de nome
	var nameColumn = document.createElement("td");
	var name = document.createTextNode(user.username);
	nameColumn.appendChild(name);
	row.appendChild(nameColumn);

	// Cria a coluna de email
	var emailColumn = document.createElement("td");
	var email = document.createTextNode(user.email);
	emailColumn.appendChild(email);
	row.appendChild(emailColumn);

	// Cria a coluna do tipo
	var typeColumn = document.createElement("td");
	var type = document.createTextNode(user.type);
	typeColumn.appendChild(type);
	row.appendChild(typeColumn);

	// Adiciona a linha criada na tabela
	document.getElementById("listTable").appendChild(row);
}

function retrieveList()
{
	fetch("/getUserList",
	        {
	            method: 'GET',
	            headers: {
	                'access-control-allow-origin': '*'
	            }
	        })
	        .then(response => response.json())
	        .then(data => userList = data)
	        .then(loadList);
}

function loadList()
{
	userList.forEach(appendUser);
}

$("document").ready(retrieveList);