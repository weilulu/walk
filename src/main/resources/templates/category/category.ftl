<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="utf-8"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WeiLu Blog</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="/css/style.css">
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
     (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
     m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
     })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-24210758-2', 'auto');
    ga('send', 'pageview');
</script>
        <script src="http://code.jquery.com/jquery.min.js"></script>
    </head>
    <body class="tex2jax_ignore">
        <div id="content-sans-footer">
       <#include "/common/head.ftl">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1"></div>
                <div class="span10">
<div class="row-fluid">
    <header class="page-header span10 offset2">
    <h1><a href="http://www.gocalf.com/blog/categories.html">All Categories</a></h1>
    </header>
</div>


<div class="row-fluid">
    <div class="span8 offset2">
        <div class="accordion" id="accordion2">
            <div class="accordion-group">
               <#if categories?size gt 0>
                 <#list categories?keys as name>
                	<div class="accordion-heading">
                     <a id="showArtileId" name='${name}' class="accordion-toggle list-of-categories" data-toggle="collapse" data-parent="#accordion2" href="#${name}">
                        ${name}
                     </a>
                    </div>    
                
                
                <div id="${name}" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <ul class="list-articles-category">
                           <#list categories["${name}"] as article>
                            <li><time pubdate="pubdate" datetime="${article.createTime}">${article.createTime}</time><a href="/article/readArticle/${article.articleId}">${article.title}</a></li>
                           </#list> 
                        </ul>
                    </div>
                </div>
                 </#list>
               </#if>
            </div>
        </div>
    </div>
</div>
                </div>
                <div class="span1"></div>
            </div>
        </div>
        <div id="push"></div>
    </div>
<footer>
 <#include "/common/footer.ftl">
</footer> 
      
 <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="/js/category.js"></script>
        <script>
            function validateForm(query)
            {
                return (query.length > 0);
            }
        </script>
<!--
<script  language="javascript" type="text/javascript">
    function uncollapse() {
            $(window.location.hash).collapse({
                toggle: true
            })
    }
</script>

<script type="text/javascript" language="JavaScript">
    uncollapse(); 
</script>
-->
    </body>
    <!-- Theme: Elegant built for Pelican
    License : http://oncrashreboot.com/pelican-elegant -->
</html>