var App = angular.module('App',['ngRoute']);
           

App.config(['$routeProvider', function($routeProvider){
                $routeProvider
                .when('/',{
                	 templateUrl:'consumerSignUpPage.do',
                	 controller : "consumerCtrl as cc"
                })
                .when('/product.add',
                		{templateUrl:'product.add'
                })
                .when('/product.view',
                		{template:'No product view page is configured...'
                })
                .when('/user.subscription',{
                	templateUrl:'user.subscription'
                }).when('/users',{
                	templateUrl:'users'
                }).when('/add.reward',{
                	templateUrl:'add.reward'
                }).when('/add.social.media.rule',{
                	templateUrl:'add.social.media.rule'
                }).when('/user.points.details',{
                	templateUrl:'user.points.details'
                }).when('/view.earning.rule',{
                	templateUrl:'view.earning.rule'
                }).when('/consumerSignUpPage.do',{
                	templateUrl:'consumerSignUpPage.do',
                	controller : "consumerCtrl as cc"
                })
                .otherwise({redirectTo:'/'});
            }]);




'use strict';            

App.controller('consumerCtrl',  function($scope, $http) {
	$scope.message = 'User Registration';
});