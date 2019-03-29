app.service("PersistService", function($http){

	this.salvarCliente = function(cliente){
		return $http.post("http://localhost:8080/clientes",cliente);
	}
	
	this.buscarTodosClientes = function(){
		return $http.get("http://localhost:8080/buscarTodosClientes");
	}
	
	this.deletarCliente = function(idCliente){
		
		return $http.delete("http://localhost:8080/excluirCliente/" + idCliente);
	}
	
	this.editarCliente = function(cliente){
		return $http.put("http://localhost:8080/alterarCliente",cliente);
	}
	
	this.buscarClientePorId = function(id){
		return $http.get("/buscarCliente/" + id);
	}
	
	this.salvarEstado = function(estado){
		return $http.post("http://localhost:8080/salvarEstado",estado);
	}
	
	this.buscarTodosEstados = function(){
		return $http.get("/buscarTodosEstados");
	}

	

});