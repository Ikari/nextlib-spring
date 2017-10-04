$(function(){
    
    this.init = function(){
        $("#cliente").click(this.cliente);
        $("#produto").click(this.produto);
        $("#produtos").click(this.produtos);
        $("#carrinho").click(this.carrinho);
    };   
   
    this.cliente = function(){ $("#content").load("/cliente"); };    
    this.produto = function(){ $("#content").load("/produtos/exibir"); };
    this.produtos = function(){ $("#content").load("/produtos/#"); };
    this.carrinho = function(){ $("#content").load("/carrinho/#"); };
        
    this.init();    
});

