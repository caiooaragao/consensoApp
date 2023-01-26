var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")
form = document.getElementById("agendar-form")

var botaoVerAgendamentos = document.getElementById("botao-ver-agendamentos")
botaoVerAgendamentos.addEventListener("click", getAgendamentosPorId)

form.addEventListener("submit", (e) => {
    e.preventDefault();
    getDataFromAPI();
})

// PAGINA DE LISTAR OS AGENDAMENTOS (MEUS SERVICOS)

async function getAgendamentosPorId() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/agendamento/usuario/${idUsuario}`, {
          method: 'GET',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        const data = await rawResponse.json();
        console.log(data)
        if(rawResponse.status == 200){
          botaoVerAgendamentos.classList.add("d-none")
          agendamentoPai = document.getElementById("agendamento-pai")
          for (let index = 0; index < data.length; index++) {
            const element = data[index];
            
            agendamentoPai.innerHTML += `<div class="agendamentos-container">
          <div>
            <p><strong>${element.servico?.nome}</strong></p>
            <p><Strong>Prestador: </Strong>${element.servico?.usuarioPrestador.nome}</p>
            <p><Strong>Dia: </Strong>${element.data}</p>
            <p><Strong>Horário: </Strong>: ${element.hora[0]}:${element.hora[1]}h</p>
          </div>
          <div>
            <a href="../visaoCliente/editarAgendamento.html?id=${element.id}"><img class="img-icon" src="../img/caneta.svg"
                alt=""></a>
                <a onclick="deletarServico(this)" href="#"><img class="img-icon" id="lixo-icon" src="../img/lixo.svg" alt=""></a>

          </div>
        </div>`
          }
          

        }
          
        
    } catch (error) {
        console.error(error);
    }
  }


  function deletarServico(el) {
    el.parentElement.parentElement.parentElement.remove();
  }
  


  async function getServicosDisponiveis() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/servicos`, {
          method: 'GET',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        const data = await rawResponse.json();
        console.log(data);
    } catch (error) {
        console.error(error);
    }
  }



