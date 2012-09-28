<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="../../../header.jsp"%>
<script type="text/javascript">
	
	function updateFields(obj) {
		toggle(obj.value);
	}

	function toggle(option) {
		hideAll();

		if (option != null && option == 1) {
			$(".simplified").show();
		} else if (option != null && option == 2) {
			$(".requiresAuthorization").show();
		} else if (option != null && option == 3) {
			$(".voucher").show();
		}

		if (option != null && option != 0 ) {
			$(".all").show();
			$(".actions").show();
		}

	}

	function hideAll() {
		$(".all").hide();
		$(".simplified").hide();
		$(".requiresAuthorization").hide();
		$(".voucher").hide();
		$(".actions").hide();
	}

	function selectParceiro(obj) {
		var contexto = $('#contextPath').val();

		if (obj.value > 0) {
			$.get(contexto + "/campanha/la/" + obj.value, null, function(data) {
				$('#divLa').html(data);
			}, 'html');

			$.get(contexto + "/campanha/keycode/" + obj.value, null, function(
					data) {
				$('#divKeycode').html(data);
			}, 'html');
		}

		$.get(contexto + "/campanha/regra/" + obj.value + "/0/0", null,
				function(data) {
					$('#divRegra').html(data);
				}, 'html');
	}

	function select() {
		var parceiro = document.getElementById("parceiro.id").value;
		var la = document.getElementById("la.id").value;
		var keycode = document.getElementById("keycode.id").value;
		var contexto = $('#contextPath').val();
		$.get(contexto + "/campanha/regra/" + parceiro + "/" + la + "/"	+ keycode, null, function(data) {
			$('#divRegra').html(data);
		}, 'html');
	}
</script>

</head>

<body onload="toggle( ${campanha.flowType}  )">

	<%@ include file="../../../menu.jsp"%>

	<div class="container">

		<div class="content">

			<section id="forms">
			<div class="page-header">
				<h2>Campanha</h2>
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

					<form action="<c:url value="/campanha/save" />" method="post" >
						<input type="hidden" name="campanha.id" id="campanha.id"
							value="${campanha.id}"> <input type="hidden"
							name="contextPath" id="contextPath"
							value="<%=request.getContextPath()%>">
						<fieldset>
							<%-- 							<legend>${campanha.id == null || campanha.id == 0 ?	'Nova Campanha' : 'Alterar Campanha' }</legend> --%>


								<div class="clearfix">
									<label for="xlInput">Descrição</label>
									<div class="input">
										<input class="xlarge" id="campanha.description"
											name="campanha.description" size="30" type="text"
											maxlength="50" value="${campanha.description}" />
									</div>
								</div>


							<div class="well">

								<h6>Selecione uma Regra</h6>
								<div class="clearfix">
									<label for="normalSelect">Parceiro</label>
									<div class="input">
										<select name="parceiro.id" id="parceiro.id"
											onchange="selectParceiro(this)">
											<option value="0">Selecione...</option>
											<c:forEach items="${parceiroList}" var="parceiro">
												<c:if test="${parceiro_selected.id == parceiro.id}">
													<option value="${parceiro.id}" selected="selected">${parceiro.nome}</option>
												</c:if>
												<c:if test="${parceiro_selected.id != parceiro.id}">
													<option value="${parceiro.id}">${parceiro.nome}</option>
												</c:if>

											</c:forEach>
										</select>
									</div>
								</div>

								<div class="clearfix">
									<label for="normalSelect">LA</label>
									<div class="input" id="divLa">
										<%@ include file="la.jsp"%>
									</div>
								</div>

								<div class="clearfix">
									<label for="normalSelect">Keycode</label>
									<div class="input" id="divKeycode">
										<%@ include file="keycode.jsp"%>
									</div>
								</div>


								<div class="clearfix" id="divRegra">
									<%@ include file="regra.jsp"%>
								</div>
							</div>


							<div class="clearfix">
								<label for="prependedInput2">Tipo de Fluxo</label>
								<div class="input">
									<div class="input-prepend">

										<select name="campanha.flowType" id="campanha.flowType"
											onchange="updateFields(this)">

											<option value="0">Selecione...</option>
											<c:if test="${not empty vgFlowList}">
												<c:forEach items="${vgFlowList}" var="vgFlow">

													<c:if test="${campanha.flowType == vgFlow.flowType}">
														<option value="${vgFlow.flowType}" selected="selected">${vgFlow.flowName}</option>
													</c:if>
													<c:if test="${campanha.flowType != vgFlow.flowType}">
														<option value="${vgFlow.flowType}">${vgFlow.flowName}</option>
													</c:if>

												</c:forEach>
											</c:if>

										</select>

									</div>
								</div>
							</div>

							<div class="simplified requiresAuthorization clearfix">
								<label for="xlInput">Keyword</label>
								<div class="input">
									<input class="xlarge" id="campanha.keyword"
										name="campanha.keyword" size="30" type="text" maxlength="50"
										value="${campanha.keyword}" />
								</div>
							</div>


							<div class="simplified requiresAuthorization voucher clearfix">
								<label for="xlInput">Nome Performance</label>
								<div class="input">
									<input class="xlarge" id="campanha.nomePortalVendaPerformance"
										name="campanha.nomePortalVendaPerformance" size="30"
										type="text" maxlength="50"
										value="${campanha.nomePortalVendaPerformance}" />
								</div>
							</div>

							<div class="requiresAuthorization clearfix">
								<label for="xlInput">URL Pedido</label>
								<div class="input">
									<input class="xlarge" id="campanha.urlPedido"
										name="campanha.urlPedido" size="30" type="text"
										maxlength="255" value="${campanha.urlPedido}" /> <span
										class="help-block">Exemplo:
										http://www.supportcomm.com.br/services</span>
								</div>
							</div>


							<div class="simplified requiresAuthorization clearfix">
								<label for="xlInput">URL Confirma Status</label>
								<div class="input">
									<input class="xlarge" id="campanha.urlConfirmStatus"
										name="campanha.urlConfirmStatus" size="30" type="text"
										maxlength="255" value="${campanha.urlConfirmStatus}" /> <span
										class="help-block">Exemplo:
										http://www.supportcomm.com.br/services</span>
								</div>
							</div>

							<div class="simplified requiresAuthorization voucher clearfix">
								<label for="normalSelect">Tipo Campanha</label>
								<div class="input">
									<select name="campanha.tipoCampanha.id"
										id="campanha.tipoCampanha.id">
										<option value="">selecione...</option>
										<c:forEach items="${tipoCampanhaList}" var="tipoCampanha">
											<c:if
												test="${campanha.tipoCampanha.id == null or campanha.tipoCampanha.id != tipoCampanha.id }">
												<option value="${tipoCampanha.id}">${tipoCampanha.sigla
													}</option>
											</c:if>
											<c:if
												test="${campanha.tipoCampanha.id != null and campanha.tipoCampanha.id == tipoCampanha.id }">
												<option value="${tipoCampanha.id}" selected="selected">${tipoCampanha.sigla}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="voucher clearfix">
								<label for="xlInput">SMS Option In</label>
								<div class="input">
									<c:if test="${campanha.mtOptionIn != null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtOptionIn" name="campanha.mtOptionIn">${campanha.mtOptionIn}</textarea>
									</c:if>
									<c:if test="${campanha.mtOptionIn == null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtOptionIn" name="campanha.mtOptionIn">${smsOptionIn}</textarea>
									</c:if>
								</div>
							</div>
							
							<div class="voucher clearfix">
								<label for="xlInput">SMS Voucher</label>
								<div class="input">
									<c:if test="${campanha.mtVoucher != null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtVoucher" name="campanha.mtVoucher">${campanha.mtVoucher}</textarea>
									</c:if>
									<c:if test="${campanha.mtVoucher == null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtVoucher" name="campanha.mtVoucher">${smsVoucher}</textarea>
									</c:if>
								</div>
							</div>

							<div class="all clearfix">
								<label for="xlInput">SMS Após Sucesso</label>
								<div class="input">
									<c:if test="${campanha.mtSuccess != null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtSuccess" name="campanha.mtSuccess">${campanha.mtSuccess}</textarea>
									</c:if>
									<c:if test="${campanha.mtSuccess == null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtSuccess" name="campanha.mtSuccess">${mtSuccessMessage}</textarea>
									</c:if>
								</div>
							</div>

							<div class="all clearfix">
								<label for="xlInput">SMS Após Falha</label>
								<div class="input">
									<c:if test="${campanha.mtSuccess != null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtFail" name="campanha.mtFail">${campanha.mtFail}</textarea>
									</c:if>
									<c:if test="${campanha.mtSuccess == null}">
										<textarea style="width: 500px; height: 82px;"
											id="campanha.mtFail" name="campanha.mtFail">${mtFailMessage}</textarea>
									</c:if>

								</div>
							</div>

							<div class="all clearfix">
								<label for="prependedInput2">Habilitado</label>
								<div class="input">
									<div class="input-prepend">
										<label class="add-on"> <c:if
												test="${campanha == null or campanha.habilitado == true}">
												<input type="checkbox" name="habilitado" id="habilitado"
													checked="checked" />
											</c:if> <c:if
												test="${campanha != null and campanha.habilitado == false}">
												<input type="checkbox" name="habilitado" id="habilitado" />
											</c:if>
										</label>
									</div>
								</div>
							</div>
							<div class="actions">
								<input type="submit" class="btn primary" value="Salvar">&nbsp;
							</div>
						</fieldset>
					</form>
				</div>
			</div>
			<!-- /row --> </section>
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>