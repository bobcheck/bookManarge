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
            userdto: {
                oldPassword: '',
                newPassword: '',
                newPassword2: ''
            },
            rules: {
                oldPassword: [{
                    required: true,
                    message: '请输入您的原密码',
                    trigger: 'blur'
                }, {
                    type: 'string',
                    min: 8,
                    message: '不得少于8个字符',
                    trigger: 'blur'
                }],
                newPassword: [{
                    required: true,
                    message: '请输入您的旧密码',
                    trigger: 'blur'
                }, {
                    type: 'string',
                    min: 8,
                    message: '不得少于8个字符',
                    trigger: 'blur'
                }],
                newPassword2: [{
                    required: true,
                    message: '请再一次输入新密码',
                    trigger: 'blur'
                }, {
                    type: 'string',
                    min: 8,
                    message: '不得少于8个字符',
                    trigger: 'blur'
                }]
            }
        }
    },
    methods: {
        select: function (code) {
            if (code == 1) Artery.open("/info");
            else if (code == 2) Artery.open("/info/update");
        },
        submit: function (name) {
            var _this = this;
            this.$refs[name].submit('/info/doUpdate').then(function (result) {
                if (result.code == 200) {
                    Artery.message.success(result.message);
                    window.setTimeout(function () {
                        window.location = '/index';
                    }, 1000);
                } else {
                    Artery.message.error(result.message);
                }
            }).catch(function (error) {
                Artery.message.error(error.message);
            });
        }
    }
});