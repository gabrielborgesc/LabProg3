var success;

function logout()
{
    fetch("/logout",
        {
            method: 'POST',
            body: JSON.stringify({}),
            headers: {
                'Content-Type': 'application/json',
                'access-control-allow-origin': '*'
            }
        })
        .then(response => response.text())
        .then(data => success = data)
        .then(logoutCallback);
}

function logoutCallback()
{
    if(success === "true")
        document.location = 'index.html';
    else
        window.alert("Não foi possível realizar essa operação");
}