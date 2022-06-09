# Cadastro-Traveller

APIs UTILIZADAS

- Google Mpas API:
      Utilizamos esta API do Google Maps para gerar um mapa em nosso site, onde com ele, você pode visualizar o endereço dos locais cadastrados em nosso site.
      (OBS: você pode estar vizualizando seu funcionamento na parte de Gastronomia>DJapa-vermais>Informações)
      
- Positionstack API:
    Utilizamos esta API no momento em que os usuários vão realizar o cadastro de um novo local em nosso site. Els funciona da seguinte maneira.
     
     1. O usuário preenche os dados para cadastro;
     2. Após ele informar o endereço do local, a API gera um request onde é retornado os valores da Latitude e Longitude do local.

     O motivo para utilizarmos esta API é para gerarmos esses dados informados acima, para salvarmos eles em nosso Banco de Dados, e quando passarmos estes locais cadastrados ao site, já teremos todas as informações necessárias para mostrarmos seus endereços em nossos mapas gerados pelo Google Maps API.
