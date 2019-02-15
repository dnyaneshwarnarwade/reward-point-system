/**
 * 
 */

app.service('UserService',['$http', function ($http) {
     
    this.saveUser = function saveUser(user){
        return $http({
          method: 'POST',
          url: 'user',
          params: {email:user.email, password:user.password, 
            name:user.name, age:user.age},
          headers: 'Accept:application/json'
        });
    }
     
    this.getUsers = function getUsers(){
        return $http({
          method: 'GET',
          url: 'users',
          headers:'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
 
}]);