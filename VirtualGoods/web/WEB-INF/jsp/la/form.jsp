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
			    <h2>LA</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/la/save" />" method="post">
			      	<input type="hidden" name="la.id" id="la.id" value="${la.id}">
			        <fieldset>
			          <legend>${la.id == null || la.id == 0 ? 'Novo LA' : 'Alterar LA' }</legend>
			          <div class="clearfix">
			            <label for="xlInput">LA</label>
			            <div class="input">
			              <input class="xlarge" id="la.nome" name="la.nome" size="30" type="text" maxlength="50" value="${la.nome}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="xlInput">Descrição</label>
			            <div class="input">
			              <input class="xlarge" id="la.descricao" name="la.descricao" size="30" type="text" maxlength="50" value="${la.descricao}" />
			            </div>
			          </div>
			          <div class="clearfix">
			            <label for="multiSelect">CarrierIdList</label>
			            <div class="input">
			            	<select class="medium" size="5" multiple="multiple" name="operadoras" id="operadoras">
		            		<c:forEach items="${operadoraList}" var="operadora">
								<c:if test="${operadora.selected}"><option value="${operadora}" selected="selected">${operadora.descricao }</option></c:if>
								<c:if test="${not operadora.selected}"><option value="${operadora}">${operadora.descricao }</option></c:if>
							</c:forEach>
			            	</select>			            
			              <span class="help-block">Para selecionar mais de uma operadora mantenha a tecla CTRL pressionada e selecione as operadoras</span>
			            </div>			            
			          </div><!-- /clearfix -->
			          <div class="well">
			          	<h6>Configurações Mercuri</h6>
			          	  <div class="clearfix">
				            <label for="xlInput">ServiceId</label>
				            <div class="input">
				              <input class="xlarge" id="la.mercuriServiceId" name="la.mercuriServiceId" size="30" type="text" maxlength="4" value="${la.mercuriServiceId}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">ItemId</label>
				            <div class="input">
				              <input class="xlarge" id="la.mercuriItemId" name="la.mercuriItemId" size="30" type="text" maxlength="4" value="${la.mercuriItemId}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">Password</label>
				            <div class="input">
				              <input class="xlarge" id="la.mercuriPassword" name="la.mercuriPassword" size="30" type="text" maxlength="50" value="${la.mercuriPassword}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">UserName</label>
				            <div class="input">
				              <input class="xlarge" id="la.mercuriUsername" name="la.mercuriUsername" size="30" type="text" maxlength="50" value="${la.mercuriUsername}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">URL Mercuri</label>
				            <div class="input">
				              <input class="xlarge" id="la.mercuriUrl" name="la.mercuriUrl" size="30" type="text" maxlength="128" value="${la.mercuriUrl}"/>
				              <span class="help-block">Exemplo: http://merc-inter.dc1.supp.com.br</span>
				            </div>
				          </div><!-- /clearfix -->
			          </div>
			          <div class="clearfix">
			            <label for="prependedInput2">Habilitado</label>
			            <div class="input">
			              <div class="input-prepend">
			                <label class="add-on">
			                	<c:if test="${la == null or la.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
			                	<c:if test="${la != null and la.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
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