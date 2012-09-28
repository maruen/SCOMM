<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../../header.jsp"%>

<script type="text/javascript" src="<c:url value="/js/jquery.price_format.1.7.js" />"></script>

<script type="text/javascript">
	
	function updateFields(obj) {
		var context = $('#contextPath').val();
		var url	= context + '/buyConfig/getConfigByOperator/' + obj.value;
		
		$.get(url,function(data) {
			$('#divBuyConfig').html(data);
		}, 'html');
	
		$('#messages').hide();
		
		toggle(obj.value);
	}
	
	function showFields() {
		$(".well").show();
		$(".actions").show();
	}
	
	function hideFields() {
		$(".well").hide();
		$(".actions").hide();
	}
	
	function toggle(option) {
		if (option == null || option == 0) {
			hideFields();
		} else {
			showFields();
		}
	}
	
	
</script>

</head>

<body onload="toggle( ${buyConfig.codigoOperadora}  )" >

	<%@ include file="../../../menu.jsp"%>

	<div class="container">

		<div class="content">

			<section id="forms">
			<div class="page-header">
				<h2>Configurações de Compras</h2>
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

					<form action="<c:url value="/buyConfig/save" />" method="post">
						<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
						
						<fieldset>
							<div class="clearfix">
								<label for="buyConfig.codigoOperadora">Operadora: &nbsp;</label>
								<div class="input">
									<select name="buyConfig.codigoOperadora" id="buyConfig.codigoOperadora" onchange="updateFields(this)">
										<option value="0">Selecione...</option>
										<c:forEach items="${carrierList}" var="carrier">
											
											<c:choose>
												<c:when test="${carrier.carrier eq buyConfig.codigoOperadora }">
													<c:set var="selected" value="selected" /> 
												</c:when>
												<c:otherwise>
													<c:set var="selected" value="" />  
												</c:otherwise>
											</c:choose>
											
											<option value="${carrier.carrier}" ${selected} >${carrier.descricao}</option>
											
										</c:forEach>
									</select>
								</div>
							</div>
							</br>
							
						   <div class="well">
								<h6>Compras</h6>
								<div  class="clearfix" id="divBuyConfig">
									<%@ include file="getConfigByOperator.jsp" %>
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