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
			<!-- Forms
			================================================== -->
			<section id="forms">
			  <div class="page-header">
			    <h2>Minha Conta</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/usuario/updateSenha" />" method="post">
			        <fieldset>
			          <div class="clearfix">
			            <label for="xlInput">Senha Atual</label>
			            <div class="input">
			              <input class="xlarge" id="senhaAtual" name="senhaAtual" size="30" type="password" maxlength="50" value="${senhaAtual}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="xlInput">Nova Senha</label>
			            <div class="input">
			              <input class="xlarge" id="novaSenha" name="novaSenha" size="30" type="password" maxlength="50" value="${novaSenha}" />
			            </div>
			          </div>
			          <div class="clearfix">
			            <label for="xlInput">Confirme sua Nova Senha</label>
			            <div class="input">
			              <input class="xlarge" id="confirmeNovaSenha" name="confirmeNovaSenha" size="30" type="password" maxlength="50" value="${confirmeNovaSenha}" />
			            </div>
			          </div>
			          <div class="actions">
			            <input type="submit" class="btn primary" value="Salvar">&nbsp;
			          </div>
			        </fieldset>
			      </form>
			    </div>
			  </div><!-- /row -->
			</section>		
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>