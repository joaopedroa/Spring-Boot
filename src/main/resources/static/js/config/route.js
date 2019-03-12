app.config(function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: '/views/clientes.html',
		controller: 'indexController'
	});
	$routeProvider.when('/cadastroClientes',{
		templateUrl: '/views/cadastroClientes.html',
		controller: 'indexController'
	});
	// caso nao encontre nenhuma rota
	$routeProvider.otherwise({redirectTo: "/views/clientes.html"})
	
});