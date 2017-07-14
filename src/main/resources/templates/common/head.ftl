 <div class="navbar navbar-static-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <div class="span1"></div>
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="http://localhost:8080/"><span class=site-name>WeiLu Blog</span></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right top-menu">
                            <li <#if active=="0">class="active"</#if>><a href="http://localhost:8080/index/list">Home</a></li>
                            <li <#if active=="1">class="active"</#if>><a href="http://localhost:8080/about">About</a></li>
                            <li <#if active=="2">class="active"</#if>><a href="http://localhost:8080/categories">Categories</a></li>
                            <!--<li <#if active=="3">class="active"</#if>><a href="http://localhost:8080/tags">Tags</a></li>-->
                            <li <#if active=="4">class="active"</#if>><a href="http://localhost:8080/archives">Archives</a></li>
                            <li><form class="navbar-search" action="/search/result" onsubmit="return validateForm(this.elements['q'].value);"> <input type="text" class="search-query" placeholder="Search" name="q" id="tipue_search_input"></form></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>