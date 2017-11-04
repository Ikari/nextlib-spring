$(document).ready(function() {
    $("div.next-tab-menu>div.list-group>a").click(function(e) {                
        e.preventDefault();
        $(this).siblings('a.active').removeClass("active");
        $(this).addClass("active");
        var index = $(this).index();
        $("div.next-tab>div.next-tab-content").removeClass("active");
        $("div.next-tab>div.next-tab-content").eq(index).addClass("active");
    });
});