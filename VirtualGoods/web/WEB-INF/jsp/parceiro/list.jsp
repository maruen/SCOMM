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
		$.get(contexto + "/parceiro/confirmaExcluir/"+id, null, 
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
				    <h2>Parceiro</h2>
				  </div>
  				<div class="row">
    				<div class="span15">
    				  <div class="well" style="padding: 10px 19px;">
       					 <a href="<c:url value="/parceiro/form" />" class="btn primary">Inserir</a>
      				  </div>
				      <table class="bordered-table">
				        <thead>
				          <tr>
				            <th>Nome</th>
				            <th>Qtd Retentativa</th>
				            <th>Schedule</th>
				            <th>LA</th>
				            <th>Habilitado</th>
				            <th>Ação</th>
				          </tr>
				        </thead>
				        <tbody>
				        	<c:if test="${not empty parceiroList}">						
								<c:forEach items="${parceiroList}" var="parceiro">
									<tr>
										<td><a href="<c:url value="/parceiro/alterar/${parceiro.id}" />">${parceiro.nome}</a></td>
						            	<td>${parceiro.retentativa}</td>
						            	<td>${parceiro.timeSchedule}</td>
						            	<td>
						            		${parceiro.lasFormat}
						            	</td>
						            	<td>${parceiro.ativoFormat}</td>
						            	<td><a href="#" onclick="javascript:excluir(${parceiro.id})" >Excluir</a></td>
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