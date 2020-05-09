chatList = [
	{
		id: 1,
		name: 'Sala 2',
		lastMessage: 'oi'
	},
	{
		id: 2,
		name: 'Sala 3',
		lastMessage: 'Teste'
	},
	{
		id: 3,
		name: 'Sala 4',
		lastMessage: 'ola'
	},
	{
		id: 4,
		name: 'Sala 5',
		lastMessage: 'hello'
	}

];


function appendChat(chat)
{
	// Cria o elemento para uma nova linha da tabela
	var row = document.createElement("tr");					

	// Cria a coluna de nome
	var nameColumn = document.createElement("td");
	var name = document.createTextNode(chat.name);
	nameColumn.appendChild(name);
	row.appendChild(nameColumn);

	// Cria a coluna de última mensagem
	var lastMessageColumn = document.createElement("td");
	var lastMessage = document.createTextNode(chat.lastMessage);
	lastMessageColumn.appendChild(lastMessage);
	row.appendChild(lastMessageColumn);

	// Cria a coluna do botão
	var buttonColumn = document.createElement("td");
	var button = document.createElement("button");
	button.setAttribute('onclick', 'document.location = "chat.html";')

	var buttonText = document.createTextNode("Entrar");
	buttonColumn.appendChild(button);
	button.appendChild(buttonText);
	row.appendChild(buttonColumn);

	// Adiciona a linha criada na tabela
	document.getElementById("chatTable").appendChild(row);
}

function loadChat()
{
	chatList.forEach(appendChat);
}

$("document").ready(loadChat);