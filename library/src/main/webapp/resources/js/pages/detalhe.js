$(function(){
    
    this.init = function(){
        $(".adicionar").click(this.adicionarAoCarrinho);
    };   
   
    this.adicionarAoCarrinho = function(){ 
                
        var data = {};
        data["id"] = $(this).attr("data-id");
                
                console.log(data);
                
        $.ajax(
            {
                type: "POST",
                contentType:"application/json",
                url: "/adicionar-produto",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function(s){ console.log("sucesso"); },
                error: function(e){ console.log(e); }
            }
        );
    };    
        
    this.init();    
});