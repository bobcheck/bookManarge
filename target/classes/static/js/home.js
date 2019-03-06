var app = new Vue({
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
            book:{
                bk_id:null,
                bk_type:null,
                bk_name:null,
                bk_ISBN:null,
                bk_author:null,
                bk_price:null,
                bk_rest:null,
            },
            newbook:{
                bk_id:null,
                bk_type:null,
                bk_name:null,
                bk_ISBN:null,
                bk_author:null,
                bk_price:null,
                bk_rest:null,
                bk_publishData:null,
                bk_img:null,
            },
            reader:{
                b_id: null,
                b_name: null,
                b_rest: null,
                r_id: null,
                r_type:null,
                r_name:null,
                r_sex:null,
                r_major:null,
                r_rest:null,
                date: null,
            },
            value1:{},
            value:null,
            imgurl:null,
            rs1: [],
            parm: {
                tableId: "table11"
            },
            info:null,
            res:null,
            delbook:{
                bk_id:null
            },
            file: null,
            image: "#",
            base64Code: "",
            visiable: false
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

        handleUpload: function(f) {
            var _this = this;
            this.file = f;
            var reader = new FileReader();
            reader.readAsDataURL(f);
            reader.onload = function(e) {
                //把得到的base64赋值到img标签显示
                _this.base64Code = this.result;
                _this.image = this.result;
                _this.visiable = true;
            }
            return false;
        },
        freshen: function(){
            window.location.reload();
        },

        //图书新增
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
            var _this = this;
            console.log(this.newbook)
            this.$refs.form.getData(function(data) {
                _this.newbook.bk_img = _this.base64Code;
            });
            this.$refs.form.submit('demo8').then(function(result) {
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
            // setInterval(function () {
            //     window.location.reload();
            // },2000)
        },


        //修改按钮
        bj: function(url) {
            //Artery.stopEvent(this.onOk1());
            this.info=JSON.parse(JSON.stringify(url));
            this.book = JSON.parse(JSON.stringify(url));
            this.imgurl = "../img/"+url.bk_id+".jpg";
            this.$refs.modalWidiow2.open();
        },
        //删除按钮
        del:function(url){
            this.delbook.bk_id =  url.bk_id
            this.$refs.modalWidiow6.open();
        },
        onOk6:function(){
            this.$http.post('demo9',{
                params: this.delbook.bk_id
            }).then(function(res) {
                Artery.message.success("删除成功")
            });
            this.$refs.modalWidiow6.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },

        //图书修改
        onOk1: function() {
            // if(this.book.bk_rest==0){
            //     Artery.message.error("该书籍已借完，请重新选择")
            // }else{}
            this.$refs.modalWidiow3.open();
        },
        oncancel: function() {
            // var user = this.book;
            // Artery.message.info("请求参数 " +
            //     "<br> 姓名：" + user.bk_id);
            this.book=this.info;
        },
        onOk2: function() {
            //Artery.message.success("点击了确认按钮")
            this.$refs.form.submit('demo3').then(function(result) {
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

        //图书借阅
        readerselcansel: function(){
            this.value = null
        },

        readersel:function(){
            var _this = this;
            this.$http.post('demo4',{
                params: this.value
            }).then(function(res) {
                _this.reader.r_id = res[0].r_id;
                _this.reader.r_type = res[0].r_type;
                _this.reader.r_name = res[0].r_name;
                _this.reader.r_sex = res[0].r_sex;
                _this.reader.r_major = res[0].r_major;
                _this.reader.r_rest = res[0].r_brNum;
            });
            this.$refs.modalWidiow5.close();
        },
        selreaderinfo: function(){
            this.$refs.modalWidiow5.open();
        },
        jy: function(url) {
            if(url.bk_rest<=0){
                Artery.message.error("该书籍已借完，请重新选择");
            }else {
                this.reader.b_id = url.bk_id;
                this.reader.b_name = url.bk_name;
                this.reader.b_rest = url.bk_rest;
                this.imgurl = "../img/"+url.bk_id+".jpg";
                this.$refs.modalWidiow22.open();
            }
        },
        onOk11: function() {
            // if(this.book.bk_rest==0){
            //     Artery.message.error("该书籍已借完，请重新选择")
            // }else{}
            if(this.reader.r_rest<=0){
                Artery.message.error("该用户达到最大借书数")
            }else{
                this.$refs.modalWidiow33.open();
            }
        },
        oncancel1: function() {
            // this.reader.r_id = null;
            // this.reader.r_type=null;
            // this.reader.r_name=null;
            // this.reader.r_sex=null;
            // this.reader.r_major=null;
            // this.reader.r_rest=null;
            // this.reader.date= null
        },
        onOk22: function() {
            console.log(this.reader);
            var _this = this
            this.$refs.form.submit('demo5').then(function(result) {
                if (result.success) {
                    Artery.message.success('借阅成功');
                } else {
                    Artery.message.error('借阅失败');
                }
            }).
            catch (function(error) {
                Artery.message.error("发送请求出错，错误信息是:" + JSON.stringify(error));
            });
            this.value = null;
            this.$refs.modalWidiow33.close();
            this.$refs.modalWidiow22.close();
            setInterval(function () {
                window.location.reload();
            },1000)
        },

        //图书查询
        loadData: function(queryInfo) {
            var _this = this;
            Artery.loadPageData('demo1', queryInfo, this.parm)
                .then(function(data) {
                    // console.log(data);
                    _this.rs1 = data;
                    //console.log(data);
                }).
            catch (function(error) {
                console.error(error);
            });
        }

    }
});