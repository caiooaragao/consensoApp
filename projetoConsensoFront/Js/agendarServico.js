document.addEventListener("DOMContentLoaded", function() {
    // code to be executed when the DOM is ready
    getServicosDisponiveis()
    agendarServico()



}) 



function agendarServico() {
    


    (async () => {
        const rawResponse = await fetch('http://localhost:8080/agendamento', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({nome: nome, email:email, senha:senha, tipoUsuario:{
            idTipoUsuario:tipoUsuario
          }})
        });
        const content = await rawResponse.json();
      
        console.log(content);
      })();
  }


async function getServicosDisponiveis() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/servico`, {
          method: 'GET',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        const data = await rawResponse.json();
        console.log(data);

        if(rawResponse.status == 201){
            selecionarServico = document.getElementById("selecionar-servico")
                for (let index = 0; index < data.length; index++) {
                  const element = data[index];
                  selecionarServico.innerHTML += `
                        <option value="${element.idServico}">${element.nome}</option>
                  `
        }}
    } catch (error) {
        console.error(error);
    }
  }