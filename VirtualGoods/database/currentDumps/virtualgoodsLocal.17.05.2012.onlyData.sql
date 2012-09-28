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
-- Name: billing_record_failure_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('billing_record_failure_seq', 22, true);


--
-- Name: billing_record_success_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('billing_record_success_seq', 280, true);


--
-- Name: buying_limit_exceed_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('buying_limit_exceed_seq', 59, true);


--
-- Name: campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('campanha_seq', 12, true);


--
-- Name: double_optin_message_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('double_optin_message_seq', 1, false);


--
-- Name: duplicated_message_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('duplicated_message_seq', 50, true);


--
-- Name: historico_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('historico_seq', 2154, true);


--
-- Name: keycode_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('keycode_seq', 3, true);


--
-- Name: la_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('la_seq', 4, true);


--
-- Name: log_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('log_seq', 1, false);


--
-- Name: mensagem_resposta_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('mensagem_resposta_seq', 485, true);


--
-- Name: mensagem_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('mensagem_seq', 520, true);


--
-- Name: option_in_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('option_in_seq', 16, true);


--
-- Name: parceiro_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('parceiro_seq', 4, true);


--
-- Name: protocol_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('protocol_seq', 280, true);


--
-- Name: regra_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('regra_seq', 5, true);


--
-- Name: sharecode_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('sharecode_seq', 4, true);


--
-- Name: tipo_campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('tipo_campanha_seq', 4, true);


--
-- Name: transacao_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('transacao_seq', 352, true);


--
-- Name: usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('usuario_seq', 5, true);


--
-- Name: vg_flow_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('vg_flow_seq', 1, false);


--
-- Name: voucher_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('voucher_seq', 24, true);


--
-- Name: without_campaign_msg_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('without_campaign_msg_seq', 17, true);


--
-- Data for Name: parceiro; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO parceiro VALUES (4, 1, '2012-05-03 10:02:30.074', '2012-05-03 10:02:30.074', 'Mehana & Mehana', 'Mehana Performance', 3, 1, 10);
INSERT INTO parceiro VALUES (3, 1, '2012-05-16 09:25:29.69', '2011-12-14 09:47:39', 'Tequila Mobile', 'Tequila Mobile', 3, 10, 7);


--
-- Data for Name: keycode; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO keycode VALUES (2, 1, '2012-04-18 16:19:31.488', '2011-12-14 10:43:01', 'vg0001', 3);
INSERT INTO keycode VALUES (3, 1, '2012-05-03 10:03:53.388', '2012-05-03 10:03:47.113', 'vg0002', 4);


--
-- Data for Name: la; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO la VALUES (4, 1, 1, 0, 0, 0, 0, 1, 'LA de Navegação', '2012-04-18 15:50:51.156', '2012-01-23 15:56:38', 249, 'vgb4kh', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49481');
INSERT INTO la VALUES (5, 1, 1, 0, 0, 0, 0, 1, 'LA de Navegação', '2012-04-18 15:51:03.655', '2012-01-23 15:57:23', 249, 'vgb4kh', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49482');


--
-- Data for Name: mensagem; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO mensagem VALUES (518, 'vg0001 00001', '553197547176', 10, '2012-05-17 09:13:20.947', '2012-05-17 09:13:20.947', 4, 'FLOW_START');
INSERT INTO mensagem VALUES (519, 'vg0001 00002', '553197547176', 10, '2012-05-17 09:16:19.933', '2012-05-17 09:16:19.933', 4, 'FLOW_START');
INSERT INTO mensagem VALUES (520, 'Vg0002', '553197547176', 10, '2012-05-17 09:20:38.69', '2012-05-17 09:20:38.69', 5, 'FLOW_START');


--
-- Data for Name: sharecode; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO sharecode VALUES (8, 1, 'Tarifação de R$ 9,90', '2012-04-18 16:14:06.558', '2012-01-23 15:54:12', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72756', 10, 9.9000000000000004);
INSERT INTO sharecode VALUES (7, 1, 'Tarifação de R$ 4,00 + Imp', '2012-04-18 16:14:32.574', '2012-01-23 15:53:30', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72755', 10, 4);
INSERT INTO sharecode VALUES (9, 1, 'Tarifação de R$ 1,00', '2012-04-18 16:14:53.585', '2012-01-23 15:54:57', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72757', 10, 1);
INSERT INTO sharecode VALUES (2, 1, 'Tarifação 0,99', '2012-04-18 16:15:01.101', '2011-12-09 16:50:54', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0821', 5, 0.98999999999999999);
INSERT INTO sharecode VALUES (10, 1, 'Tarifação 1,99 + imp', '2012-04-18 16:15:08.727', '2012-03-07 14:23:21', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0822', 5, 1.99);
INSERT INTO sharecode VALUES (11, 1, 'Tarifação 2,99', '2012-04-18 16:15:16.521', '2012-03-08 17:36:37', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0823', 5, 2.9900000000000002);
INSERT INTO sharecode VALUES (3, 1, 'Tarifação de R$ 3,80', '2012-04-18 16:15:24.437', '2011-12-14 10:17:43', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49677', 10, 3.7999999999999998);
INSERT INTO sharecode VALUES (4, 1, 'Tarifação de R$ 5,70', '2012-04-18 16:15:31.245', '2011-12-14 10:18:56', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '49692', 10, 5.7000000000000002);
INSERT INTO sharecode VALUES (6, 1, 'Tarifação de R$ 1,99 + Imp', '2012-04-18 16:15:37.605', '2012-01-23 15:52:31', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', '72754', 10, 1.99);
INSERT INTO sharecode VALUES (12, 1, 'Tarifação 3,99 + imp', '2012-04-18 16:15:43.955', '2012-03-08 17:37:23', 248, 'vgbk1h', 16, 'http://merc-inter.dc1.supp.com.br', 'virtualgoods', 'SC0824', 5, 3.9900000000000002);


--
-- Data for Name: regra; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO regra VALUES (1, 1, '2012-03-12 17:19:51', '2011-12-14 11:15:00', 'Tarifa 1', 3, 2, NULL, 4, 2, 9, NULL, NULL, NULL);
INSERT INTO regra VALUES (3, 0, '2012-04-27 14:16:04.937', '2011-12-14 11:15:00', 'Tarifa 3', 3, 12, NULL, 4, 2, 7, NULL, NULL, NULL);
INSERT INTO regra VALUES (7, 0, '2012-04-27 14:35:32.828', '2012-01-23 16:02:29', 'Tarifa 4', 3, NULL, NULL, 4, 2, 8, NULL, NULL, NULL);
INSERT INTO regra VALUES (2, 0, '2012-04-27 15:23:12.121', '2011-12-14 11:15:00', 'Tarifa 2', 3, 10, NULL, 4, 2, 6, NULL, NULL, NULL);
INSERT INTO regra VALUES (5, 0, '2012-05-03 10:04:27.619', '2012-05-03 10:04:27.619', 'Tarifa 1', 4, 2, NULL, 5, 3, 9, NULL, NULL, NULL);


--
-- Data for Name: transacao; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO transacao VALUES (350, '2012-05-17 09:13:20.947', '2012-05-17 09:13:20.947', '553197547176', 10, 1, 2, 1, 9, 518, 3, 4, 1, 0, 'TRANSACTION_FINISHED');
INSERT INTO transacao VALUES (351, '2012-05-17 09:16:19.933', '2012-05-17 09:16:19.933', '553197547176', 10, 1.99, 2, 2, 6, 519, 3, 4, 2, 0, 'TRANSACTION_FINISHED');
INSERT INTO transacao VALUES (352, '2012-05-17 09:20:38.69', '2012-05-17 09:20:38.69', '553197547176', 10, 1, 3, 12, 9, 520, 4, 5, 5, 0, 'TRANSACTION_FINISHED');


--
-- Data for Name: billing_record_failure; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--



--
-- Data for Name: billing_record_success; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO billing_record_success VALUES (278, 350, 278, 1, '553197547176', 10, 1, '2012-05-17 09:13:20.947');
INSERT INTO billing_record_success VALUES (279, 351, 279, 1, '553197547176', 10, 1.99, '2012-05-17 09:16:19.933');
INSERT INTO billing_record_success VALUES (280, 352, 280, 1, '553197547176', 10, 1, '2012-05-17 09:20:38.69');


--
-- Data for Name: buy_config; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO buy_config VALUES (4, 20, 10, 0, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 10:47:58', '2012-03-07 10:46:43');
INSERT INTO buy_config VALUES (3, 15, 15, 0, NULL, 'Voce atingiu o limite mensal de compras!', '2012-03-07 10:48:12', '2012-03-07 10:46:24');
INSERT INTO buy_config VALUES (9, 25.100000000000001, NULL, 1, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 14:45:24', '2012-03-07 10:46:57');
INSERT INTO buy_config VALUES (7, 10, 10, 0, 1, 'Voce atingiu o limite mensal de compras!', '2012-03-07 14:56:25', '2012-03-07 10:46:01');
INSERT INTO buy_config VALUES (5, 0, 0, 0, 1, 'Voce atingiu o limite mensal de compras!', '2012-04-12 09:40:47.051', '2012-03-07 09:14:31');
INSERT INTO buy_config VALUES (10, 20, 0, 0, 1, 'Voce ultrapassou o limite de compras para este mes. Vivo, a melhor escolha ;)', '2012-04-13 14:12:42.604', '2012-03-06 18:52:59');


--
-- Data for Name: buying_limit_exceed; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--



--
-- Data for Name: tipo_campanha; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO tipo_campanha VALUES (1, 1, '2011-12-14 11:15:00', '2011-12-14 11:15:00', 'Freemium Games', 'Free');
INSERT INTO tipo_campanha VALUES (4, 1, '2012-05-03 10:05:48.07', '2012-05-03 10:05:48.07', 'Armies ', 'Army');


--
-- Data for Name: campanha; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO campanha VALUES (8, 1, '2012-05-15 14:56:48.312', '2012-05-02 13:56:38.522', 'vg0001', 'PerformanceVoucher', '', '', 'Compra realizada com Sucesso, com protocolo %p', 'Houve uma falha e a sua compra nao foi realizada. Tente novamente mais tarde. ', 1, 1, 'Campanha 5', 3, 'Responda com SIM para aceitar a compra.', 'Seu voucher de acesso é %v');
INSERT INTO campanha VALUES (1, 1, '2012-05-02 11:30:21.781', '2011-12-14 11:18:00', '00001', 'PerformanceVoucher', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 1, 'Campanha 1', 2, NULL, NULL);
INSERT INTO campanha VALUES (2, 1, '2012-05-02 17:54:29.651', '2011-12-14 11:23:00', '00002', 'Tequila Mobile', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 2, 'Campanha 2', 1, NULL, NULL);
INSERT INTO campanha VALUES (3, 1, '2012-05-02 11:19:30.483', '2011-12-14 11:25:00', '00003', 'Tequila Mobile', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 3, 'Campanha 3', 1, NULL, NULL);
INSERT INTO campanha VALUES (6, 1, '2012-05-02 11:19:46.811', '2012-01-23 16:04:08', '00004', 'Tequila Mobile', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth', 'Compra realizada com sucesso, o protocolo é %p', 'Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!', 1, 7, 'Campanha 4', 1, NULL, NULL);
INSERT INTO campanha VALUES (12, 1, '2012-05-17 09:24:25.23', '2012-05-03 10:06:34.308', 'vg0002', 'MehanaPerformance', '', '', 'Compra realizada com sucesso com protocolo %p', 'Houve uma falha e a sua compra nao foi realizada. Tente novamente mais tarde. ', 4, 5, 'Campanha 6', 3, 'Digite SIM para realizar a compra de 1.00 + Impostos', 'Seu voucher de acesso:  %v');


--
-- Data for Name: duplicated_message; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--



--
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO historico VALUES (2127, '2012-05-17 09:13:20.947', '553197547176', 10, 0, 'vg0001 00001', NULL, 0, 4, NULL, 518, 'FLOW_START', 'FLOW_START');
INSERT INTO historico VALUES (2128, '2012-05-17 09:13:23.399', '553197547176', 10, 1, NULL, 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10', 1, 4, 3, 518, 'PROCESS_TRANSACTION', 'PROCESS_TRANSACTION');
INSERT INTO historico VALUES (2129, '2012-05-17 09:13:23.474', '553197547176', 10, 1, 'OK', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10', 1, 4, 3, 518, 'ASK_PARTNER_AUTHORIZATION', 'ASK_PARTNER_AUTHORIZATION_SENT');
INSERT INTO historico VALUES (2130, '2012-05-17 09:14:08.49', '553197547176', 10, 0, 'Autorização Rebebida do Host: 127.0.0.1', NULL, 0, 4, 3, 518, 'WAIT_PARTNER_AUTHORIZATION', 'TRANSACTION_AUTHORIZED');
INSERT INTO historico VALUES (2131, '2012-05-17 09:14:23.479', '553197547176', 10, 1, NULL, 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10', 1, 4, 3, 518, 'PROCESS_BILLING', 'PROCESS_BILLING');
INSERT INTO historico VALUES (2132, '2012-05-17 09:14:23.653', '553197547176', 10, 1, 'CHARGED', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10', 1, 4, 3, 518, 'PROCESS_BILLING', 'BILLING_SUCCESS');
INSERT INTO historico VALUES (2133, '2012-05-17 09:14:38.481', '553197547176', 10, 1, 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10&binfo=null', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10&binfo=null', 1, 4, 3, 518, 'PROCESS_TRANSACTION_RESPONSE', 'PROCESS_TRANSACTION_RESPONSE');
INSERT INTO historico VALUES (2134, '2012-05-17 09:14:38.513', '553197547176', 10, 1, 'Compra realizada com sucesso, o protocolo é 0151200000000278', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10', 1, 4, 3, 518, 'SEND_MT_MESSAGE', 'MT_SENT');
INSERT INTO historico VALUES (2135, '2012-05-17 09:14:38.558', '553197547176', 10, 1, 'OK', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00001&mid=518&sc=49481&operator=10&binfo=null', 1, 4, 3, 518, 'PROCESS_TRANSACTION_RESPONSE', 'TRANSACTION_RESPONSE_SENT');
INSERT INTO historico VALUES (2136, '2012-05-17 09:14:53.465', '553197547176', 10, 1, '77', NULL, 1, 4, 3, 518, 'FLOW_END', 'FLOW_END');
INSERT INTO historico VALUES (2137, '2012-05-17 09:16:19.933', '553197547176', 10, 0, 'vg0001 00002', NULL, 0, 4, NULL, 519, 'FLOW_START', 'FLOW_START');
INSERT INTO historico VALUES (2138, '2012-05-17 09:16:23.371', '553197547176', 10, 1, NULL, 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10', 1.99, 4, 3, 519, 'PROCESS_BILLING', 'PROCESS_BILLING');
INSERT INTO historico VALUES (2139, '2012-05-17 09:16:23.488', '553197547176', 10, 1, 'CHARGED', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10', 1.99, 4, 3, 519, 'PROCESS_BILLING', 'BILLING_SUCCESS');
INSERT INTO historico VALUES (2140, '2012-05-17 09:16:38.431', '553197547176', 10, 1, 'Compra realizada com sucesso, o protocolo é 0151200000000279', 'http://192.168.3.199:8080/VirtualGoodsSimulator/ask_auth?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10', 1.99, 4, 3, 519, 'SEND_MT_MESSAGE', 'MT_SENT');
INSERT INTO historico VALUES (2141, '2012-05-17 09:16:38.439', '553197547176', 10, 1, 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10&binfo=null', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10&binfo=null', 1.99, 4, 3, 519, 'PROCESS_TRANSACTION_RESPONSE', 'PROCESS_TRANSACTION_RESPONSE');
INSERT INTO historico VALUES (2142, '2012-05-17 09:16:38.502', '553197547176', 10, 1, 'OK', 'http://192.168.3.199:8080/VirtualGoodsSimulator/confirm_billing?msisdn=553197547176&message=vg0001 00002&mid=519&sc=49481&operator=10&binfo=null', 1.99, 4, 3, 519, 'PROCESS_TRANSACTION_RESPONSE', 'TRANSACTION_RESPONSE_SENT');
INSERT INTO historico VALUES (2143, '2012-05-17 09:16:53.404', '553197547176', 10, 1, '18', NULL, 1.99, 4, 3, 519, 'FLOW_END', 'FLOW_END');
INSERT INTO historico VALUES (2144, '2012-05-17 09:20:38.69', '553197547176', 10, 0, 'Vg0002', NULL, 0, 5, NULL, 520, 'FLOW_START', 'FLOW_START');
INSERT INTO historico VALUES (2145, '2012-05-17 09:20:53.401', '553197547176', 10, 1, NULL, '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'PROCESS_TRANSACTION', 'PROCESS_TRANSACTION');
INSERT INTO historico VALUES (2146, '2012-05-17 09:20:53.525', '553197547176', 10, 1, NULL, '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'WAIT_OPTION_IN_ANSWER', 'WAITING_OPTION_IN_ANSWER');
INSERT INTO historico VALUES (2147, '2012-05-17 09:21:08.435', '553197547176', 10, 1, 'Digite SIM para realizar a compra ', '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'SEND_OPTION_IN', 'OPTION_IN_SENT');
INSERT INTO historico VALUES (2148, '2012-05-17 09:22:13.826', '553197547176', 10, 1, 'Sim', NULL, 1, 5, 4, 520, 'WAIT_OPTION_IN_ANSWER', 'TRANSACTION_AUTHORIZED');
INSERT INTO historico VALUES (2149, '2012-05-17 09:22:23.491', '553197547176', 10, 1, NULL, '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'PROCESS_BILLING', 'PROCESS_BILLING');
INSERT INTO historico VALUES (2150, '2012-05-17 09:22:23.641', '553197547176', 10, 1, 'CHARGED', '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'PROCESS_BILLING', 'BILLING_SUCCESS');
INSERT INTO historico VALUES (2151, '2012-05-17 09:22:23.732', '553197547176', 10, 1, '6ea07a62a', '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'GENERATE_VOUCHER', 'VOUCHER_GENERATED');
INSERT INTO historico VALUES (2152, '2012-05-17 09:22:38.409', '553197547176', 10, 1, 'Compra realizada com sucesso com protocolo 0151200000000280', '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'SEND_MT_MESSAGE', 'MT_SENT');
INSERT INTO historico VALUES (2153, '2012-05-17 09:22:38.509', '553197547176', 10, 1, 'Seu voucher de acesso é 6ea07a62a', '?msisdn=553197547176&message=Vg0002&mid=520&sc=49482&operator=10', 1, 5, 4, 520, 'SEND_VOUCHER', 'VOUCHER_SENT');
INSERT INTO historico VALUES (2154, '2012-05-17 09:22:53.407', '553197547176', 10, 1, '119', NULL, 1, 5, 4, 520, 'FLOW_END', 'FLOW_END');


--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--



--
-- Data for Name: logger_message; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO logger_message VALUES (18, 'O campo %s não pode ser vazio', 'empty_field');
INSERT INTO logger_message VALUES (19, 'Selecione um%s', 'select_field');
INSERT INTO logger_message VALUES (20, 'Já existe uma campanha com este nome', 'generic');
INSERT INTO logger_message VALUES (4, 'Erro ao verificar o limite de compras: %s', 'generic');
INSERT INTO logger_message VALUES (7, 'LA nao encontrada no sistema: %s', 'generic');
INSERT INTO logger_message VALUES (8, 'Erro indefinido no SMSMOController: %s', 'generic');
INSERT INTO logger_message VALUES (12, 'O campo número de dias não pode ser vazio', 'generic');
INSERT INTO logger_message VALUES (13, 'Configuração salva com sucesso!', 'generic');
INSERT INTO logger_message VALUES (15, 'O Limite máximo de caracteres para este campo é de 138', 'generic');
INSERT INTO logger_message VALUES (16, 'O Limite máximo de caracteres para o campo %s é de 138', 'generic');
INSERT INTO logger_message VALUES (17, 'Informe um valor numérico válido para o campo %s', 'generic');
INSERT INTO logger_message VALUES (1, 'Nao foi encontrada nenhuma configuracao de restricao de compras para a operadora %s, a compra sera processada normalmente', 'generic');
INSERT INTO logger_message VALUES (5, 'Requisicao invalida: %s', 'generic');
INSERT INTO logger_message VALUES (6, 'Requisição invalida. Revise o XML de entrada.', 'generic');
INSERT INTO logger_message VALUES (10, 'Valor maximo de compras ja foi atingido nestes ultimos %i dias, valor total comprado foi de : %d', 'generic');
INSERT INTO logger_message VALUES (9, 'Valor total de compras ja realizado nestes ultimos %i dias foi de : %d', 'generic');
INSERT INTO logger_message VALUES (2, 'Valor maximo de compras atingido para o mes corrente, valor total comprado foi de : %d', 'generic');
INSERT INTO logger_message VALUES (3, 'Valor total comprado no mes corrente foi de : %d', 'generic');
INSERT INTO logger_message VALUES (11, 'O campo valor maximo nao pode ser vazio', 'generic');
INSERT INTO logger_message VALUES (14, 'Selecione uma operadora', 'generic');
INSERT INTO logger_message VALUES (21, 'Já existe o voucher %s cadastrado no sistema.', 'generic');
INSERT INTO logger_message VALUES (23, 'Transacao de Voucher %s para o Msisdn %s referente a Transacao de número %s finalizada as %s', 'voucher_canceled');
INSERT INTO logger_message VALUES (22, 'Transacao de Voucher %s para o Msisdn %s referente a Transacao de numero %s autorizada as %s', 'voucher_authorized');


--
-- Data for Name: mensagem_resposta; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO mensagem_resposta VALUES (481, 'Compra realizada com sucesso, o protocolo é 0151200000000278', '553197547176', 10, '2012-05-17 09:14:38.484', '2012-05-17 09:14:38.484', 4, 518, 'MT_SENT');
INSERT INTO mensagem_resposta VALUES (482, 'Compra realizada com sucesso, o protocolo é 0151200000000279', '553197547176', 10, '2012-05-17 09:16:38.414', '2012-05-17 09:16:38.414', 4, 519, 'MT_SENT');
INSERT INTO mensagem_resposta VALUES (483, 'Digite SIM para realizar a compra ', '553197547176', 10, '2012-05-17 09:21:08.412', '2012-05-17 09:21:08.412', 5, 520, 'MT_SENT');
INSERT INTO mensagem_resposta VALUES (484, 'Compra realizada com sucesso com protocolo 0151200000000280', '553197547176', 10, '2012-05-17 09:22:38.393', '2012-05-17 09:22:38.393', 5, 520, 'MT_SENT');
INSERT INTO mensagem_resposta VALUES (485, 'Seu voucher de acesso é 6ea07a62a', '553197547176', 10, '2012-05-17 09:22:38.502', '2012-05-17 09:22:38.502', 5, 520, 'VOUCHER_SENT');


--
-- Data for Name: operadora; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO operadora VALUES (9, 'TIM');
INSERT INTO operadora VALUES (4, 'OI');
INSERT INTO operadora VALUES (3, 'NEXTEL');
INSERT INTO operadora VALUES (7, 'CTBC');
INSERT INTO operadora VALUES (5, 'CLARO');
INSERT INTO operadora VALUES (10, 'VIVO');


--
-- Data for Name: option_in; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO option_in VALUES (16, 352, 12, 1, '553197547176', 10, 1, '2012-05-17 09:20:53.409', '2012-05-17 09:22:13.837', 1);


--
-- Data for Name: parceiro_la; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO parceiro_la VALUES (3, 4);
INSERT INTO parceiro_la VALUES (4, 5);


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO usuario VALUES (2, 1, '2012-01-19 10:55:52.048', '2012-01-19 10:55:18.422', 'fabio.brandao3@supportcomm.com.br', 'fabio', 'Fábio Brandão', 'Administrador', 'yO0bD6NoL1FnPfEioZdY0g');
INSERT INTO usuario VALUES (3, 1, '2012-02-13 16:54:09.884', '2012-02-13 16:54:09.884', 'denis.villegas3@supportcomm.com.br', 'denis', 'Denis Hoffmeister Villegas', 'Administrador', 'ysnZcVMY8uAkc19VnQRLWQ');
INSERT INTO usuario VALUES (4, 1, '2012-02-15 11:56:32.717', '2012-02-15 11:55:33.426', 'maruen.mehana@suportcomm.com.br', 'maruen', 'Maruen Mehana', 'Administrador', 'mb+Ngy3WQFAkc19VnQRLWQ');
INSERT INTO usuario VALUES (6, 1, '2012-02-02 17:12:05', '2012-02-02 17:09:17', 'marcio.silva@supportcomm.com.br', 'marcio.silva', 'Marcio Silva', 'Administrador', '7NbJeEvsW6z3vHT0D62Vtg');
INSERT INTO usuario VALUES (1, 1, '2012-04-18 15:40:08.456', '2011-12-09 11:50:56', 'gabrielle.sanches@supportcomm.com.br', 'gabrielle', 'Gabrielle sanches', 'Administrador', 'vloVjo7YnS8');


--
-- Data for Name: vg_config; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO vg_config VALUES (4, 'duplicated.check.interval', '10', 'time interval in seconds to consider a message duplicated or not', 'Intervalo de duplicadas');
INSERT INTO vg_config VALUES (2, 'sms.fail.default', 'Houve uma falha e a sua compra nao foi realizada. Tente novamente mais tarde. ', 'mensagem enviada após falha no processo de compra', 'SMS em falha');
INSERT INTO vg_config VALUES (3, 'invalid.command', 'Comando invalido.', 'message sent when the rule is not found', 'SMS de comando inválido');
INSERT INTO vg_config VALUES (5, 'duplicated.check.message', 'Voce ja enviou mais de uma mensagem no intervalo de tempo permitido. scomm', 'Message to be sent back when  a message is considered duplicated', 'SMS de duplicadas');
INSERT INTO vg_config VALUES (1, 'sms.success.default', 'Compra realizada com Sucesso com protocolo %p', 'mensagem enviada após sucesso em billing', 'SMS em sucesso');
INSERT INTO vg_config VALUES (6, 'option.in.answer', 'SIM', 'Message of Double Option expected', 'Resposta Option In');
INSERT INTO vg_config VALUES (7, 'sms.optionIn', 'Digite SIM para Realizar a compra %t + %i', 'Mensagem para resposta do option in', 'SMS Option In');
INSERT INTO vg_config VALUES (8, 'sms.voucher', 'Seu voucher :  %v', 'Mensagem contendo código voucher', 'SMS Voucher');


--
-- Data for Name: vg_flow; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO vg_flow VALUES (3, 3, 'Voucher', 'Voucher');
INSERT INTO vg_flow VALUES (1, 1, 'Simplificado', 'Workflow default do Virtual Goods sem autorizacão');
INSERT INTO vg_flow VALUES (2, 2, 'Simplificado com autorização', 'Workflow default do Virtual Goods com autorização');


--
-- Data for Name: voucher; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

INSERT INTO voucher VALUES (24, 520, 352, 12, '553197547176', '6ea07a62a', 1, '2012-05-17 09:22:23.692', NULL, 0, 1);


--
-- Data for Name: without_campaign_msg; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--



--
-- PostgreSQL database dump complete
--

