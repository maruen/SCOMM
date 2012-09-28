	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<c:if test="${empty usuarioLogado.usuario}">
	<div class="topbar">
		<div class="fill">
			<div class="container">
				<a class="brand" href="<c:url value="/" />">Virtual Goods</a>
				<ul class="nav">
					<!-- <li><a href="<c:url value="/" />">Usuários</a></li> -->					
				</ul>
				<form action="<c:url value="/usuario/login" />" class="pull-right" method="post">
					<input class="input-small" type="text" placeholder="Usuário" name="usuario.login" id="usuario.login" value="${usuario.login}">
					<input class="input-small" type="password" placeholder="Senha" name="usuario.senha" id="usuario.senha" value="${usuario.senha}">
					<button class="btn" type="submit">OK</button>
				</form>
			</div>
		</div>
	</div>
	</c:if>
	
	<c:if test="${not empty usuarioLogado.usuario}">
	
	<div id="modal-excluir" class="modal hide fade">
    </div>
	
	<div class="topbar" data-dropdown="dropdown" >
      <div class="topbar-inner">
        <div class="container">
          <h3><a href="<c:url value="/" />">Virtual Goods</a></h3>
          <ul class="nav">

            <li class="dropdown"><a href="#" class="dropdown-toggle">Cadastro</a>
              <ul class="dropdown-menu">
              	<li><a href="<c:url value="/usuario/list" />">Usuário</a></li>
	           	<li><a href="<c:url value="/la/list" />">LA</a></li>
	           	<li><a href="<c:url value="/sharecode/list" />">Sharecode</a></li>
	           	<li><a href="<c:url value="/parceiro/list" />">Parceiro</a></li>
	           	<li><a href="<c:url value="/keycode/list" />">Keycode</a></li>
	           	<li><a href="<c:url value="/regra/list" />">Regra</a></li>
	           	<li><a href="<c:url value="/tipoCampanha/list" />">Tipo Campanha</a></li>
	           	<li><a href="<c:url value="/campanha/list" />">Campanha</a></li>
              </ul>
            </li>

            <li class="dropdown"><a href="#" class="dropdown-toggle">Configurações</a>
              <ul class="dropdown-menu">
            	<li><a href="<c:url value="/generalConfig/form" />">Gerais</a></li>
            	<li><a href="<c:url value="/buyConfig/form" />">Compras</a></li>
              </ul>
            </li>
            
            <li><a href="<c:url value="/callCenter/form" />">Call Center</a></li>

          </ul>
          <ul class="nav secondary-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle">${usuarioLogado.usuario.nome}</a>
              <ul class="dropdown-menu">
              	<li><a href="<c:url value="/usuario/alterarSenha" />">Alterar senha</a></li>
                <li><a href="<c:url value="/usuario/logout" />">Logout</a></li>
              </ul>
            </li>
          </ul>          
        </div>
      </div><!-- /topbar-inner -->
    </div><!-- /topbar -->
    </c:if>