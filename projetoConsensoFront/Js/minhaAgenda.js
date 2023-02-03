var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")
var totalAgendamentos = 0
document.addEventListener("DOMContentLoaded", function() {
    // code to be executed when the DOM is ready
    console.log(idUsuario)
    getAgendamentosPorId()
   
    
  });
  

async function getAgendamentosPorId() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/agendamento/usuarioprestador/${idUsuario}`, {
          method: 'GET',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        const data = await rawResponse.json();
        console.log(data)
        if(rawResponse.status == 200){
            if (data.length == 0){
                document.getElementById("nenhum-agendamento").classList.remove("d-none")
                let text = document.getElementById("titulo-agendamento")
                text.classList.add("d-none")

            
            }
            else{
                agendamentoPai = document.getElementById("agendamento-pai")
                for (let index = 0; index < data.length; index++) {
                  const element = data[index];
                  totalAgendamentos++
                  
                  
                  agendamentoPai.innerHTML += `<div class="agendamentos-container" id="${element.idAgendamento}">
                  <div>
                      <p><strong>${element.servico.nome}</strong></p>
                      <p><Strong>Prestador: </Strong>${element.usuario.nome}</p>
                      <p><Strong>Dia: </Strong>${element.data}</p>
                      <p><Strong>Horário: </Strong>${element.hora[0]}:${element.hora[1]}</p>
                  </div>
                  <div>
                      <a href="../visaoPrestador/editarServico.html"><img class="img-icon" src="../img/caneta.svg"
                              width="" alt=""></a>
                      <a href="#" onclick="deletarAgendamento(${element.idAgendamento})" ><img  class="img-icon lixo-icon" src="../img/lixo.svg" alt=""></a>
                  </div>
              </div>`
                  
                }
            }
         
          
          

        }
          
        
    } catch (error) {
        console.error(error);
    }
  }


  
  
  async function deletarAgendamento(el) {
    console.log(el)
    try {
        const rawResponse = await fetch(`http://localhost:8080/agendamento/${el}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        
        if( rawResponse.status == 202){
          let divPai = document.getElementById(el)
          divPai.remove()
          $("#sucessoModal").modal("show");
          totalAgendamentos--
          if(totalAgendamentos == 0){ 
            document.getElementById("nenhum-agendamento").classList.remove("d-none")
            let text = document.getElementById("titulo-agendamento")
            text.classList.add("d-none")

          }
        }
        
    } catch (error) {
        console.error(error);
    }
    
  } 