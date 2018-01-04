angular.module('5uzhe').controller('HomeSliderController', function($rootScope, $scope, $modal, ApiHelper, ApiKeyConst, AppConfig, CommonSvc) {

    var loadData = function() {
        ApiHelper.queryList(ApiKeyConst.HomeSliderList, { wrapper: 'true' }).then(function(data) {
            $scope.data = data;
        });
    }

    $scope.showAddWindow = function(id) {
        var simpleForm = $modal.open({
            templateUrl: 'tpls/modals/home-slider-detail.html',
            controller: 'HomeSilderDetailController',
            size: 'lg',
            backdrop: false,
            keyboard: false,
            resolve: {
                params: function() {
                    return { id: id };
                }
            }
        });
        simpleForm.result.then(function(data) {
            deferred.resolve(data);
        }, function(e) {
            deferred.reject(e);
        });
    }

    loadData();
});