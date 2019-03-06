var registerForm = new Vue({
    el: '#modifyForm',
    data: function () {
        return {
            user: {
                username: '',
                password: ''

            },
            modifyRule:{
                username:[{
                    required: true,
                    message: '请输入用户名',
                    trigger: 'blur'
                },{
                    type: 'string',
                    min: 1,
                    message: '用户名不能为空',
                    trigger: 'blur'
                }],
                password:[{
                    required: true,
                    message: '请输入您的密码',
                    trigger: 'blur'
                },{
                    type: 'string',
                    min: 8,
                    message: '请至少输入8位密码',
                    trigger: 'blur'
                }]
            }
        }
    },
    methods:{
        handleSubmit: function (name) {
            var _this = this;
            this.$refs[name].submit('/register').then(function (result) {
                if (result.code == 200){
                    Artery.message.success(result.message);
                    window.location = '/index';
                } else{
                    Artery.message.error(result.message);
                }
            }).catch(function (error) {
                Artery.message.error(error.message);
            });
        }

    }
});