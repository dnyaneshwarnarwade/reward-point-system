var app = angular.module("ConsumerRegistration", []);
 
// Controller Part
app.controller("ConsumerController", function($scope, $http) {
 
    $scope.consumer = [];
    $scope.consumerForm = {
        comment: "",
        firstName: "",
        lastName: "",
        phone: "",
        email:"",
        location:"",
        dob:""
    };
    // Now load the data from server
    //_refreshEmployeeData();
   // getUserProduct();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitConsumer = function() {
    	debugger;
    	console.log('form::'+angular.toJson($scope.consumerForm));
    	alert('submit()');
 
        $http({
            method: "POST",
            url: "/createConsumer",
            data: angular.toJson($scope.consumerForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/consumer/' + consumer.consumerId
        }).then(_success, _error);
    };
 
    // In case of edit
    /*$scope.editEmployee = function(consumer) {
        $scope.consumerForm.comment = consumer.comment;
        $scope.consumerForm.firstName = consumer.firstName;
        $scope.consumerForm.lastName = consumer.lastName;
        $scope.consumerForm.phone = consumer.phone;
        $scope.consumerForm.email = consumer.email;
        $scope.consumerForm.country = consumer.country;
        $scope.consumerForm.state = consumer.state;
        $scope.consumerForm.city = consumer.city;
        $scope.consumerForm.pinCode = consumer.pinCode;
        $scope.consumerForm.address = consumer.address;
        $scope.consumerForm.dob = consumer.dob;
    };*/
 
    // Private Method  
    // HTTP GET- get all consumer collection
    // Call: http://localhost:8080/consumer
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
    	console.log('user register successfully::'+res.data);
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) { 
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.consumerForm.comment= "",
        $scope.consumerForm.firstName=  "",
        $scope.consumerForm.lastName= "",
        $scope.consumerForm.phone= "",
        $scope.consumerForm.email="",
        $scope.consumerForm.location="",
        $scope.consumerForm.dob=""
    };
    
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