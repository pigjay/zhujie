(function () {
    var userLogin = {
        username:null,
        login:function () {
            var self = this;
            $('#login').click(function () {
                var username = $('#username').val();
                var password = $('password').val();
                $.getJSON("/user/login",{username:username,password:password},function (data) {
                    console.log(data);
                    if(data){
                        $('#loginDiv').hide();
                    }
                })
            })
        }
    }
}())