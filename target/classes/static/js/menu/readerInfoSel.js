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
            parm: {
                tableId: "table11"
            },
            reader:{
                r_id:null,
                r_type:null,
                r_name:null,
                r_sex:null,
                r_brNum:null,
                r_major:null,
                r_tel:null,
            },
            newreader:{
                r_id:null,
                r_type:null,
                r_name:null,
                r_sex:null,
                r_brNum:null,
                r_major:null,
                r_tel:null,
            },
            imgurl:'../images/1.jpg',
            info:null,
            delreader:null,
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
        freshen: function(){
            window.location.reload();
        },

        //读者新增
        addnew: function(){
            this.$refs.modalWidiow222.open();
        },
        onOk111: function() {
            // if(this.book.bk_rest==0){
            //     Artery.message.error("该书籍已借完，请重新选择")
            // }else{}
            this.$refs.modalWidiow333.open();
        },
        oncancel11: function() {
            // var user = this.book;
            // Artery.message.info("请求参数 " +
            //     "<br> 姓名：" + user.bk_id);
            // this.book=this.info;
        },
        onOk222: function() {
            //Artery.message.success("点击了确认按钮")
            this.$refs.form.submit('demo10').then(function(result) {
                if (result.success) {
                    Artery.message.success('新增成功');
                } else {
                    Artery.message.error('新增失败');
                }
            }).
            catch (function(error) {
                Artery.message.error("发送请求出错，错误信息是:" + JSON.stringify(error));
            });
            // this.newbook = null;
            this.$refs.modalWidiow333.close();
            this.$refs.modalWidiow222.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },
        //编辑
        bj: function(url) {
            this.info=JSON.parse(JSON.stringify(url));
            this.reader = JSON.parse(JSON.stringify(url));
            // this.imgurl = "../images/"+url.bk_id+".jpg";
            this.$refs.modalWidiow2.open();
        },

        //删除按钮
        del:function(url){
            this.delreader =  url.r_id
            this.$refs.modalWidiow6.open();
        },
        onOk6:function(){
            this.$http.post('demo11',{
                params: this.delreader
            }).then(function(res) {
                Artery.message.success("删除成功")
            });
            this.$refs.modalWidiow6.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },

        //读者信息修改
        onOk1: function() {
            this.$refs.modalWidiow3.open();
        },
        oncancel: function() {
            this.reader=this.info;
        },
        onOk2: function() {
            //Artery.message.success("点击了确认按钮")
            this.$refs.form.submit('demo6').then(function(result) {
                if (result.success) {
                    Artery.message.success('修改成功');
                } else {
                    Artery.message.error('修改失败');
                }
            }).
            catch (function(error) {
                Artery.message.error("发送请求出错，错误信息是:" + JSON.stringify(error));
            });
            this.$refs.modalWidiow3.close();
            this.$refs.modalWidiow2.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },
        loadData: function(queryInfo) {
            var _this = this;
            Artery.loadPageData('demo2', queryInfo, this.parm)
                .then(function(data) {
                    console.log(data);
                    _this.rs1 = data;
                    //console.log(data);
                }).
            catch (function(error) {
                console.error(error);
            });
        }
    }
})