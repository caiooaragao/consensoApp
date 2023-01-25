var usuario2 = localStorage.getItem("usuario")
form = document.getElementById("agendar-form")
var idUsuario = localStorage.getItem("idUsuario")
console.log(idUsuario)

form.addEventListener("submit", (e) => {
    e.preventDefault();
    getDataFromAPI();
})


async function getDataFromAPI() {
    try {
        const rawResponse = await fetch('http://localhost:8080/usuario', {
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




