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

let botao = document.getElementById("cadastro-servico")

botao.addEventListener("click", function(event){
   
    let nomeServico = document.getElementById("nome").value
    let descricaoServico = document.getElementById("descricao").value
  
    sendDataToAPI(selectedValue, nomeServico, descricaoServico)
      
   event.preventDefault()

    })






const select = document.getElementById("selecionar-servico");
select.addEventListener("change", function(){
  selectedValue = select.value;
  console.log(selectedValue)
  let nome = document.getElementById("nome")
  let descricao = document.getElementById("descricao")
    console.log(selectedValue)
   

    for (let index = 0; index < dataStorage.length; index++) {
        const element = dataStorage[index];
        if(element.idServico == selectedValue){
           nome.value = element.nome
           descricao.value = element.descricao 
        }

     

}});



async function sendDataToAPI(selectedValue ,nomeServico, descricaoServico) {


  try {
      const rawResponse = await fetch( `http://localhost:8080/servico/${selectedValue}`, {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({nome:nomeServico, descricaoServico:descricaoServico })
      });
      console.log(rawResponse.status)
      if(rawResponse.status == 202){
        window.alert("servico editado com sucesso!")
        window.location.reload()
      }

    }catch (error) {
      console.error(error);
}}



async function getServicosDisponiveis() {
    try {
        const rawResponse = await fetch(`http://localhost:8080/servico/usuario/${idUsuario}`, {
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
                  selecionarServico.innerHTML += `<option value="${element.idServico}">${element.nome}</option> `               
        }

    }
    } catch (error) {
        console.error(error)}}