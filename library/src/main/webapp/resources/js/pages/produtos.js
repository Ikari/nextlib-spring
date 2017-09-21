$(function(){
    
    this.init = function(){
        $(".detalhe").click(this.exibirDetalhes);
    };   
   
    this.exibirDetalhes = function(){ $("#content").load("/detalhe-produto?id=" + $(this).attr("data-id")); };    
        
    this.init();    
});

