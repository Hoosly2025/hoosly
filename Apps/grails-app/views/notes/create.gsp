<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'notes.label', default: 'Notes')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-notes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-notes" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.notes}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.notes}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save" method="post" enctype="multipart/form-data">
                <fieldset class="form">
                    <f:all bean="notes" except="imageOne, imageTwo, imageThree, task"/>
                </fieldset>
                <fieldset>
                <f:field bean="notes" property="task" widget-optionValue="name"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div class="post"><h4>Upload Notes Image (JPG):</h4></div>
                	<br>
              				Please be patient while the file uploads.<br>
              		<div>
                  <input type="file" name="myFile" />
              </div>	
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
