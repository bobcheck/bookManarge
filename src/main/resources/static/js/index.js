new Vue({

    el: '#loginform',
    data: function () {
        return {
            user:{
                R_Name: '',
                R_Pwd: ''
            },
            loginRule:{
                R_Name: [{
                    required: true,
                    message: '请输入用户名',
                    trigger: 'blur'
                }],
                R_Pwd: [{
                    required: true,
                    message: '请输入密码',

                    trigger: 'blur'

                }, {
                    type: 'string',
                    min: 8,
                    message: '请至少输入8位密码',
                    trigger: 'blur'
                }]
            }
        }
    },
    methods: {

        handleSubmit: function (name) {
            // 从外部引入否则会报错
            var _this = this;
            this.$refs[name].submit('/login').then(function (result) {
                if (result.code == 200){
                    Artery.message.success(result.message);
                    window.location = '/home';
                }
                else{
                    Artery.message.error(result.message);
                }
            }).catch(function (error) {
                Artery.message.error(error.message);
            });
        }
    }
});