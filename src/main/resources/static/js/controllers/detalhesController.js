app.controller("detalhesController",function($scope,$routeParams,PersistService){
	
	$scope.cliente ={};
	
	PersistService.buscarClientePorId($routeParams.id).then(data =>{
		$scope.cliente = data.data;
	})
	
	console.log('Parametros:',$routeParams);
});