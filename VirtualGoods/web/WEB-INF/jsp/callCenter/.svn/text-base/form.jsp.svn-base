<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="vg" uri="/WEB-INF/vgfunctions.tld"  %>
<%@ page import="br.com.supportcomm.virtualgoodscore.constantes.Operadora" %>
<%@ page import="br.com.supportcomm.virtualgoodscore.pojo.Transacao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" />" />
	<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/demos/demos.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/jquery.dataTables.css" />" />
	
	<%@ include file="../../../header.jsp"  %>
	
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.core.js" />"></script>
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.widget.js" />"></script>
	<script src="<c:url value="/js/jquery-ui-1.8.16.custom/development-bundle/ui/jquery.ui.datepicker.js" />"></script>	
	<script src="<c:url value="/js/jquery.dataTables.js" />"></script>
	
	<style> 
		
		.line_hover {background-color: #FFFFCC;}
		.bggreen  	{background-color: #339933; cursor: hand; color: black; font-weight: bolder;} 
		.bgred 		{background-color: #cc0000; cursor: hand; color: white; font-weight: bolder;}
 		.bgyellow 	{background-color: #ffff00; cursor: hand; color: black; font-weight: bolder;}
 		.nowrap 	{white-space: nowrap;}
 		
 		#tableList  tr.highlighted {background-color: #eee; color: black; font-weight: bolder;}  
 		#tableList 	td:hover 	   {cursor: pointer;}
 		
 		tr.selected-row 		   {background-color: '#DCBCCF';}
 		
 		#hint{
			cursor:pointer;
		}
	
		.tooltip{
			margin  :8px;
			padding :8px;
			border  :1px solid blue;
			background-color: rgb(51,51,51);
			position: absolute;
			z-index: 2;
			font-size: 11px;
  			color: #bfbfbf;
		}
 		
		div.dataTables_length label {
			width: 460px;
			float: left;
			text-align: left;
		}
		 
		div.dataTables_length select {
		    width: 75px;
		}
		 
	
	</style>
	
	
	<script type="text/javascript">
	
		var oTable;
	
		$(function() {
			$("#dataInicial").datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange: '-80:+0',
				dateFormat: 'dd/mm/yy',
				monthNamesShort: ['Janeiro',
				                  'Fevereiro',
				                  'Março',
				                  'Abril',
				                  'Maio',
				                  'Junho',
				                  'Julho',
				                  'Agosto',
				                  'Setembro',
				                  'Outubro',
				                  'Novembro',
				                  'Dezembro']
			});
			
			
			$("#dataFinal").datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange: '-80:+0',
				dateFormat: 'dd/mm/yy',
				monthNamesShort: ['Janeiro',
				                  'Fevereiro',
				                  'Março',
				                  'Abril',
				                  'Maio',
				                  'Junho',
				                  'Julho',
				                  'Agosto',
				                  'Setembro',
				                  'Outubro',
				                  'Novembro',
				                  'Dezembro']
			});
		});
		
		
		function query() {
			
			var context = $('#contextPath').val();
			var url	= context + "/callCenter/dataTable/"; 
			
			if ( oTable != null) {
				oTable.fnDestroy(); 
			}
			
			oTable = $('#tableList').dataTable( {
				 	 
				     "sPaginationType": "full_numbers",
				     "aaSorting": [[ 1, "desc" ]],
	                 "aoColumns": [
	                               {"bSortable":false},
	                               {"bSortable":true, "asSorting": [ "desc", "asc"  ] },
	                               {"bSortable":true, "asSorting": [ "desc", "asc"  ] },
	                               {"bSortable":false},
	                               {"bSortable":false},
	                               {"bSortable":false},
	                               {"bSortable":false},
	                               {"bSortable":false},
	                               {"bSortable":false},
	                               {"bSortable":false},
	                           ],

					                 
	                                
				
					 "bJQueryUI"		: false,
	                 "bServerSide"		: true,
	                 "bProcessing"		: true,
	                 "sAjaxSource"		: url,
	                 
	                 "bFilter"			: false,
	                 "asStripClasses" 	: [ "bggreen", "bgred" ],
	                 "oLanguage"		: {
	                     
	                	 "sEmptyTable"	: "Não foram encontrados resultados",
	                	 "sLengthMenu"	: "_MENU_ Registros por página",
	                	 "sInfo"		: "Mostrando de _START_ até _END_ de _TOTAL_ registros",
	                	 
	                	 "oPaginate"	: {
	                       "sFirst"		: "Primeiro",
	                       "sPrevious"	: "Anterior",
	                       "sNext"		: "Seguinte",
	                       "sLast"		: "Último"
	                     }
	                   },
	                 
	                 
	                 "fnServerData":

	                	 function ( sSource, aoData, fnCallback ) {
		                	 
	                	 	aoData.push( { "name": "initialDate", "value": $('#dataInicial').val() });
	                	 	aoData.push( { "name": "finalDate",   "value": $('#dataFinal').val()   });
	                	 	aoData.push( { "name": "msisdn", 	  "value": $('#msisdn').val()      });
	                	 	aoData.push( { "name": "messageType", "value": $('#messageType').val() });
	                	 
	                	 	$.ajax( {
		                				"dataType"	: 'json',
		                		 		"type"		: "POST",
		                		 		"url"		: sSource,
		                		 		"data"		: aoData,
		                		 		"success"	: fnCallback
		                	 	   } );
	                     },
	                                 
	                "fnDrawCallback"	: function ( oSettings ) {
	                	drawCallBack();
	                }
	                     
	       } );
			
		   $('#tableList').css("visibility","visible");
		}
		
		function drawCallBack() {
			
			$(oTable.fnSettings().aoData).each( function(key,value){
			  $(this.nTr).removeClass('odd');
			  $(this.nTr).removeClass('even');
			  $(this.nTr).addClass('nowrap');
			  
			  var iPos 		= oTable.fnGetPosition( this.nTr );
			  var aData 	= oTable.fnGetData( iPos );
			  var status 	= aData[0];
			  
			  if (status == 'ERROR') {
				this.nTr.cells[0].innerHTML 	= "<img src='/VirtualGoods/images/icon_error_25px.png' align='middle' id='" + aData[10] + "'>";	  
			  } else if (status == 'FLOW_END') {
				this.nTr.cells[0].innerHTML 	= "<img src='/VirtualGoods/images/icon_ok_25px.png' align='middle' id='" + aData[10] + "'>";
			  } else {
				  this.nTr.cells[0].innerHTML 	= "<img src='/VirtualGoods/images/icon_attention_25px.png' align='middle' id='" + aData[10] + "'>";  
			  }
			  
			});
		}	
		
		$('#tableList tbody tr').live( 'click', function () {
			
 			var nTr = this;
 			var id 	= $(this).find("td img:eq(0)").attr('id');
 			var url = $('#contextPath').val() + "/callCenter/detalhe/" + id;

			$.ajax({
				url : url,
				type : 'GET',
				async : false,
				cache : false,
				timeout : 30000,
				error : function() {
					return true;
				},
				success : function(data) {
					if (oTable.fnIsOpen(nTr)) {
						oTable.fnClose(nTr);
					} else {
						oTable.fnOpen(nTr, fnFormatDetails(nTr, data),'');
					}
				}
			});

		});

		function fnFormatDetails(nTr, list) {

			if (!list) {
				return;
			}
			var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
			for ( var i = 0; i < list.length; i++) {
				var object = list[i];
				var data 		 = object[0];
				var statusType 	 = object[2]; 
				var status 		 = object[3];
				
				
				if (object[2].length > 70) {
					statusFormat = object[2].substring(0,70);
				}
				
				sOut += '<tr><td><b><i>Data:</i></b></td><td class="nowrap"><i>'+data+'</i></td>';
				sOut += '<td class="nowrap"><b><i>Tipo de Status:</i></b></td><td class="nowrap"><i>' + statusType+'</i></td>';
				sOut += '<td><b><i>Status:</i></b></td><td><i>'+status+'</i></td></tr>';
				
// 				if (object[2].length > 70) {
// 					var initPos = object[2].indexOf("http");
// 					sOut += '<span class="hint" text="' + object[2].substring(initPos,object[2].length-1) + '">...&nbsp;&nbsp;&nbsp;&nbsp;</span>';
// 				}
// 				sOut += '</td></tr>';
			}

			sOut += '</table>';
			return sOut;
		}

		$("span.hint").live('mouseover mouseout', function(event) {
		   	  if (event.type == 'mouseover') {
		   		 $('div.tooltip').remove();
	       	  	 var content = '<div class="tooltip">' + $(this).attr("text") + '</div>';
	       	  	 $(content).appendTo('body');
	    	     var offset = $(this).parent().parent().offset();
	    	     $('div.tooltip').css({top: offset.top +15, left: offset.left});
  		   	  } else {
		   		 $('div.tooltip').remove();
		   	  }
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
    				  <form action="" method="post">
			      	  	<input type="hidden" name="contextPath" id="contextPath" value="<%=request.getContextPath()%>">
			      	  
			      	  <fieldset>
	    				  <div class="well" style="padding: 10px 19px;">
	       					 	<div class="clearfix">
						            <label for="xlInput">Data Inicial</label>
						            <div class="input">
						              <input class="span3" id="dataInicial" name="dataInicial" type="text" value="${dataInicial}"/>
						              <span class="help-block">11/09/2001</span>
						            </div>
					          	</div>
	       					 	<div class="clearfix">
						            <label for="xlInput">Data Final</label>
						            <div class="input">
						              <input class="span3" id="dataFinal" name="dataFinal" type="text" value="${dataFinal}"/>
						              <span class="help-block">11/09/2001</span>
						            </div>
					          	</div>
					          	
					          	<div class="clearfix">
						            <label for="xlInput">Telefone</label>
						            <div class="input">
						              <input class="span3" id="msisdn" name="msisdn" type="text" value="${msisdn}"/>
						              <span class="help-block">1198765432</span>
						            </div>
					          	</div>
					          	
					          	<div class="actions">
			            			<input type="button" class="btn primary" value="Pesquisar" onclick="query()">&nbsp;
			          			</div>
			          			
	      				  </div> 
      				  </fieldset>
      				  
							
							<table id="tableList" border="0" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" style="visibility: hidden;" class="bordered-table zebra-striped">
								<thead>
							
									<tr>
										<th>Status</th>
										<th>Data</th>
										<th>MSISDN</th>
										<th>Parceiro</th>
										<th>LA</th>
										<th>Keycode</th>
										<th>Operadora</th>
										<th>Tarifação</th>
										<th>Sharecode</th>
										<th>Campanha</th>
									</tr>
							
								</thead>
								<tbody>	<!-- DATA FROM DATABLE --></tbody>

							</table>
						
					</form>	
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