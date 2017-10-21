$(function(){
    
    this.init = function(){
        $("#tabs a").click(this.loadContent);
        $("#fase1").click();
    };   
   
    this.loadContent = function(){ 
        var a = $(this);
        $("#tabs li").removeClass("active").addClass("inactive");
        a.parent().removeClass("inactive").addClass("active");
        $("#content").load("/checkout/" + a.attr("id")); 
    };
        
    this.init();    
});

