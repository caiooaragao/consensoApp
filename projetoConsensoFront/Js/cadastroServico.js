var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")



let botao = document.getElementById("cadastro-servico")
botao.addEventListener("click", function(event){
    event.preventDefault()
  let nome = document.getElementById("nome").value
  let descricao = document.getElementById("descricao").value
  
  sendDataToAPI(nome, descricao, idUsuario)
  
});


async function sendDataToAPI(nome, descricao, idUsuario) {
    
  try {
      const rawResponse = await fetch('http://localhost:8080/servico', {
        method: 'POST',
        headers: {
          'idUsuario':idUsuario,
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({nome:nome, descricao:descricao, usuarioPrestador:{idUsuario:idUsuario}})
      });
      const content = await rawResponse.json();
      console.log(rawResponse)
      if(rawResponse.status == 201){
        $("#sucessoModal").modal("show");
        
      }
    
      console.log(content);
    }catch (error) {
      console.error(error);
}}


