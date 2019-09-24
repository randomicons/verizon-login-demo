function login() {
    fetch("/login",
        {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST', body: JSON.stringify({
                userId: document.getElementById("user-id").value,
                password: document.getElementById("password").value
            })
        })
        .then(res => res.text())
        .then( (res) => {
            document.getElementById("login-status").innerHTML = res
        }).catch(function (reason) {
        document.getElementById("login-status").innerHTML = "Login Failed"
    })
    return false
}