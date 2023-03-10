var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")


document.addEventListener("DOMContentLoaded", function() {
    // code to be executed when the DOM is ready
    getServicosDisponiveis()
}) 

var selectedValue
var nomeServico

let botao = document.getElementById("agendar-nome")
botao.addEventListener("click", function(event){
  let data = document.getElementById("data").value
  let hora = document.getElementById("hora").value
  console.log(data)
  console.log(hora)
  let verificacaoData = document.getElementById("data-invalida")
  let verificacaoHora = document.getElementById("hora-invalida")
  var selectedDate = new Date(data);
  var currentDate = new Date();
  if(hora == undefined || hora == "" ){
    verificacaoHora.classList.remove("d-none")
    event.preventDefault();
  }
  if(data == undefined || data == "" || selectedDate.getTime() < currentDate.getTime()){
    verificacaoData.classList.remove("d-none")
    event.preventDefault();
  }
  else{
    var date = new Date(data);
    var formattedDate = (date.getDate()+1)+ "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
    sendDataToAPI(formattedDate, hora, idUsuario, selectedValue)
    event.preventDefault()
  }
    
})



const select = document.getElementById("selecionar-servico");
select.addEventListener("change", function(){
  selectedValue = String(select.value);
  console.log(selectedValue)
});



async function sendDataToAPI(data, hora, idUsuario,selectedValue) {
    
  try {
      const rawResponse = await fetch('http://localhost:8080/agendamento', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({data:data, hora:hora, usuario:{idUsuario:idUsuario}, servico:{idServico:selectedValue} })
      });
      const content = await rawResponse.json();
      if(rawResponse.status == 201){
        $("#sucessoModal").modal("show");
      }
    
      console.log(content);
    }catch (error) {
      console.error(error);
}}



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
        console.error(error)}}