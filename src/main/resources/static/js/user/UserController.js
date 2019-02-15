/**
 * 
 */

app.controller('UserCtrl', ['$scope','UserService', function ($scope,UserService) {
     
    $scope.submitted = false;
     
    $scope.getUsers = function() {
           UserService.getUsers().then(function(data) {
               $scope.users = data;
           });
       }
     
    $scope.saveUser = function() {
        $scope.submitted = true;
          if ($scope.userForm.$valid) {
            UserService.saveUser($scope.user)
              .then (function success(response) {
                  $scope.message = 'User added!';
                  $scope.errorMessage = '';
                  $scope.getUsers();
                  $scope.user = null;
                  $scope.submitted = false;
              },
              function error(response) {
                  if (response.status == 409) {
                    $scope.errorMessage = response.data.message;
                  }
                  else {
                    $scope.errorMessage = 'Error adding user!';
                  }
                  $scope.message = '';
            });
          }
    }
    
   $scope.getUsers();
}]);