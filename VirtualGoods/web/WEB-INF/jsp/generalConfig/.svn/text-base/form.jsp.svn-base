<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../../header.jsp"%>

<script type="text/javascript" src="<c:url value="/js/jquery.price_format.1.7.js" />"></script>

<script type="text/javascript">
	
</script>
</head>

<body >

	<%@ include file="../../../menu.jsp"%>

	<div class="container">

		<div class="content">

			<section id="forms">
			<div class="page-header">
				<h2>Configurações Gerais</h2>
			</div>

			<div class="row">
				<div class="span12">

					<div id="messages">
						<c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<span class="label important">${error.message}</span>
								<br />
							</c:forEach>
						</c:if>
						
						<c:if test="${not empty notice}">
							<span  class="label success">${notice}</span><br/>
						</c:if>
					</div>

					<form action="<c:url value="/generalConfig/save" />" method="post">
						<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
						
						<fieldset>
						   <div class="well">
								<h6>Fraseologias</h6>
								<div  class="clearfix">



									<div class="clearfix">
										<label for="xlInput">${configList[0].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[0].value" name="configList[0].value">${configList[0].value}</textarea>
										</div>
											<input type="hidden" id="configList[0].id"          name="configList[0].id" 			value="${configList[0].id}">
											<input type="hidden" id="configList[0].name"        name="configList[0].name" 			value="${configList[0].name}">
											<input type="hidden" id="configList[0].description" name="configList[0].description" 	value="${configList[0].description}">
											<input type="hidden" id="configList[0].label" 		name="configList[0].label" 			value="${configList[0].label}">
									</div>
									
									<div class="clearfix">
										<label for="xlInput">${configList[1].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[1].value" name="configList[1].value">${configList[1].value}</textarea>
										</div>
											<input type="hidden" id="configList[1].id"          name="configList[1].id" 			value="${configList[1].id}">
											<input type="hidden" id="configList[1].name"        name="configList[1].name" 			value="${configList[1].name}">
											<input type="hidden" id="configList[1].description" name="configList[1].description" 	value="${configList[1].description}">
											<input type="hidden" id="configList[1].label" 		name="configList[1].label" 			value="${configList[1].label}">
									</div>
									
									<div class="clearfix">
										<label for="xlInput">${configList[2].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[2].value" name="configList[2].value">${configList[2].value}</textarea>
										</div>
											<input type="hidden" id="configList[2].id"          name="configList[2].id" 			value="${configList[2].id}">
											<input type="hidden" id="configList[2].name"        name="configList[2].name" 			value="${configList[2].name}">
											<input type="hidden" id="configList[2].description" name="configList[2].description" 	value="${configList[2].description}">
											<input type="hidden" id="configList[2].label" 		name="configList[2].label" 			value="${configList[2].label}">
									</div>
									
									<div class="clearfix">
										<label for="xlInput">${configList[4].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[4].value" name="configList[4].value">${configList[4].value}</textarea>
										</div>
											<input type="hidden" id="configList[4].id"          name="configList[4].id" 			value="${configList[4].id}">
											<input type="hidden" id="configList[4].name"        name="configList[4].name" 			value="${configList[4].name}">
											<input type="hidden" id="configList[4].description" name="configList[4].description" 	value="${configList[4].description}">
											<input type="hidden" id="configList[4].label" 		name="configList[4].label" 			value="${configList[4].label}">
									</div>
									
									<div class="clearfix">
										<label for="xlInput">${configList[6].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[6].value" name="configList[6].value">${configList[6].value}</textarea>
										</div>
											<input type="hidden" id="configList[6].id"          name="configList[6].id" 			value="${configList[6].id}">
											<input type="hidden" id="configList[6].name"        name="configList[6].name" 			value="${configList[6].name}">
											<input type="hidden" id="configList[6].description" name="configList[6].description" 	value="${configList[6].description}">
											<input type="hidden" id="configList[6].label" 		name="configList[6].label" 			value="${configList[6].label}">
									</div>
									
									
									<div class="clearfix">
										<label for="xlInput">${configList[5].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[5].value" name="configList[5].value">${configList[5].value}</textarea>
										</div>
											<input type="hidden" id="configList[5].id"          name="configList[5].id" 			value="${configList[5].id}">
											<input type="hidden" id="configList[5].name"        name="configList[5].name" 			value="${configList[5].name}">
											<input type="hidden" id="configList[5].description" name="configList[5].description" 	value="${configList[5].description}">
											<input type="hidden" id="configList[5].label" 		name="configList[5].label" 			value="${configList[5].label}">
									</div>
									
									<div class="clearfix">
										<label for="xlInput">${configList[7].label}</label>
										<div class="input">
											<textarea style="width: 707px; height: 54px;" id="configList[7].value" name="configList[7].value">${configList[7].value}</textarea>
										</div>
											<input type="hidden" id="configList[7].id"          name="configList[7].id" 			value="${configList[7].id}">
											<input type="hidden" id="configList[7].name"        name="configList[7].name" 			value="${configList[7].name}">
											<input type="hidden" id="configList[7].description" name="configList[7].description" 	value="${configList[7].description}">
											<input type="hidden" id="configList[7].label" 		name="configList[7].label" 			value="${configList[7].label}">
									</div>

								</div>	
							</div>

						   <div class="well">
								<h6>Outras Configurações</h6>
								<div class="clearfix">

									<div class="clearfix">
										<label for="xlInput">${configList[3].label}</label>
										<div class="input" >
											<input class="mini" type="text" name="configList[3].value" id="configList[3].value" size="3" maxlength="3" value="${configList[3].value}" />
											<span class="help-block">Exemplo: 30 (segundos)</span>
										</div>
											<input type="hidden" id="configList[3].id"          name="configList[3].id" 			value="${configList[3].id}">
											<input type="hidden" id="configList[3].name"        name="configList[3].name" 			value="${configList[3].name}">
											<input type="hidden" id="configList[3].description" name="configList[3].description" 	value="${configList[3].description}">
											<input type="hidden" id="configList[3].label" 		name="configList[3].label" 			value="${configList[3].label}">
									</div>

								</div>	
							</div>

							<div class="actions">
								<input type="submit" class="btn primary" value="Salvar">&nbsp;
							</div>
						</fieldset>
						
					</form>
				</div>
			</div>
			<!-- /row --> 
		</section>
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>
	</div>
</body>
</html>