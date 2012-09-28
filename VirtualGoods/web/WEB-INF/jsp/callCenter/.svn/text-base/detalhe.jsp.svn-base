<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" />" />
	<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/demos/demos.css" />" />
	
	<%@ include file="../../../header.jsp"  %>
	
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.core.js" />"></script>
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.widget.js" />"></script>
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.datepicker.js" />"></script>	
	<script type="text/javascript">
	$(function() {
		$("#dataInicial").datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '-80:+0',
			dateFormat: 'dd/mm/yy',
			monthNamesShort: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 
			 			'Setembro', 'Outubro', 'Novembro', 'Dezembro']
		});
		$("#dataFinal").datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '-80:+0',
			dateFormat: 'dd/mm/yy',
			monthNamesShort: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 
			 			'Setembro', 'Outubro', 'Novembro', 'Dezembro']
		});
	});
	</script>
</head>

<body>

	<%@ include file="../../../menu.jsp"  %>
	
	<div class="container">

		<div class="content">
			<section id="tables">
  				<!-- Table structure -->
  				  <div class="page-header">
				    <h2>Call Center</h2>
				  </div>
  				<div class="row">
    				<div class="span15">
    				  <table class="bordered-table">
				        <thead>
				          <tr>
				            <th width="15%">Data</th>
				            <th width="15%">MSISDN</th>
				            <th width="70%">Status</th>				            
				          </tr>
				        </thead>
				        <tbody>
				        	<c:if test="${not empty historicoList}">						
								<c:forEach items="${historicoList}" var="historico">
									<tr>
										<td>${historico.dtCriacaoFormat }</td>
						            	<td>${historico.msisdn}</td>
						            	<td>${historico.statusFormat}</td>		            	
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