$(function(){
    
    this.init = function(){
        $("#tabs a").click(this.load);
        $("#save-and-continue").click(this.save);
        $("#1").click();
    };   
   
    this.load = function(){ 
        
        var a = $(this);
        
        $("#tabs li").removeClass("active").addClass("inactive");
        a.parent().removeClass("inactive").addClass("active");
        $("#content").load("/checkout/" + a.attr("id")); 
    };
    
    this.save = function(){
        
        var activeTab = $("#tabs li.active a");
                
        $.ajax(
            {
                method: "POST",
                //contentType:"application/json",
                url: "/checkout/etapa/" + activeTab.attr("id"),
                data: $("#form-checkout").serialize(),
                success: function(data){ 
                    
                    console.log(data);
                    $("#" + parseInt(activeTab.attr("id")) + 1).click();
                },
                error: function(e){ console.log(e); }
            }
        );        
    };
        
    this.init();    
});

