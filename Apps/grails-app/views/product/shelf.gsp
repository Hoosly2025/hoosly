<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="bookly.love - books" />
<meta name="keywords" content="Books, Publish, Marketing, pdf, text, images, image, video, photo, distribute, distribution, Garments, Art, Clothing, Jewelry, startup, online store, entrepreneur" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>bookly.love - Books</title>
	<asset:stylesheet src="skel-noscript.css"/>
	<asset:stylesheet src="style.css"/>
	<asset:stylesheet src="style-desktop.css"/>
	
<LINK REL="SHORTCUT ICON"
       HREF="${createLinkTo(dir:'images', file:'favicon.ico')}">
<link rel="icon" href="${createLinkTo(dir:'images', file:'favicon.ico')}"/>
<g:javascript library="scriptaculous" />    

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,900,300italic" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Alegreya+SC:700,400|Alegreya+Sans' rel='stylesheet' type='text/css'>
		<asset:javascript src="jquery.min.js"/>
		<asset:javascript src="jquery.dropotron.min.js"/>
		<asset:javascript src="config.js"/>
		<asset:javascript src="skel.min.js"/>
		<asset:javascript src="skel-panels.min.js"/>
		
		<!--<noscript>
			<asset:stylesheet src="skel-noscript.css"/>
			<asset:stylesheet src="style.css"/>
			<asset:stylesheet src="style-desktop.css"/>
	
		</noscript>-->
		<!--[if lte IE 8]><asset:javascript src="html5shiv.js"/><asset:stylesheet src="ie8.css"/><![endif]-->
		
		<style>
		  #accordion-resizer {
		  	margin-left: 80px;
		    margin-right: 80px;
		    padding: 50px;
		  }
		  p {
		  border: 1px #16e01b;
		  border-width: 2px;
		  margin: 5px;
		  padding: 10px;
		  background-color: #d23b2a;
		  color: #fdeba9;
		}
		.button {
		  display: inline-block;
		  padding: 15px 25px;
		  font-size: 15px;
		  cursor: pointer;
		  text-align: center;
		  text-decoration: none;
		  outline: none;
		  color: #fdeba9;
		  background-color: #d23b2a;
		  border: none;
		  border-radius: 15px;
		  box-shadow: 0 9px #78789b;
		}

		.button:hover {background-color: #000000}
		
		.button:active {
		  background-color: #1d10d2;
		  box-shadow: 0 5px #666;
		  transform: translateY(4px);
		}
		  </style>
		<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		  <script>
		  $( function() {
		    $( "#menu" ).menu();
		    $( "#menu2" ).menu();
		    $( "#menu3" ).menu();
		  } );

		  $( function() {
			    $( "#tabs" ).tabs();
			  } );
		  </script>
		  <style>
		  .ui-menu { width: 400px; }
		  </style>
		  <script>
  $( function() {
    $( "#draggable" ).draggable();
  } );
  </script>
  <!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-154739766-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-154739766-1');
</script>
  
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "shake", options, 1000, callback );
		$( "#block1" )
	    .animate({
	      width: "90%"
	    }, {
	      queue: false,
	      duration: 3000
	    })
	    .animate({ fontSize: "24px" }, 1500 )
	    .animate({ borderRightWidth: "15px" }, 1500 );
		$( "#block2" )
	    .animate({ width: "90%" }, 1000 )
	    .animate({ fontSize: "24px" }, 1000 )
	    .animate({ borderLeftWidth: "15px" }, 1000 );
		}

	function callback() {
	      setTimeout(function() {
	        $( "#block3" ).removeAttr( "style" ).hide().fadeIn();
	      }, 1000 );
	    };
	</script>
	
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">

							<!-- Banner -->
								<section id="banner">
									
										<g:link url="https://paypal.me/mytweetmark"><span class="image image-full"><asset:image src="pay-now.png"/></span></g:link>
										<header>
										<!-- 
											<h2>Shop</h2> 
											<span class="byline">Bring your store business online.</span>
											 -->
										</header>
									
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><button class="button"><span style="color:#feff00"><g:link url="/"><span style="color:#feff00">Home</span></g:link></span></button></li>
												<li><button class="button"><span style="color:#ffffff"><g:link controller="user" action="index"><span style="color:#feff00">Users</span></g:link></span></button></li>
												<li><button class="button"><span style="color:#ffffff"><g:link controller="checkout" action="index"><span style="color:#feff00">Checkouts</span></g:link></span></button></li>
												
												<li><button class="button"><span style="color:#feff00"><g:form controller="logout">                        
    													<g:submitButton name="logout" value="Logout" />
													</g:form></span></button></li>
												
												<!--<li><g:link controller="product" action="analytics">Analytics</g:link></li>
												<li><g:link controller="product" action="sales">Sales</g:link></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
														
							<div class="row">
						<div class="12u">
								<section>
									<div>
										<div id="tabs">
													  <ul>
													    <li><a href="#tabs-1">Categories</a></li>
													    <li><a href="#tabs-2">Books</a></li>
													    <li><a href="#tabs-3">Chapters</a></li>
													  </ul>
													  <div id="tabs-1" style="border: 5px #fdfaaa;
		  border-width: 5px;
		  background-color: #78789b;">
													  	<p><g:link class="list" action="index" controller="blogCategory"><span style="color:#feff9f;font-size:20px;">Categories.</span></g:link></p>
													  </div>
													  <div id="tabs-2" style="border: 5px #fdfaaa;
		  border-width: 5px;
		  background-color: #78789b;">
													    <p><g:link class="list" action="index" controller="book"><span style="color:#feff9f;font-size:20px;">Books.</span></g:link></p>
													  </div>
													  <div id="tabs-3" style="border: 5px #fdfaaa;
		  border-width: 5px;
		  background-color: #78789b;">
													    <p><g:link class="list" action="index" controller="chapter"><span style="color:#feff9f;font-size:20px;">Chapters.</span></g:link></p>
													  </div>
													</div>												
										
									</div>
								</section>

						</div>
					</div>
				</div>
			</div>
		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">
							
							<!-- Portfolio -->
								<section>
									
					<div class="row">
						<div class="12u">

							<!-- Blog >
								<section>
									<header class="major">
										<h2>The Blog</h2>
									</header>
									<div>
										<div class="row">
											<div class="6u">
												<section class="box">
													<a href="http://facebook.com/homecookme" class="image image-full"><img src="${createLinkTo(dir:'images', file:'pic08.jpg')}" alt="" /></a>
													<header>
														<h3>Magna tempus consequat lorem</h3>
														<span class="byline">Posted 45 minutes ago</span>
													</header>
													<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit  adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
													<footer class="actions">
														<a href="#" class="button fa fa-file-text">Continue Reading</a>
														<a href="#" class="button alt fa fa-comment">33 comments</a>
													</footer>
												</section>
											</div>
											<div class="6u">
												<section class="box">
													<a href="http://facebook.com/homecookme" class="image image-full"><img src="images/pic09.jpg" alt="" /></a>
													<header>
														<h3>Aptent veroeros et aliquam</h3>
														<span class="byline">Posted 45 minutes ago</span>
													</header>
													<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit  adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
													<footer class="actions">
														<a href="#" class="button fa fa-file-text">Continue Reading</a>
														<a href="#" class="button alt fa fa-comment">33 comments</a>
													</footer>
												</section>
											</div>
										</div>
									</div>
								</section>
							
						</div>
					</div>
				</div>
			</div-->

		<!-- Footer Wrapper -->
		<g:render template="/footer" />

	</body>
</html>