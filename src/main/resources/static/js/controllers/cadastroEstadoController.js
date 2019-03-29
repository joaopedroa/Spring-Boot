app.controller("cadastroEstadoCtrl",function($scope,PersistService){
	$scope.form = {};
	$scope.teste = 'fasdkfnasdjklfnasdknfasd';
	
	$scope.form.salvarEstado = function(){
		if($scope.frmCadastroEstado.$valid){
			PersistService.salvarEstado($scope.form.estado).then(data =>{
				if(data){
				alert("Estado " + data.data.nomeEstado + " salvo com sucesso");
				}
				listarEstados();
			});
		}else{
			alert("Campo Estado Obrigtório");
		}
	}
	
	function listarEstados(){
		PersistService.buscarTodosEstados().then(data =>{
			$scope.listaEstados = data.data;
		});
	}
	
	listarEstados();
	
});