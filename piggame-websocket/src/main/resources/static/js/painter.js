(function(){
	//定义画板对象
  var Painter = {
    //绑定的环境上下文
    ctx:null,
	//宽度
	w:0,
	//高度
	h:0,
	//状态-1:初始或结束状态，0:开始画,1:画画中
	status:0,
	//当前画笔颜色
	bColor:null,
	//当前画笔大小
	bWidth:null,
	//初始化
    init:function()
	{
	  var can = $("#canvas1")[0];
	  this.ctx = can.getContext("2d");
	  this.w = can.width;
	  this.h = can.height;
	  this.setBGColor();
	  this.setBrushColor();
	  this.setBrushWidth();
	  this.ctx.lineCap = "round";
	  this.ctx.lineJoin = "round";
	  //初始化画板事件
	  this.initCanvas();
	  //初始化画笔颜色
	  this.initBrush();
	   //初始化橡皮擦
	  this.initEraser();
	},
	//初始化画笔
    initBrush:function()
    {
	  var bColor = $("#bColor"),
	      self = this;
      //产生颜色层
		bColor.change(function () {
			self.fire("onPaintUpdate",{"color":bColor.val()});
        })
	  //绑定画笔大小
      var bWidth = [2,8,16,24];
	  var bWidthSelect = $("#bWidth");
	  for(i = 0;i<bWidth.length;i++)
	  {
	    var bw = $("<option value='"+bWidth[i]+"'>"+bWidth[i]+"</option>");
	    bWidthSelect.append(bw);
	  }
        //修改画笔大小
        bWidthSelect.on("change",function(){
            //触发更新画板状态事件
            self.fire("onPaintUpdate",{"width":bWidthSelect.val()});
        });
	}, 
     //初始化橡皮擦
    initEraser:function()
	{
	 var self = this;
      //绑定清除屏幕事件
     $("#btnClear").click(function(){
	   self.clear();
      });
     //擦除
     $("#btnRub").click(function(){
	   self.setBrushColor("white");
       self.setBrushWidth(32);
      });
	},
	//设置背景颜色
    setBGColor:function(color){
      this.ctx.fillStyle = color||"white";
	  this.ctx.fillRect(0,0,this.w,this.h);
	},
	//设置画笔颜色
    setBrushColor:function(color)
	{
	  this.bColor = color||"black";
	  this.ctx.strokeStyle = this.bColor;	  
	},
	//设置画笔宽度
	setBrushWidth:function(width)
	{
	  this.bWidth = width||2;
	  this.ctx.lineWidth = this.bWidth;
	},
	//初始化画板
	initCanvas:function()
	{
      var can = $("#canvas1"),
	      self = this;
	  //绑定鼠标按下时间
	  can.on("mousedown",function(e){
	     e.preventDefault();
	     this.x = e.offsetX,
		 this.y = e.offsetY;
	     self.fire("onStartDraw",{"x":this.x,"y":this.y});
		 //绑定鼠标移动事件
		 can.on("mousemove",function(e){
		    var nx = event.offsetX,
			    ny = event.offsetY;
			self.fire("onDrawing",{"x":nx,"y":ny});
			this.x = nx;
			this.y = ny;
		 });
         //绑定鼠标抬起事件
		 can.on("mouseup",function(){
		    //取消鼠标移动事件
		    can.off("mousemove");
			//触发绘画完毕
		    self.fire("onDrawEnd");
		 });
	  })
	},
	//清除canvas
	clear:function()
	{
      this.ctx.clearRect(0,0,this.w,this.h);
      //TODO 发送清除画板的消息
	},
	//触发画板事件
	fire:function(eventName,param)
	{
	  if(this[eventName])
	  {
	    this[eventName](param);
	  }	  
	},
	//开始画画事件
    onStartDraw:function(data){
       this.status = 0;	  
	   //开始路径
	   this.ctx.beginPath();
	   this.ctx.moveTo(data.x,data.y);
	   //TODO 给服务器发送消息(鼠标开始按下的点)
	},
    //画画事件
	onDrawing:function(data)
	{
	   if(this.status == 0)
	   {
	     this.status = 1;
	   }
	   this.ctx.lineTo(data.x,data.y);
	   this.ctx.stroke();
	   //TODO 给服务器发送消息(鼠标移动的点)
	},
	//绘画完毕事件
	onDrawEnd:function()
	{
	   this.status = -1;
	},
	//画板更新事件，当画板的参数比如画笔颜色，大小改变时触发
	onPaintUpdate:function(data)
	{
	  var w = data.width||this.bWidth,
	      c = data.color||this.bColor;
	  var param = {"width":w,"color":c};
	  this.setBrushWidth(w);
	  this.setBrushColor(c);	  
	  //TODO 发送画板更新事件(修改画笔信息)
	}
  }
   //画板初始化
  Painter.init();
  window.Painter = Painter;
}())