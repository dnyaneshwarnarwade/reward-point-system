var app = angular.module("changePasswordApp", []);
 
// Controller Part
app.controller("UserController", function($scope, $http) {
 
    $scope.user = [];
    $scope.userForm = {
        oldPassword: "",
        newPassword:"",
        confirmPassword:"",
    };
   
    $scope.changeUserPassword = function() {
    	console.log('form::'+angular.toJson($scope.consumerForm));
    	alert('submit()');
 
        $http({
            method: "POST",
            url: "/changePassword.do",
            data: angular.toJson($scope.consumerForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
 
    function _success(res) {
    	console.log('user register successfully::'+res.data);
    }
 
    function _error(res) { 
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
    
  
    
    $scope.checkOldPassword = function(){
    	var searchString = $scope.userForm.oldPassword;
    	$http({
            method: 'GET',
            url: '/checkOldPassword/'+searchString 
        }).then(
            function(res) { // success
            	console.log(res.data);
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
});