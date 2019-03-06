new Vue({
    el:'#app',
    data: function() {
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
            }],
            rs1: [],
            user:{},
            parm: {
                tableId: "table8"
            },
            br:{
                b_id:null,
                b_name:null,
                r_id:null,
                r_name:null,
                r_sex:null,
                r_type:null,
                r_major:null,
                date:null
            },
            returnbook:{
                b_id:null,
                b_name:null,
                r_id:null,
                r_name:null,
                b_date:null,
                r_date:null
            },
        }
    },
    methods: {
        select: function(code) {
            if(code==1)Artery.open("/home");
            else if(code==2.1)Artery.open("/borrow");
            else if(code==2.2)Artery.open("/return");
            else if(code==3)Artery.open("/readerInfoSel");
            else if(code==4.1)Artery.open("/home");
            else if(code==4.2)Artery.open("/home");

        },
        freshen: function () {
            window.location.reload();
        },
        //双击进入还书界面
        jy: function (url) {
            this.returnbook.b_id = url.b_id;
            this.returnbook.b_name = url.b_name;
            this.returnbook.r_id = url.r_id;
            this.returnbook.r_name = url.r_name;
            this.returnbook.b_date = url.date;
            this.$refs.modalWidiow1.open();
        },
        onOk1: function(){
            this.$http.post('demo12',{
                params: this.returnbook
            }).then(function(res) {
                Artery.message.success("归还成功")
            });
            this.$refs.modalWidiow1.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },
        loadData: function (queryInfo) {
            //console.log(queryInfo);
            var _this = this;
            Artery.loadPageData('demo7', queryInfo, this.parm)
                .then(function (data) {
                    //console.log(data)
                    _this.rs1 = data;
                    //console.log(data);
                }).catch(function (error) {
                console.error(error);
            });
        }
    }
})