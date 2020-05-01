var form = document.getElementById("login-form");

var logged;
var loginResponse;

document.getElementById("login-button").addEventListener("click", function () {
  form.submit();
});

function checkLogged()
{
	fetch("http://localhost:8080/login")
	.then(response => logged = response);
}

function login()
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

//$("document").ready(checkLogged);