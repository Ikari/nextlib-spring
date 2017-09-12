$(function(){
    
    this.init = function(){
        $("#cliente").click(this.cliente);
        $("#produto").click(this.produto);
        $("#produtos").click(this.produtos);
    };   
   
    this.cliente = function(){ console.log(1);  $("#content").load("/cliente"); };    
    this.produto = function(){ $("#content").load("/produto"); };
    this.produtos = function(){ $("#content").load("/produtos"); };
        
    this.init();    
});

