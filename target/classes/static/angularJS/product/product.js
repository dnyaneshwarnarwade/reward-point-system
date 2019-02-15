
var app = angular.module("product", []);
 

// Controller Part
app.controller("ProductController", function($scope, $http) {
	$scope.title = 'Add Product Info';
    $scope.productForm = {
    	sku: "",
    	category:"",
        productName:'',
        description:'',
        price:'',
        discount:'',
        isRewardEnabled:'',
        rewardPoints:''
    };
    
    $scope.addProduct = function() {
    	alert('add pro');
    	debugger;
    	console.log('form::'+angular.toJson($scope.productForm));
    	$("#loader").show();
    	debugger;
        $http({
            method: "POST",
            url: "/addProduct",
            data: angular.toJson($scope.userForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
    
    function _success(res) {
    	alert('add pro succ');
    	debugger;
    	console.log("respnse : "+res);
    	//$("#loader").hide();
    	//_clearFormData();
    }
 
    function _clearFormData(){
    	alert('add crear form');
    	$scope.userForm = {
    			sku: "",
    			category:"",
    	        productName:'',
    	        description:'',
    	        price:'',
    	        discount:'',
    	        isRewardEnabled:'',
    	        rewardPoints:''
    	};
    }
    function _error(res) {
    	alert('add errror');
    	angular.element(document.querySelector("#loader")).addClass("hidden");
    	angular.element(document.querySelector("#success-icon")).addClass("hidden");
    	angular.element(document.querySelector("#failed-icon")).removeClass("hidden");
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
    }
    
    
});