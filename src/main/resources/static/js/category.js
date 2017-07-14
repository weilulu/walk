/*$('#showArtileId').click(function(){
	getArticleInfo($(this).attr('name'))
})*/
$(function(){
    function uncollapse() {
        $(window.location.hash).collapse({
            toggle: true
        })
}
})
function getArticleInfo(name,_this){
	$(window.location.hash).collapse({
        toggle: true
    })
	$.ajax({
		url:"/categories/getArticleInfo?name="+name,
		type:'get',
		dataType:"json"
	}).done(function(data){
		//console.log('data:'+data)
		$(_this).parent('div[class="accordion-heading"]').find('div[id="'+name+'"]').remove();
		if(data){
			var html = '<div id="'+name+'" class="accordion-body in collapse"><div class="accordion-inner"><ul class="list-articles-category"><ul class="list-articles-category">'
			for(var i=0;i<data.length;i++){
				var json = data[i];
				html += '<li><time pubdate="pubdate" datetime="'+json.create_time+'">'+json.create_time+'</time><a href="/article/readArticle/'+json.id+'">'+json.title+'</a></li>'
			}
			html += '</ul></div></div>'
			console.log(html)
			$(_this).parent('div[class="accordion-heading"]').append(html)
		}
	});
}