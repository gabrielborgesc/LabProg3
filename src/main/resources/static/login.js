let form = document.getElementById("login-form");
let logged;

function checkLogged() {
    fetch("http://localhost:8080/login")
        .then(response => response.text())
        .then(data => logged = data);
}

function sendLoginRequest() {
    const username = document.getElementById("nome_cad").value;
    const password = document.getElementById("senha_cad").value;

    const loginRequest = {
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
                'access-control-allow-origin': '*'
            }
        });
}

function login() {
    sendLoginRequest()
        .then(checkLogged)
        .then(validateLogin);
}

function validateLogin() {
    if (logged === "true")
        document.location.href = "adminSignedIn.html";
    else
        console.log("voce falhou");
}

//$("document").ready(checkLogged);