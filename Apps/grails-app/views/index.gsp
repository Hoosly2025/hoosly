<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Surveys!</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
    	<!--  
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
        -->
    </content>

    <div class="svg" role="presentation" >
        <div class="grails-logo-container">
            <asset:image src="surveys-35.png" class="grails-logo" width="900" height="275"/>
            <!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        </div>
    </div>

	<div >
        <section class="row colset-2-its">
            <br>

			<h1>
			
			<!--  <div style="float: left; width: 270px; background-color: #ffffff;font-size:4;margin:10px;">
				<span style="margin-left:30px;"><g:link controller="appType" action="index"> <asset:image src="surveys-types.png" width="200" height="53"/></g:link></span><br>
    		</div>-->
			<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;">
    			<span style="margin:35px;"><g:link controller="app" action="index"><asset:image src="surveys-surveys.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Create a Survey</span><br>
    			</div>
    		</div>
    		<!--  
    		<div style="float: left; width: 270px; background-color: #ffffff;font-size:4;margin:10px;">
    			<span style="margin-left:30px;"><g:link controller="campaign" action="index"><asset:image src="surveys-campaigns.png" width="200" height="53"/></g:link></span><br>
    		</div>-->
    		<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;">
    			<span style="margin:35px;"><g:link controller="question" action="index"><asset:image src="surveys-questions.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Ask a Question</span><br>
    			</div>
    		</div>
    		<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;">
    			<span style="margin:35px;"><g:link controller="answer" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Check Answers</span><br>
    			</div>
    		</div>
			
			
    		
            </h1>
           
            
            
            <br><br>
            <br><br>
            <br><br>
            <div class="svg" role="presentation" style="float:left;">
        		<div class="grails-logo-container">
            		<asset:image src="surveys-33.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
    		
    		<br>

			<h1>
			
			<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;margin-top:40px;">
    			<span style="margin:35px;"><g:link controller="appType" action="index"><asset:image src="surveys-types.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Survey Types</span><br>
    			</div>
    		</div>
    		<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;margin-top:40px;margin-bottom:20px;">
    			<span style="margin:35px;"><g:link controller="campaign" action="index"><asset:image src="surveys-campaigns.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Run Campaigns</span><br>
    			</div>
    		</div>
    		
            </h1>
            
        </section>
    </div>

</body>
</html>
