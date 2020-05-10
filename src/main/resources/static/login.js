import {sendCommand} from "./utils";

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
        username,
        password
    }

    console.log(loginRequest);

    sendCommand('login', loginRequest).then(response => response.text())
        .then(data => logged = data)
        .then(validateLogin);
}

function login() {
    sendLoginRequest();
//        .then(checkLogged)
//        .then(validateLogin);
}

function validateLogin() {
    if (logged === "ADMIN")
        document.location.href = "adminSignedIn.html";
    else if (logged === "REGULAR")
        document.location.href = "chat/chatSelector.html";
    else
        console.log("voce falhou");
}

//$("document").ready(checkLogged);