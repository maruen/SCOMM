<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%@ include file="../../../header.jsp"  %>
	<script type="text/javascript">
	function excluir(id) {
		var contexto = $('#contextPath').val();
		$.get(contexto + "/campanha/confirmaExcluir/"+id, null, 
		function(data) {
			$('#modal-excluir').html(data);
			$('#modal-excluir').modal('show');
		}, 'html');
	}
	</script>
</head>

<body>
	<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">

	<%@ include file="../../../menu.jsp"  %>
	
	<div class="container">

		<div class="content">
			<section id="tables">
  				<!-- Table structure -->
  				  <div class="page-header">
				    <h2>Campanha</h2>
				  </div>
  				<div class="row">
    				<div class="span15">
    				  <div class="well" style="padding: 10px 19px;">
       					 <a href="<c:url value="/campanha/form" />" class="btn primary">Inserir</a>
      				  </div>
				      <table class="bordered-table">
				        <thead>
				          <tr>
				            <th>Descrição</th>
				            <th>Tipo de Fluxo</th>
				            <th>Keyword</th>
				            <th>Parceiro</th>
				            <th>Tipo Campanha</th>
				            <th>Habilitado</th>
				            <th>Ação</th>
				          </tr>
				        </thead>
				        <tbody>
				        	<c:if test="${not empty campanhaList}">						
								<c:forEach items="${campanhaList}" var="campanha">
									<tr>
										<td><a href="<c:url value="/campanha/alterar/${campanha.id}" />">${campanha.description}</a></td>
						            	
						            	<c:forEach items="${vgFlowList}" var="vgFlow">
							            	<c:if test="${campanha.flowType == vgFlow.flowType}">
							            		<td>${vgFlow.flowName}</td>
							            	</c:if>
						            	</c:forEach>
						            	
					            		<td>${campanha.keyword}</td>
						            	<td>${campanha.regra.parceiro.nome}</td>
						            	<td>${campanha.tipoCampanha.sigla}</td>
						            	<td>${campanha.ativoFormat}</td>
						            	<td><a href="#" onclick="javascript:excluir(${campanha.id})" >Excluir</a></td>
						          	</tr>
								</c:forEach>				
							</c:if>
				        </tbody>
				      </table>	
					</div>
				</div>
			</section>
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>