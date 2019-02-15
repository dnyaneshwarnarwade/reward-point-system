


var app = angular.module("productModule", ["ngRoute"]);
 


app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/"
    })
    .when("/manageProduct", {
        templateUrl : "/manageProduct"
    })
    .when("/green", {
        templateUrl : "/product/subCategoryForm.html"
    });
});


// Controller Part
app.controller("productController", function($scope, $http) {
 
    $scope.consumer = [];
    $scope.userForm = {
    	productCategories: "",
    	productName: "",
    	SKU:"",
    	price:"",
    	Desc:"",
    	osd:"",
    	oed:"",
    	discount:"",
    	offerTitle:"",
    	isEnableReward:"",
    	applyRewardConfig:"",
    	redemPoint:""
    	
    };
    // Now load the data from server
    //_refreshEmployeeData();
    //getUserProduct();	
 
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
    	if(data.phone == ''){
    		alert('please enter your contact number');
    		return false;
    	}
    	
    	return true;
    }
    
    
    $scope.submitConsumer = function() {
    	var data = angular.toJson($scope.userForm);
    	console.log('form::'+angular.toJson($scope.userForm));
    	debugger;
        $http({
            method: "POST",
            url: "/consumerSignUp.do",
            data: data,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/consumer/' + consumer.consumerId
        }).then(_success, _error);
    };
 
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/getAllConsumer'
        }).then(
            function(res) { // success
            	console.log(res.data);
                $scope.consumer = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
    	debugger;
    	$scope.messages = res.data.message;
    	console.log('user register successfully::'+res.data);
//      _refreshEmployeeData();
//        _clearFormData();
    }
 
    function _error(res) { 
        var data = res.data.message;
    }
 
    // Clear the form
    /*function _clearFormData() {
        $scope.consumerForm.name= "",
        $scope.consumerForm.phone= "",
        $scope.consumerForm.email="",
    };*/
    
    function getUserProduct(){
    	$http({
            method: 'GET',
            url: '/getAllProductsB.U.I' 
        }).then(
            function(res) { // success
            	console.log(res.data);
                $scope.products = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    var tableData = [];
    $scope.addIntoTable = function(product){
    	var products = new Object();
    	products['name'] = product.name;
    	console.log('product.price::'+product.productDetail.price);
    	products['price'] = product.productDetail.price;
    	products['gst'] = product.productDetail.tax.gst;
    	products['cgst'] = product.productDetail.tax.cgst;
    	products['sgst'] = product.productDetail.tax.sgst;
    	products['discount'] = product.productDetail.productDescount.discount;
    	tableData.push(products); 
    	$scope.productDetails = tableData;
    	
    	var totalPrice=0;
    	var totalGST=0;
    	var totalGCST=0;
    	var totalSGST=0;
    	var totalDiscount=0;
    	for(var i =0; i < tableData.length; i++){
    		totalPrice = parseFloat(totalPrice) + parseFloat(tableData[i].price);
    		totalGST = parseInt(totalGST) + parseInt(product.productDetail.tax.gst);
    		totalGCST = parseInt(totalGCST) + parseInt(product.productDetail.tax.cgst);
    		totalSGST = parseInt(totalSGST) + parseInt(product.productDetail.tax.sgst);
    		totalDiscount = parseInt(totalDiscount) + parseInt(product.productDetail.productDescount.discount);
    	}
    	$scope.total = totalPrice.toFixed(2);
    	$scope.totalGST = totalGST;
    	$scope.totalCGST = totalGCST;
    	$scope.totalSGST = totalSGST;
    	$scope.totalDiscount = totalDiscount;
    }
    
    $scope.consumerSearch = function(){
    	var searchString = $scope.consumerForm.search;
    	$http({
            method: 'GET',
            url: '/searchCMR/'+searchString 
        }).then(
            function(res) { // success
            	console.log(res.data);
                $scope.products = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
});