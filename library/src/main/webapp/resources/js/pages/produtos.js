$(function(){
    
    this.init = function(){                
        $(".add-carrinho").click(this.adicionarAoCarrinho);
    };   
   
    this.adicionarAoCarrinho = function(){         
        $.ajax({
            type: 'GET',
            url: '/carrinho/adicionar/' + $(this).data("id"),
            success : function(data){
                
            }
        }).done(function() {
            alert("Produto adicionado com sucesso!");
        }).fail(function() {
            console.log("error");
        });
    };    
        
    this.init();    
});

