var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")
form = document.getElementById("agendar-form")

form.addEventListener("submit", (e) => {
    e.preventDefault();
    getDataFromAPI();
})


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
        console.log(data);
    } catch (error) {
        console.error(error);
    }
  }

document.addEventListener("DOMContentLoaded", getAgendamentosPorId)



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



