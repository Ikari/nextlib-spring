$(function(){
    
    this.init = function(){                
        $(".produto-up").click(this.adicionarAoCarrinho);
        $(".produto-down").click(this.subtrairAoCarrinho);
    };   
   
    this.adicionarAoCarrinho = function(){                         
        $.ajax({
            type: 'GET',
            url: '/carrinho/adicionar/' + $(this).data("id"),
            success : function(data){
                
            }
        }).done(function() {            
            location.reload();
        }).fail(function() {
            console.log("error");
        });
    };    
    
    this.subtrairAoCarrinho = function(){       
        
        console.log(1)
        
        $.ajax({
            type: 'GET',
            url: '/carrinho/subtrair/' + $(this).data("id"),
            success : function(data){
                
            }
        }).done(function() {
            location.reload();
        }).fail(function() {
            console.log("error");
        });
    };
        
    this.init();    
});

