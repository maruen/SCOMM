<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%@ include file="../../../header.jsp"  %>

</head>

<body>

	<%@ include file="../../../menu.jsp"  %>
	
	<div class="container">

		<div class="content">
			<c:if test="${not exibeFormUsuario}">
			<div class="page-header">
				<c:if test="${empty usuarioLogado.usuario}">
				<h1>
					Login <small>Para acessar o sistema, informe o usuário e senha</small>
				</h1>
				</c:if>
				<c:if test="${not empty usuarioLogado.usuario}">
				<h1>
					Bem vindo <small>ao Serviço Virtual Goods</small> 
				</h1>
				</c:if>
			</div>
			<div class="row">
				<div class="span10">
					<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
				</div>
				<div class="span4">
					
				</div>
			</div>
			</c:if>
			
			<c:if test="${exibeFormUsuario}">
				<%@ include file="../../../formUsuario.jsp"  %>
			</c:if>			
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>