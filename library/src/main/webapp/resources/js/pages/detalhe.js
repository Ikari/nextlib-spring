$(function(){
    
    this.init = function(){
        $(".adicionar").click(this.adicionarAoCarrinho);
    };   
   
    this.adicionarAoCarrinho = function(){ 
                
        var data = {};
        data["id"] = $(this).attr("data-id");
                
        $.ajax(
            {
                type: "POST",
                contentType:"application/json",
                url: "/carrinho/adicionar",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function(data){ 
                    $("#content").load("/carrinho/#");
                },
                error: function(e){ console.log(e); }
            }
        );
    };    
        
    this.init();    
});