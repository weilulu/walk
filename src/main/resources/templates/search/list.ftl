
<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="utf-8"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Calf" />
        <meta name="copyright" content="Calf" />

        <link rel="author" href=https://plus.google.com/112983042847560253980/posts />
        <meta name="twitter:creator" content="@calfzhou">
        <meta property="og:type" content="article" />
        <meta name="twitter:card" content="summary">

<meta property="og:title" content="GoCalf Blog"/>
<meta name="twitter:title" content="GoCalf Blog">
<meta property="og:url" content="http://www.gocalf.com/blog" />
<meta property="og:site_name" content="GoCalf Blog" />
<meta property="og:article:author" content="Calf" />
        <title>WeiLu Blog</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="http://www.gocalf.com/blog/theme/css/style.min.css?93135f3f">
        <link rel="shortcut icon" href="http://www.gocalf.com/blog/theme/images/favicon.ico" type="image/x-icon" type="image/png" />
        <link rel="icon" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-152x152.png" type="image/png" />
        <link rel="apple-touch-icon" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon.png"  type="image/png" />
        <link rel="apple-touch-icon" sizes="57x57" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-57x57.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="72x72" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-72x72.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="76x76" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-76x76.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="114x114" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-114x114.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="120x120" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-120x120.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="144x144" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-144x144.png" type="image/png" />
        <link rel="apple-touch-icon" sizes="152x152" href="http://www.gocalf.com/blog/theme/images/apple-touch-icon-152x152.png" type="image/png" />
        <link href="http://www.gocalf.com/blog/feeds/atom.xml" type="application/atom+xml" rel="alternate" title="GoCalf Blog - Atom Feed" />
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
        <div class="navbar navbar-static-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <div class="span1"></div>
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="http://www.gocalf.com/blog/"><span class=site-name>GoCalf Blog</span></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right top-menu">
                            <li  class="active"><a href="www.weilu.com/index/list">Home</a></li>
                            <li ><a href="www.weilu.com/about">About</a></li>
                            <li ><a href="www.weilu.com/categories">Categories</a></li>
                            <li ><a href="www.weilu.com/tags">Tags</a></li>
                            <li ><a href="www.weilu.com/archives">Archives</a></li>
                            <li><form class="navbar-search" action="http://www.gocalf.com/blog/search.html" onsubmit="return validateForm(this.elements['q'].value);"> <input type="text" class="search-query" placeholder="Search" name="q" id="tipue_search_input"></form></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1"></div>
                <div class="span10">
<div class="row-fluid">

    <div class="row-fluid">

    </div>

    <div class="row-fluid">
        <div class="span8 offset2">
            <header>
            <h1 id="recent-posts">Recent Posts <a id="allposts" href="http://www.gocalf.com/blog/archives.html">all posts</a></h1>
            </header>
        <div class="recent-posts">
        
        <#if page?size gt 0 >
          <#list page as article >
            <article>
                ${article.title}
                <#--<section>
                    Category
                <a href="http://www.gocalf.com/blog/categories.html#algorithm-ref">À„∑®test</a>
                <div class="recent-posts-time">
                <time pubdate="pubdate" datetime="2014-08-28T17:15:00">${article.postTime}</time>
                </div>
                </section>-->
                <section>
                    ${article.content}
                </section>
                <section>
                <#--<a href="/article/readArticle/${article.id}">Read More --></a>-->
                </section>
            </article>
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
<div id="footer">
    <ul class="footer-content">
        <li class="elegant-subtitle"><span class="site-name">GoCalf Blog</span> - 1/100 ALGO&amp;MATH; 1/100 IT&amp;GAME; 1/100 INFO&amp;SHARING; 1/100 WHO KNOWS.</li>
        <li class="elegant-power">Powered by <a href="http://getpelican.com/" title="Pelican Home Page">Pelican</a>. Theme: <a href="http://oncrashreboot.com/pelican-elegant" title="Theme Elegant Home Page">Elegant</a> by <a href="http://oncrashreboot.com" title="Talha Mansoor Home Page">Talha Mansoor</a></li>
    </ul>
</div>
</footer>        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script>
            function validateForm(query)
            {
                return (query.length > 0);
            }
        </script>
    </body>
    <!-- Theme: Elegant built for Pelican
    License : http://oncrashreboot.com/pelican-elegant -->
</html>