var usuario = localStorage.getItem("usuario")
var idUsuario = localStorage.getItem("idUsuario")
var dataStorage

document.addEventListener("DOMContentLoaded", function() {
    // code to be executed when the DOM is ready
    getServicosDisponiveis()
}) 

var selectedValue
var nomeServico
var idAgendamentoAgora

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


      sendDataToAPI(idAgendamentoAgora, formattedDate, hora, idUsuario, selectedValue)
      
      

    }

})




const select = document.getElementById("selecionar-servico");
select.addEventListener("change", function(){
  selectedValue = select.value;
  console.log(selectedValue)
  dataAgendamento = document.getElementById("data")
  horaAgendamento = document.getElementById("hora")

  for (let index = 0; index < dataStorage.length; index++) {
    const element = dataStorage[index];

    if(element.servico.idServico == selectedValue){
        const dataSplit = element.data.split("/")
        idAgendamentoAgora = element.idAgendamento
        horaAgendamento.value = `${element.hora[0]}:${element.hora[1]}`
        dataAgendamento.value = `${dataSplit[2]}-${dataSplit[1]}-${dataSplit[0]}`
    }

  }

});



async function sendDataToAPI(idAgendamentoAgora ,formattedDate, hora, idUsuario,selectedValue) {


  try {
      const rawResponse = await fetch('http://localhost:8080/agendamento', {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({idAgendamento:idAgendamentoAgora ,data:formattedDate, hora:hora, usuario:{idUsuario:idUsuario}, servico:{idServico:selectedValue} })
      });
      const content = await rawResponse.json();
      if(rawResponse.status == 202){
        window.alert("agendamento editado com sucesso!")
      }

      console.log(content);
    }catch (error) {
      console.error(error);
}}



async function getServicosDisponiveis() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/agendamento/usuario/${idUsuario}`, {
          method: 'GET',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        });
        dataStorage = await rawResponse.json();
        console.log(dataStorage);

        if(rawResponse.status == 200){
            selecionarServico = document.getElementById("selecionar-servico")

                for (let index = 0; index < dataStorage.length; index++) {
                  const element = dataStorage[index];
                  selecionarServico.innerHTML += `<option value="${element.servico.idServico}">${element.servico.nome}</option> `               
        }

    }
    } catch (error) {
        console.error(error)}}