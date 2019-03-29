app.config(function($routeProvider,$locationProvider){
	$routeProvider.when('/',{
		templateUrl: '/views/clientes.html',
		controller: 'indexController'
	});
	$routeProvider.when('/cadastroClientes',{
		templateUrl: '/views/cadastroClientes.html',
		controller: 'indexController'
	});
	$routeProvider.when('/buscarCliente/:id',{
		templateUrl: '/views/detalhesCliente.html',
		controller: 'detalhesController'
	});
	$routeProvider.when('/cadastroEstados',{
		templateUrl: '/views/cadastroEstado.html',
		controller: 'cadastroEstadoCtrl'
	});
	// caso nao encontre nenhuma rota
	$routeProvider.otherwise({redirectTo: "/"})
	
	$locationProvider.html5Mode(true);
	
});