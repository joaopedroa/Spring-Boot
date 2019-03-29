app.controller("indexController",function($scope,$http,PersistService,$location){
	
	$scope.clientes = [];
	$scope.cliente = {};
	
	
	$scope.listarTodosClientes = function(){
		PersistService.buscarTodosClientes().then(response =>{
			$scope.clientes = response.data;
		});
	}
	
	$scope.inserirCliente = function(){
		
		if($scope.formCadastrarCliente.nome.$valid){
			PersistService.salvarCliente($scope.cliente).then(response =>{
				$scope.clientes.push(response.data);
				$scope.formCadastrarCliente.$setPristine();
			});
			$scope.cliente = {};
			window.location.href = "/";
		}else{
			alert("Campo Obrigatório não preechido.")
		}
	}
	
	$scope.deletarCliente = function(cliente,index){
		PersistService.deletarCliente(cliente.id).then(response=>{			
			alert("Cliente " + cliente.nome +   " Deletado");
			$scope.clientes.splice(index,1);
		});
	}
	
	$scope.alterarCliente = function(cliente){
		if($scope.clienteEdit.nome){
			PersistService.editarCliente(cliente).then(response=>{
				alert("Cliente " + response.data.nome +   " Alterado");
				$scope.clientes[$scope.positionArrayClienteEdit] = response.data;
				document.getElementsByClassName('close')[0].click();
			});
		}else{
			alert("Campo Obrigatório não preechido.");
		}
	}
	
	$scope.abrirModal = function(cliente,index){
		$scope.clienteEdit = angular.copy(cliente);		
		$scope.positionArrayClienteEdit = index;
	}
	
	function listarTodosEstados(){
		PersistService.buscarTodosEstados().then(data =>{
			$scope.listaEstados = data.data;
			$scope.cliente.estado = data.data[0];
		});
		
	}

	$scope.listarTodosClientes();
	listarTodosEstados();
	
	
});