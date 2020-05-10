username = "Bernardo";

messages = [
{
	sender: "Bernardo",
	content: "oi"
},
{
	sender: "Borges",
	content: "oi"
},
{
	sender: "Lauren",
	content: "oi"
},
{
	sender: "GV",
	content: "oi"
},
{
	sender: "Plena",
	content: "oi"
},
{
	sender: "Bernardo",
	content: "oi"
}
];


// Função que adiciona uma mensagem na conversa
function addMessage(message)
{
	// Verificação se a mensagem foi enviada pelo próprio usuário ou por outro
	if(message.sender === username)
		var messageContainer = CreateMessageContainer("sent", message.content);
	else
		var messageContainer = CreateMessageContainer("received", message.content);


	document.getElementById("container").appendChild(messageContainer);
}

// Função que gera a mensagem a ser adicionada dependendo de quem enviou
function CreateMessageContainer(type, content)
{
	var messageContainer = document.createElement("div");
	messageContainer.classList.add("message-container");
	messageContainer.classList.add("message-" + type + "-container");

	var message = document.createElement("div");
	message.classList.add("message");
	message.classList.add("message-" + type);

	var messageContent = document.createTextNode(content);

	message.appendChild(messageContent);
	messageContainer.appendChild(message);

	return messageContainer;
}


// Função que carrega as mensagens iniciais
function loadMessages()
{
	messages.forEach(addMessage);
}

// Função que carrega a mensagem enviada pelo usuário na conversa
function sendMessage()
{
	var messageSent = {};

	messageSent.sender = username;
	messageSent.content = $('input[name=message]').val();

	addMessage(messageSent);
	$('input[name=message]').val('');
}


$("document").ready(loadMessages);

window.setInterval(function(){
	addMessage({sender:'Gabilu', content:'oioioi'});
}, 5000);