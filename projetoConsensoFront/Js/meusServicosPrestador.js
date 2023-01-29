var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")
totalAgendamentos = 0
document.addEventListener("DOMContentLoaded", function() {
    // code to be executed when the DOM is ready
    console.log(idUsuario)
    getServicosPorId()
   
    
  });
  

async function getServicosPorId() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/servico/usuario/${idUsuario}`, {
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
                let popup = document.getElementById("nenhum-agendamento")
                popup.classList.remove("d-none")
                let text = document.getElementById("titulo-agendamento")
                text.classList.add("d-none")

            
            }
            else{
                agendamentoPai = document.getElementById("agendamento-pai")
                for (let index = 0; index < data.length; index++) {
                  const element = data[index];
                  agendamentoPai.innerHTML += `
                  <div class="main-container d-flex flex-column gap-3" id="${element.idServico}">
                  <div class="agendamentos-container" >
                      <div>
                          <p><strong>${element.nome}</strong></p>
                      </div>
                      <div>
                          <a href="./editarServico.html"><img class="img-icon" src="../img/caneta.svg" width="" alt=""></a>
                          <a onclick="deletarAgendamento(${element.idServico})" href="#"><img class="img-icon lixo-icon" src="../img/lixo.svg" id="lixo-icon" alt=""></a>
                      </div>
                  </div>
              </div>`
              totalAgendamentos++
                  
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
        const rawResponse = await fetch(`http://localhost:8080/servico/${el}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        console.log(rawResponse.status)
        let testtest = String(el)
        cleanId = testtest.trim()
        console.log(cleanId)
        if( rawResponse.status == 200){
        const divpai = document.getElementById(cleanId)
        console.log(divpai)
          console.log(el)   
          
          divpai.remove()
          window.alert("Serviço deletado!")
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