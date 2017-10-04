$(function(){
    
    this.init = function(){
        $(".detalhe").click(this.exibirDetalhes);
    };   
   
    this.exibirDetalhes = function(){ $("#content").load("/produtos/detalhe?id=" + $(this).attr("data-id")); };    
        
    this.init();    
});

