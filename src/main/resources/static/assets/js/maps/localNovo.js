pais.addEventListener("onmouseout", ativaLatitudeLongitude);

function ativaLatitudeLongitude() {
	let endereco = document.getElementById('endereco');
	const valorEndereco = endereco.value; //Coleta o valor 
	console.log(valorEndereco);
	
	let cidade = document.getElementById('cidade');
	const valorCidade = cidade.value;
	console.log(valorCidade);
	
	let pais = document.getElementById('pais');
	const valorPais = pais.value;
	console.log(valorPais);
	
	
	const request = new XMLHttpRequest()
	const url = `http://api.positionstack.com/v1/forward?access_key=1e01f5c97d2859d96fc3d8cbb723c3e5&query= ${valorEndereco}, ${valorCidade}, ${valorPais}`;
	
	console.log(url)
	request.open(
	  'GET',
	  url
		// Exemplo URL forward (busca pelo endereço) - http://api.positionstack.com/v1/forward?access_key=1e01f5c97d2859d96fc3d8cbb723c3e5&query= Avenida Doutor Laerte Setubal 610, São Paulo, Brazil'
		//Exemplo URF reverse (busca pela latitude) -'http://api.positionstack.com/v1/reverse?access_key=1e01f5c97d2859d96fc3d8cbb723c3e5&query= -23.620438756102672, -46.73192466520103'
	)
	
	request.send()
	request.onload = () => {
	  console.log(request)
	  if (request.status == 200) {
			const dados = JSON.parse(request.response); //Converte o JSON(request.response) para um Array(dados)
			let latitude = dados["data"]["0"]["latitude"];
			let longitude = dados["data"]["0"]["longitude"];
			
			console.log(latitude);
			console.log(longitude);
			
			
			document.getElementById('latitude').value=latitude;
			document.getElementById('longitude').value=longitude;
		
	  } else {
	    console.log(`error ${request.status} ${request.statusText}`)
	  }
	}
	
	
}


















