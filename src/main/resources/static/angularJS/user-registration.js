
var app = angular.module("UserRegistration", []);
 

// Controller Part
app.controller("UserController", function($scope, $http) {
	$("#showMessagesDiv").hide();
	$scope.title = 'Create a new Account';
    $scope.userForm = {
    	name: "",
        email:"",
        usrps:""
    };
 
    $scope.validateConsumer = function(data) {
    	debugger;
    	if(data.name == ''){
    		alert('please enter firstName');
    		return false;
    	}
    	if(data.email == ''){
    		alert('please enter email');
    		return false;
    	}
    	if(data.usrps == ''){
    		alert('please enter password');
    		return false;
    	}
    	if(data.usrps != data.confirmPassword){
    		$('.confirmPass').html('Password & confirm password must be same');
    		return false;
    	}
    }
    
    
    $scope.submitConsumer = function() {
    	console.log('form::'+angular.toJson($scope.userForm));
    	angular.element(document.querySelector("#loader")).removeClass("hidden");
    	$("#spinner").show();
    	debugger;
        $http({
            method: "POST",
            url: "/signUp",
            data: angular.toJson($scope.userForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
    
    function _success(res) {
    	$("#showMessagesDiv").show();
    	$scope.successMessage = res.data.message;
    	angular.element(document.querySelector("#loader")).addClass("hidden");
    	angular.element(document.querySelector("#failed-icon")).addClass("hidden");
    	angular.element(document.querySelector(".si")).removeClass("hidden");
    	_clearFormData();
    }
 
    function _clearFormData(){
    	$scope.userForm = {
    			name: '',
    			email:'',
    			usrps:'',
    	};
    }
    function _error(res) {
    	$("#spinner").hide();
    	$scope.title = 'Registration Failed ...';
    	$("#loader").hide();
    	$("#success-icon").hide();
    	$("#failed-icon").show();
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
    }
    
    
});