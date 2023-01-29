//referenciar os elementos html
const form = document.getElementById("form-signin")
const login = document.getElementById("inputLogin")
const senha = document.getElementById("inputSenha")


const divLogin = document.getElementById("div-login")
const divSenha = document.getElementById("div-senha")






form.addEventListener("submit", (e) => {
    e.preventDefault()
    validarEntradas(login, senha)
})


var verificadorLogin = 0
var verificadorSenha = 0


document.getElementById("inputLogin").addEventListener("focus", function() {

    login.classList.remove("is-invalid")
    divLogin.removeChild(itemLogin)
    verificadorLogin = 0
    
});

document.getElementById("inputSenha").addEventListener("focus", function() {
 
    verificadorSenha = 0
    senha.classList.remove("is-invalid")
    divSenha.removeChild(itemSenha)
});




function validarEntradas(l, s) {
 
    const loginValue = String(l.value)
    const senhaValue = String(s.value)


    if (loginValue === "" || loginValue == null) {
        if(verificadorLogin == 0){
            login.className = "form-control is-invalid"
            let itemLogin = document.createElement("p")
            itemLogin.id = "itemLogin"
            divLogin.appendChild(itemLogin)
            itemLogin.innerHTML="O campo Login é obrigatório"
            itemLogin.style ="color:red; text-align:left;"
            verificadorLogin = 1
            
        }
            
    } else if (senhaValue === "" || senhaValue == null) {
        if (verificadorSenha == 0){
            senha.className ="form-control is-invalid"
            let itemSenha = document.createElement("p")
            itemSenha.id ="itemSenha"
            divSenha.appendChild(itemSenha)
            itemSenha.innerHTML ="Senha é um campo obrigatório"
            itemSenha.style ="text-align:left; color:red;"
            verificadorSenha = 1
            
        }
        

    } else if (senhaValue.length < 6) {
        console.log("A senha deve ter no mínimo 6 caracteres.")

        if (verificadorSenha == 0){
            senha.className ="form-control is-invalid"
            var itemSenha = document.createElement("p")
            itemSenha.id ="itemSenha"
            divSenha.appendChild(itemSenha)
            itemSenha.innerHTML ="A senha deve ter no mínimo 6 caracteres."
            itemSenha.style ="text-align:left; color:red;"
            verificadorSenha = 1
            
        }
    } else {
       
        sendDataToAPI(login.value, String(senha.value))
    
    }

}

function validarEmail(ev) {
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(ev)
}




function sendDataToAPI(email, senha) {
   
    (async () => {
        const rawResponse = await fetch('http://localhost:8080/login', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            email:email,
            senha:senha
          })
        });
        

        if(rawResponse.status === 202){
            const jsonResponse = await rawResponse.json();
            var usuario = jsonResponse;
            var idUsuario = usuario.idUsuario
            var idTipoUsuario = usuario.tipoUsuario.idTipoUsuario
            localStorage.setItem("idUsuario", idUsuario );
            localStorage.setItem("idTipoUsuario", idTipoUsuario );
            console.log(usuario)
            if(idTipoUsuario == 1){
                window.location.href = './visaoCliente/agendarServico.html'; 
            }else if(idTipoUsuario == 2){
                window.location.href = './visaoPrestador/meusServicosPrestador.html';

            }

          
            }
        else{
            
            loginIncorreto = document.getElementById("login-incorreto").classList.remove("d-none")
            
            

        }
      
        
      })();
  }
  
