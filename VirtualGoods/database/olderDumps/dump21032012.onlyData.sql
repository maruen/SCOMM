--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- Name: billing_record_failure_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('billing_record_failure_seq', 1, false);


--
-- Name: billing_record_success_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('billing_record_success_seq', 30, true);


--
-- Name: buying_limit_exceed_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('buying_limit_exceed_seq', 1, false);


--
-- Name: campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('campanha_seq', 2, true);


--
-- Name: historico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('historico_seq', 120, true);


--
-- Name: keycode_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('keycode_seq', 2, true);


--
-- Name: la_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('la_seq', 4, true);


--
-- Name: log_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('log_seq', 1, false);


--
-- Name: mensagem_resposta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mensagem_resposta_seq', 30, true);


--
-- Name: mensagem_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mensagem_seq', 30, true);


--
-- Name: parceiro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parceiro_seq', 2, true);


--
-- Name: protocol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('protocol_seq', 30, true);


--
-- Name: regra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('regra_seq', 4, true);


--
-- Name: sharecode_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sharecode_seq', 4, true);


--
-- Name: tipo_campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_campanha_seq', 3, true);


--
-- Name: transacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('transacao_seq', 30, true);


--
-- Name: usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_seq', 4, true);


--
-- Name: without_rule_msg_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('without_rule_msg_seq', 1, false);


--
-- Data for Name: parceiro; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO parceiro VALUES (3, 1, '2012-02-07 18:34:56', '2011-12-14 09:47:39', 'Tequila Mobile', 'Tequila Mobile', 3, 10);
INSERT INTO parceiro VALUES (2, 1, '2012-02-07 18:35:44', '2011-12-13 10:36:33', 'SupportComm', 'SupportCommVG', 3, 10);
INSERT INTO parceiro VALUES (4, 1, '2012-03-07 14:17:44', '2012-03-07 14:17:34', 'teste', 'teste', 5, 10);


--
-- Data for Name: keycode; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO keycode VALUES (1, 1, '2012-02-07 18:48:32', '2011-12-13 10:52:53', 'jg1', 2);
INSERT INTO keycode VALUES (4, 1, '2012-03-07 14:18:00', '2012-03-07 14:18:00', 'TesteSuppCl', 4);
INSERT INTO keycode VALUES (2, 1, '2012-03-12 17:16:11', '2011-12-14 10:43:01', 'term', 3);


--
-- Data for Name: la; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO la VALUES (2, 1, 1, 0, 0, 0, 0, 0, 'teste', '2011-12-09 16:46:53', '2011-12-09 16:46:53', 991, 'test1', 16, 'http://merc-inter.dc1.supp.com.br', 'scomm', 'SC0532');
INSERT INTO la VALUES (3, 1, 1, 0, 0, 1, 1, 1, 'LA de Navegação', '2011-12-14 10:13:19', '2011-12-14 10:13:19', 249, 'vgb4k', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49969');
INSERT INTO la VALUES (4, 1, 1, 0, 0, 0, 0, 1, 'LA de Navegação', '2012-01-26 19:49:01', '2012-01-23 15:56:38', 249, 'vgb4k', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49481');
INSERT INTO la VALUES (5, 1, 1, 0, 0, 0, 0, 1, 'LA de Navegação', '2012-01-26 19:49:13', '2012-01-23 15:57:23', 249, 'vgb4k', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49482');


--
-- Data for Name: mensagem; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: sharecode; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sharecode VALUES (3, 1, 'Tarifação de R$ 3,80', '2011-12-14 10:17:43', '2011-12-14 10:17:43', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49677', 10, 3.7999999999999998);
INSERT INTO sharecode VALUES (4, 1, 'Tarifação de R$ 5,70', '2011-12-14 10:18:56', '2011-12-14 10:18:56', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49692', 10, 5.7000000000000002);
INSERT INTO sharecode VALUES (5, 1, 'Tarifação de R$ 9,99', '2011-12-14 10:22:13', '2011-12-14 10:22:13', 246, 'virtualgoods', 16, 'http://merc-inter.dc1.supp.com.br', 'vgb1k', '49681', 10, 9.9900000000000002);
INSERT INTO sharecode VALUES (6, 1, 'Tarifação de R$ 1,99 + Imp', '2012-01-23 15:52:31', '2012-01-23 15:52:31', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72754', 10, 1.99);
INSERT INTO sharecode VALUES (7, 1, 'Tarifação de R$ 4,00 + Imp', '2012-01-23 15:53:30', '2012-01-23 15:53:30', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72755', 10, 4);
INSERT INTO sharecode VALUES (8, 1, 'Tarifação de R$ 9,90', '2012-01-23 15:54:12', '2012-01-23 15:54:12', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72756', 10, 9.9000000000000004);
INSERT INTO sharecode VALUES (9, 1, 'Tarifação de R$ 1,00', '2012-01-23 15:54:57', '2012-01-23 15:54:57', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72757', 10, 1);
INSERT INTO sharecode VALUES (2, 1, 'Tarifação 0,99', '2012-03-08 17:34:09', '2011-12-09 16:50:54', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0821', 5, 0.98999999999999999);
INSERT INTO sharecode VALUES (10, 1, 'Tarifação 1,99 + imp', '2012-03-08 17:35:59', '2012-03-07 14:23:21', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0822', 5, 1.99);
INSERT INTO sharecode VALUES (11, 1, 'Tarifação 2,99', '2012-03-08 17:36:37', '2012-03-08 17:36:37', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0823', 5, 2.9900000000000002);
INSERT INTO sharecode VALUES (12, 1, 'Tarifação 3,99 + imp', '2012-03-08 17:37:23', '2012-03-08 17:37:23', 246, 'vgbk1', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0824', 5, 3.9900000000000002);


--
-- Data for Name: regra; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO regra VALUES (8, 1, '2012-03-07 14:24:07', '2012-03-07 14:19:19', 'Regra Teste Cl', 4, 10, NULL, 2, 4, NULL, NULL, NULL, NULL, 1);
INSERT INTO regra VALUES (3, 1, '2012-03-08 17:38:42', '2011-12-14 11:15:00', 'Tarifa 3', 3, 12, NULL, 4, 2, 7, NULL, NULL, NULL, 0);
INSERT INTO regra VALUES (2, 1, '2012-03-08 17:38:57', '2011-12-14 11:15:00', 'Tarifa 2', 3, 10, NULL, 4, 2, 6, NULL, NULL, NULL, 0);
INSERT INTO regra VALUES (1, 1, '2012-03-12 17:19:51', '2011-12-14 11:15:00', 'Tarifa 1', 3, 2, NULL, 4, 2, 9, NULL, NULL, NULL, 0);
INSERT INTO regra VALUES (6, 1, '2012-03-12 17:19:59', '2011-12-19 10:06:53', 'Regra SC Tarifa 1', 2, 2, NULL, 4, 1, 9, NULL, NULL, NULL, 0);
INSERT INTO regra VALUES (7, 1, '2012-03-16 10:03:52', '2012-01-23 16:02:29', 'Tarifa 4', 3, NULL, NULL, 4, 2, 8, NULL, NULL, NULL, 0);


--
-- Data for Name: transacao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: billing_record_failure; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: billing_record_success; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: buy_config; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO buy_config VALUES (4, 20, 10, 0, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 10:47:58', '2012-03-07 10:46:43');
INSERT INTO buy_config VALUES (3, 15, 15, 0, NULL, 'Voce atingiu o limite mensal de compras!', '2012-03-07 10:48:12', '2012-03-07 10:46:24');
INSERT INTO buy_config VALUES (9, 25.100000000000001, NULL, 1, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 14:45:24', '2012-03-07 10:46:57');
INSERT INTO buy_config VALUES (7, 10, 10, 0, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 14:56:25', '2012-03-07 10:46:01');
INSERT INTO buy_config VALUES (10, 5000, 12, 1, 1, 'Você ultrapassou o limite de compras para este mês, vivo, a melhor escolha ;)', '2012-03-13 15:04:02', '2012-03-06 18:52:59');
INSERT INTO buy_config VALUES (5, 5000, NULL, 1, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-16 16:55:57', '2012-03-07 09:14:31');


--
-- Data for Name: buying_limit_exceed; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: tipo_campanha; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_campanha VALUES (1, 1, '2011-12-14 11:15:00', '2011-12-14 11:15:00', 'Freemium Games', 'Free');
INSERT INTO tipo_campanha VALUES (2, 1, '2012-03-07 14:24:16', '2011-12-19 10:18:43', 'Teste SuppCl', 'Supp');


--
-- Data for Name: campanha; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO campanha VALUES (6, 1, '2012-03-20 12:22:39.622', '2012-01-23 16:04:08', 'TG4', 'Tequila Mobile', 'http://194.50.53.90:13083/sms', 'http://194.50.53.90:13083/sms', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 7);
INSERT INTO campanha VALUES (1, 1, '2012-03-20 12:22:44.794', '2011-12-14 11:18:00', 'TG1', 'Tequila Mobile', 'http://192.168.3.46:8181/api/API_VG_Confirma.asp', 'http://192.168.3.46:8181/api/API_VG_Confirma.asp', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 1);
INSERT INTO campanha VALUES (2, 1, '2012-03-20 12:22:56.419', '2011-12-14 11:23:00', 'TG2', 'Tequila Mobile', 'http://194.50.53.90:13083/sms', 'http://194.50.53.90:13083/sms', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 2);
INSERT INTO campanha VALUES (3, 1, '2012-03-20 12:23:02.856', '2011-12-14 11:25:00', 'TG3', 'Tequila Mobile', 'http://194.50.53.90:13083/sms', 'http://194.50.53.90:13083/sms', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 3);
INSERT INTO campanha VALUES (5, 0, '2012-03-20 12:23:09.059', '2012-01-19 15:10:19', 'TesteSuppcl', 'SC VirtualGoods ', 'http://192.168.3.46:8181/api/API_VG_Confirma.asp', 'http://192.168.3.46:8181/api/API_VG_Pedido.asp', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 8);


--
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: logger_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO logger_message VALUES (1, 'Não foi encontrada nenhuma configuração de restrição de compras para a operadora %s, a compra será processada normalmente');
INSERT INTO logger_message VALUES (4, 'Erro ao verificar o limite de compras: %s');
INSERT INTO logger_message VALUES (5, 'Requisição inválida: %s');
INSERT INTO logger_message VALUES (6, 'Requisição inválida. Revise o XML de entrada.');
INSERT INTO logger_message VALUES (7, 'LA nao encontrada no sistema: %s');
INSERT INTO logger_message VALUES (8, 'Erro indefinido no SMSMOController: %s');
INSERT INTO logger_message VALUES (10, 'Valor máximo de compras já foi atingido nestes últimos %i dias, valor total comprado foi de : %d');
INSERT INTO logger_message VALUES (9, 'Valor total de compras já realizado nestes últimos %i dias foi de : %d');
INSERT INTO logger_message VALUES (2, 'Valor máximo de compras atingido para o mês corrente, valor total comprado foi de : %d');
INSERT INTO logger_message VALUES (3, 'Valor total comprado no mês corrente foi de : %d');
INSERT INTO logger_message VALUES (11, 'O campo valor máximo não pode ser vazio');
INSERT INTO logger_message VALUES (12, 'O campo número de dias não pode ser vazio');
INSERT INTO logger_message VALUES (13, 'Configuração salva com sucesso!');
INSERT INTO logger_message VALUES (14, 'Selecione uma operadora');
INSERT INTO logger_message VALUES (15, 'O Limite máximo de caracteres para este campo é de 138');


--
-- Data for Name: mensagem_resposta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: operadora; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO operadora VALUES (9, 'TIM');
INSERT INTO operadora VALUES (4, 'OI');
INSERT INTO operadora VALUES (3, 'NEXTEL');
INSERT INTO operadora VALUES (7, 'CTBC');
INSERT INTO operadora VALUES (5, 'CLARO');
INSERT INTO operadora VALUES (10, 'VIVO');


--
-- Data for Name: parceiro_la; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO parceiro_la VALUES (3, 4);
INSERT INTO parceiro_la VALUES (2, 4);
INSERT INTO parceiro_la VALUES (4, 2);


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario VALUES (2, 1, '2012-01-19 10:55:52.048', '2012-01-19 10:55:18.422', 'fabio.brandao3@supportcomm.com.br', 'fabio', 'Fábio Brandão', 'Administrador', 'yO0bD6NoL1FnPfEioZdY0g');
INSERT INTO usuario VALUES (3, 1, '2012-02-13 16:54:09.884', '2012-02-13 16:54:09.884', 'denis.villegas3@supportcomm.com.br', 'denis', 'Denis Hoffmeister Villegas', 'Administrador', 'ysnZcVMY8uAkc19VnQRLWQ');
INSERT INTO usuario VALUES (4, 1, '2012-02-15 11:56:32.717', '2012-02-15 11:55:33.426', 'maruen.mehana@suportcomm.com.br', 'maruen', 'Maruen Mehana', 'Administrador', 'mb+Ngy3WQFAkc19VnQRLWQ');
INSERT INTO usuario VALUES (6, 1, '2012-02-02 17:12:05', '2012-02-02 17:09:17', 'marcio.silva@supportcomm.com.br', 'marcio.silva', 'Marcio Silva', 'Administrador', '7NbJeEvsW6z3vHT0D62Vtg');
INSERT INTO usuario VALUES (1, 1, '2011-12-09 11:52:19', '2011-12-09 11:50:56', 'gabrielle.sanches@supportcomm.com.br', 'gabrielle', 'gabrielle sanches', 'Administrador', 'vloVjo7YnS8');


--
-- Data for Name: vg_config; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO vg_config VALUES (1, 'sms.success.default', 'SMS default sucesso', 'mensagem enviada após sucesso em billing');
INSERT INTO vg_config VALUES (2, 'sms.fail.default', 'SMS default de falha', 'mensagem enviada após falha no processo de compra');


--
-- Data for Name: without_rule_msg; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- PostgreSQL database dump complete
--

