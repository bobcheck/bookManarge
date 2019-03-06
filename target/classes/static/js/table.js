/*
显示普通的表格
new Vue({
    el:'#app',
    data: function () {
        return {
            rs1:[]
        }
    },
    methods:{
        loadData: function () {
            var _this = this;
            Artery.ajax.get('/users/test').then(function (data) {
                _this.rs1 = data;
            }).catch(function (error) {
                console.error(error);
            });
        }
    },
    created: function () {
        this.loadData();
    }
});*/
/*
//含有后台排序的表格
new Vue({
    el:'#app',
    data: function () {
        return {
            rs1:[]
        }
    },
    methods:{
        loadData: function () {
            var _this = this;
            Artery.ajax.get('/users/sort').then(function (data) {
                _this.rs1 = data;
            }).catch(function (error) {
                console.error(error);
            });
        },
        sortData:function (opt) {

        },
        loadSortData: function (queryInfo) {
            var _this = this;
            Artery.loadPageData('/users/sort1', queryInfo).then(function (data) {
                _this.rs1 = data;
            }).catch(function (error) {
                console.error(error);
            })
        }
    },
    created: function () {
        this.loadData();
    }
});*/

//分页的形式展示数据
new Vue({
    el:'#app',
    data: function () {
        return {
            rs1:[]
        }
    },
    methods:{
        loadData: function (queryInfo) {
            var _this = this;
            Artery.loadPageData('/users/Pagination', queryInfo).then(function (data) {
                _this.rs1 = data;
            }).catch(function (error) {
                console.error(error);
            });
        }
    },
    created: function () {
        this.loadData();
    }
});


