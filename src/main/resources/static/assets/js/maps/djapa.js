///Cria uma chamada para o mapa com a localização indicada

function initMap() {
    ///Adicionar coordenadas de latitude e longitude do local para exibir no mapa da API
    const localDjapa= {
        lat: -23.598514599495882,
        lng: -46.66307058114528
    };
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 20, ///Seleciona o quão próximo ou distante ficará a visão do ponto indicado
        center: localDjapa ///Centraliza o mapa no ponto indicado
    });
    const marker = new google.maps.Marker({
        position: localDjapa, ///Coloca um marcador vermelho no ponto indicado
        map: map,
    });
}