// **********************************************//
// 登录用户 客户端脚本
//
//
// @author superliu
// @date 2019年03月02日 09:48
// **********************************************//
new Vue({
    el: '#app',
    data: function () {
        return {
            theme: "light",
            breadcrumbdata: [{
                name: "首页",
                href: "/home",
                icon: "ios-home-outline"
            }, {
                name: "个人中心",
                href: "/info",
                icon: "android-person"
            }, {
                name: "退出",
                href: "/logout"
                // icon: "android-settings"
            }],
            user:{
                R_Name: name,
                R_id: id,
                select: '',
                R_Gender: gender
            }
        }
    },
    methods: {
        select: function (code) {
            if (code == 1) Artery.open("/info");
            else if (code == 2) Artery.open("/info/update");
        },


    }


});

