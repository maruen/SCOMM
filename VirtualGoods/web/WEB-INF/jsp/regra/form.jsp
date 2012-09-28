<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%@ include file="../../../header.jsp"  %>
	<script type="text/javascript">
	function selectParceiro(obj) {
		if(obj.value > 0) {
			var contexto = $('#contextPath').val();
			$.get(contexto + "/regra/la/"+obj.value, null, 
			function(data) {
				$('#divLa').html(data);
			}, 'html');
			
			$.get(contexto + "/regra/keycode/"+obj.value, null, 
			function(data) {
				$('#divKeycode').html(data);
			}, 'html');	
		}			
	}
	
	function selectSharecode(obj, divIdName, idShare, operadora) {
		var id = 0;
		if(idShare > 0)
			id = idShare;
		
		if(obj.value == "") {
			$('#'+divIdName).html("");
		} else if(obj.value > 0) {
			var contexto = $('#contextPath').val();
			$.get(contexto + "/regra/sharecode/"+obj.value+"/"+id+"/"+operadora, null, 
			function(data) {
				$('#'+divIdName).html(data);
			}, 'html');	
		}			
	}
	
	function carrega() {
		if(document.getElementById('regra.sharecodeClaro.tarifacao') != null && document.getElementById('regra.sharecodeClaro.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeClaro.tarifacao'), 'divSharecodeClaro', document.getElementById('regra.sharecodeClaro.id').value, 'Claro');	
		if(document.getElementById('regra.sharecodeCtbc.tarifacao') != null && document.getElementById('regra.sharecodeCtbc.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeCtbc.tarifacao'), 'divSharecodeCtbc', document.getElementById('regra.sharecodeCtbc.id').value, 'Ctbc');
		if(document.getElementById('regra.sharecodeNextel.tarifacao') != null && document.getElementById('regra.sharecodeNextel.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeNextel.tarifacao'), 'divSharecodeNextel', document.getElementById('regra.sharecodeNextel.id').value, 'Nextel');
		if(document.getElementById('regra.sharecodeOi.tarifacao') != null && document.getElementById('regra.sharecodeOi.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeOi.tarifacao'), 'divSharecodeOi', document.getElementById('regra.sharecodeOi.id').value, 'Oi');
		if(document.getElementById('regra.sharecodeTim.tarifacao') != null && document.getElementById('regra.sharecodeTim.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeTim.tarifacao'), 'divSharecodeTim', document.getElementById('regra.sharecodeTim.id').value, 'Tim');
		if(document.getElementById('regra.sharecodeVivo.tarifacao') != null && document.getElementById('regra.sharecodeVivo.tarifacao').value > 0)
			selectSharecode(document.getElementById('regra.sharecodeVivo.tarifacao'), 'divSharecodeVivo', document.getElementById('regra.sharecodeVivo.id').value, 'Vivo');
	}
	</script>

</head>

<body onload="carrega()">

	<%@ include file="../../../menu.jsp"  %>
	
	<div class="container">

		<div class="content">
			<!-- Forms
			================================================== -->
			<section id="forms">
			  <div class="page-header">
			    <h2>Regras</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/regra/save" />" method="post">
			      	<input type="hidden" name="regra.id" id="regra.id" value="${regra.id}">
			      	<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
			        <fieldset>
			          <legend>${regra.id == null || regra.id == 0 ? 'Nova Regra' : 'Alterar Regra' }</legend>
			          <div class="clearfix">
			            <label for="xlInput">Nome</label>
			            <div class="input">
			              <input class="xlarge" id="regra.nome" name="regra.nome" size="30" type="text" maxlength="50" value="${regra.nome}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="normalSelect">Parceiro</label>
			            <div class="input">
			            	<select name="regra.parceiro.id" id="regra.parceiro.id" onchange="selectParceiro(this)">
			            		<option value="">selecione...</option>
				                <c:forEach items="${parceiroList}" var="parceiro">
								<c:if test="${regra.parceiro.id == null or regra.parceiro.id != parceiro.id }">
									<option value="${parceiro.id}">${parceiro.nome }</option>
								</c:if>
								<c:if test="${regra.parceiro.id != null and regra.parceiro.id == parceiro.id }">
									<option value="${parceiro.id}" selected="selected">${parceiro.nome }</option>
								</c:if>
								</c:forEach>                
				            </select>
			            </div>			            
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="normalSelect">LA</label>
			            <div class="input" id="divLa">
			            	<%@ include file="la.jsp"  %>
			            </div>			            
			          </div><!-- /clearfix -->		
			          <div class="clearfix">
			            <label for="normalSelect">Keycode</label>
			            <div class="input" id="divKeycode">
			            	<%@ include file="keycode.jsp"  %>			            	
			            </div>			            
			          </div><!-- /clearfix -->
			          
			          <!-- ------ SHARECODE CLARO ------ -->
			          <c:if test="${not empty sharecodeListClaro}">
			          <div class="well">
			          	<h6>Claro</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeClaro.id" id="regra.sharecodeClaro.id" value="${regra.sharecodeClaro.id }" />
				            	<select name="regra.sharecodeClaro.tarifacao" id="regra.sharecodeClaro.tarifacao" onchange="selectSharecode(this, 'divSharecodeClaro', '${regra.sharecodeClaro.id }', 'Claro')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListClaro}" var="sharecode">
				            			<c:if test="${regra.sharecodeClaro.tarifacao == null or regra.sharecodeClaro.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeClaro.tarifacao != null and regra.sharecodeClaro.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeClaro">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			          
			          
			          <!-- ------ SHARECODE VIVO ------ -->
			          <c:if test="${not empty sharecodeListVivo}">
			          <div class="well">
			          	<h6>Vivo</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeVivo.id" id="regra.sharecodeVivo.id" value="${regra.sharecodeVivo.id }" />
				            	<select name="regra.sharecodeVivo.tarifacao" id="regra.sharecodeVivo.tarifacao" onchange="selectSharecode(this, 'divSharecodeVivo', '${regra.sharecodeVivo.id }', 'Vivo')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListVivo}" var="sharecode">
				            			<c:if test="${regra.sharecodeVivo.tarifacao == null or regra.sharecodeVivo.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeVivo.tarifacao != null and regra.sharecodeVivo.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeVivo">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			          
			          
			          <!-- ------ SHARECODE OI ------ -->
			          <c:if test="${not empty sharecodeListOi}">
			          <div class="well">
			          	<h6>Oi</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeOi.id" id="regra.sharecodeOi.id" value="${regra.sharecodeOi.id }" />
				            	<select name="regra.sharecodeOi.tarifacao" id="regra.sharecodeOi.tarifacao" onchange="selectSharecode(this, 'divSharecodeOi', '${regra.sharecodeOi.id }', 'Oi')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListOi}" var="sharecode">
				            			<c:if test="${regra.sharecodeOi.tarifacao == null or regra.sharecodeOi.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeOi.tarifacao != null and regra.sharecodeOi.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeOi">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			          
			          
			          <!-- ------ SHARECODE TIM ------ -->
			          <c:if test="${not empty sharecodeListTim}">
			          <div class="well">
			          	<h6>Tim</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeTim.id" id="regra.sharecodeTim.id" value="${regra.sharecodeTim.id }" />
				            	<select name="regra.sharecodeTim.tarifacao" id="regra.sharecodeTim.tarifacao" onchange="selectSharecode(this, 'divSharecodeTim', '${regra.sharecodeTim.id }', 'Tim')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListTim}" var="sharecode">
				            			<c:if test="${regra.sharecodeTim.tarifacao == null or regra.sharecodeTim.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeTim.tarifacao != null and regra.sharecodeTim.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeTim">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			          
			          
			          <!-- ------ SHARECODE NEXTEL ------ -->
			          <c:if test="${not empty sharecodeListNextel}">
			          <div class="well">
			          	<h6>Nextel</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeNextel.id" id="regra.sharecodeNextel.id" value="${regra.sharecodeNextel.id }" />
				            	<select name="regra.sharecodeNextel.tarifacao" id="regra.sharecodeNextel.tarifacao" onchange="selectSharecode(this, 'divSharecodeNextel', '${regra.sharecodeNextel.id }', 'Nextel')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListNextel}" var="sharecode">
				            			<c:if test="${regra.sharecodeNextel.tarifacao == null or regra.sharecodeNextel.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeNextel.tarifacao != null and regra.sharecodeNextel.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeNextel">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			          
			          
			          <!-- ------ SHARECODE CTBC ------ -->
			          <c:if test="${not empty sharecodeListCtbc}">
			          <div class="well">
			          	<h6>Ctbc</h6>
			          	  <div class="clearfix">
				            <label for="normalSelect">Tarifação</label>
				            <div class="input">
				            	<input type="hidden" name="regra.sharecodeCtbc.id" id="regra.sharecodeCtbc.id" value="${regra.sharecodeCtbc.id }" />
				            	<select name="regra.sharecodeCtbc.tarifacao" id="regra.sharecodeCtbc.tarifacao" onchange="selectSharecode(this, 'divSharecodeCtbc', '${regra.sharecodeCtbc.id }', 'Ctbc')">	
				            		<option value="">selecione...</option>
				            		<c:forEach items="${sharecodeListCtbc}" var="sharecode">
				            			<c:if test="${regra.sharecodeCtbc.tarifacao == null or regra.sharecodeCtbc.tarifacao != sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }">${sharecode.tarifacao }</option>
										</c:if>
										<c:if test="${regra.sharecodeCtbc.tarifacao != null and regra.sharecodeCtbc.tarifacao == sharecode.tarifacao }">
											<option value="${sharecode.tarifacao }" selected="selected">${sharecode.tarifacao }</option>
										</c:if>
				            			
				            		</c:forEach>				                                
					            </select>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="normalSelect">Sharecode</label>
				            <div class="input" id="divSharecodeCtbc">				            	
				            </div>
				          </div><!-- /clearfix -->				          
			          </div>   
			          </c:if>
			                 
			          <div class="clearfix">
			            <label for="prependedInput2">Habilitado</label>
			            <div class="input">
			              <div class="input-prepend">
			                <label class="add-on">
			                	<c:if test="${regra == null or regra.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
			                	<c:if test="${regra != null and regra.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
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