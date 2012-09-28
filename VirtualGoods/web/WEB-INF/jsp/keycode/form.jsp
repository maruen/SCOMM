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
			    <h2>Keycode</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/keycode/save" />" method="post">
			      	<input type="hidden" name="keycode.id" id="keycode.id" value="${keycode.id}">
			        <fieldset>
			          <legend>${keycode.id == null || keycode.id == 0 ? 'Novo Keycode' : 'Alterar Keycode' }</legend>
			          <div class="clearfix">
			            <label for="xlInput">Nome</label>
			            <div class="input">
			              <input class="xlarge" id="keycode.nome" name="keycode.nome" size="30" type="text" maxlength="50" value="${keycode.nome}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="normalSelect">Nome Parceiro</label>
			            <div class="input">
			            	<select name="keycode.parceiro.id" id="keycode.parceiro.id">
				                <c:forEach items="${parceiroList}" var="parceiro">
								<c:if test="${keycode.parceiro.id == null or keycode.parceiro.id != parceiro.id }">
									<option value="${parceiro.id}">${parceiro.nome }</option>
								</c:if>
								<c:if test="${keycode.parceiro.id != null and keycode.parceiro.id == parceiro.id }">
									<option value="${parceiro.id}" selected="selected">${parceiro.nome }</option>
								</c:if>
								</c:forEach>                
				            </select>
			            </div>			            
			          </div><!-- /clearfix -->		          
			          <div class="clearfix">
			            <label for="prependedInput2">Habilitado</label>
			            <div class="input">
			              <div class="input-prepend">
			                <label class="add-on">
			                	<c:if test="${keycode == null or keycode.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
			                	<c:if test="${keycode != null and keycode.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
			                </label>                
			              </div>
			            </div>
			          </div><!-- /clearfix -->
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