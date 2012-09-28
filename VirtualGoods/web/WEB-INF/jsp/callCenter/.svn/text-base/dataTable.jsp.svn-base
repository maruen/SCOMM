<%@ page import="br.com.supportcomm.virtualgoodscore.constantes.Operadora" %>
<%@ page import="br.com.supportcomm.virtualgoodscore.pojo.Transacao" %>

<table id="tableList" border="0" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0">
	<thead>

		<tr>
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
	<tbody>
		<c:forEach items="${transacaoList}" var="transacao" varStatus="it">
	
			<c:url var="link" value="/callCenter/detalhe/${transacao.mensagem.id }" />
			<tr  link="${link}" style="white-space: nowrap;">
	
			<td>${transacao.dtTransacaoFormat }</td>
			<td>${transacao.msisdn}</td>
			<td>${transacao.parceiro.nome}</td>
			<td>${transacao.la.nome}</td>
			<td>${transacao.keycode.nome}</td>
	
			<td>
				<c:forEach var="oper" items="<%= Operadora.values() %>">
					<c:if test="${oper.carrier eq transacao.operadora }">
						${oper.descricao}
	  				</c:if>
				</c:forEach>
			</td>
	
			<td>${transacao.valorTarifacao}</td>
			<td>${transacao.sharecode.nome}</td>
			<td>${transacao.campanha.nome}</td>
			</tr>
	
		</c:forEach>
	</tbody>
</table>