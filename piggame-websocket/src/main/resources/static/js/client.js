(function () {
    var Client = {
        stompClient:null,
        isFirstConnect:true,
        //当前用户
        user:null,
        userMessage:[],
        systemMessage:[],
        roomMessage:[],
        canvasMessage:[],
    }

    Client.connect = function (host) {
          var  self = this;
        if(this.stompClient == null){
            var socket = new SockJS(host);
            this.stompClient = Stomp.over(socket);
            if (this.stompClient){
                this.stompClient.connect({},function (frame) {
                    //TODO
                })
            }
        }
    }
    Client.doConnect = function () {
        //如果是第一次连接，注册事件
        if (this.isFirstConnect){
            this.isFirstConnect = false;
            this.binEvent();
        }
    }
    //绑定客户端socket事件
    Client.bindEvent = function () {
        var self = this;
        //消息事件
        self
    }

}())