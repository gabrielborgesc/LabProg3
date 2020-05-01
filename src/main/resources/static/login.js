var form = document.getElementById("login-form");

var logged;
var loginResponse;

function checkLogged()
{
	fetch("http://localhost:8080/login")
	.then(response => response.text())
	.then(data => logged = data);
}

function sendLoginRequest()
{
	var username = document.getElementById("nome_cad").value;
	var password = document.getElementById("senha_cad").value;
	
	var loginRequest = {
			username: username,
			password: password
	}
	
	console.log(loginRequest);
	
	fetch("http://localhost:8080/login", 
            {
                method: 'POST',
                body: JSON.stringify(loginRequest),
                headers: {
                    'Content-Type': 'application/json',
                    'access-control-allow-origin':'*'
                  }
            });
}

function login()
{
	sendLoginRequest()
	.then(() => checkLogged())
	.then(() => validateLogin());
}

function validateLogin()
{
	if(logged == "true")
		document.location.href = "adminsignedin.html";
	else
		console.log("voce falhou");
}

//$("document").ready(checkLogged);