--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: billing_record_failure; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE billing_record_failure (
    id_billrec_failure bigint NOT NULL,
    id_transacao bigint NOT NULL,
    msg_failure_sent integer NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    vl_compra double precision NOT NULL,
    dt_compra timestamp without time zone NOT NULL
);


ALTER TABLE public.billing_record_failure OWNER TO virtualgoods;

--
-- Name: billing_record_failure_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE billing_record_failure_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.billing_record_failure_seq OWNER TO virtualgoods;

--
-- Name: billing_record_failure_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('billing_record_failure_seq', 22, true);


--
-- Name: billing_record_success; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE billing_record_success (
    id_billrec_success bigint NOT NULL,
    id_transacao bigint NOT NULL,
    nu_protocol bigint NOT NULL,
    sent_protocol integer NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    vl_compra double precision NOT NULL,
    dt_compra timestamp without time zone NOT NULL
);


ALTER TABLE public.billing_record_success OWNER TO virtualgoods;

--
-- Name: billing_record_success_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE billing_record_success_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.billing_record_success_seq OWNER TO virtualgoods;

--
-- Name: billing_record_success_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('billing_record_success_seq', 202, true);


--
-- Name: buy_config; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE buy_config (
    cd_operadora integer NOT NULL,
    vl_max double precision NOT NULL,
    nu_dias integer,
    mes_corrente_ativo integer NOT NULL,
    cd_config_ativo integer,
    msg_limite_excedido character varying(138),
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL
);


ALTER TABLE public.buy_config OWNER TO virtualgoods;

--
-- Name: buying_limit_exceed; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE buying_limit_exceed (
    id_buying_limit_exceed bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    dt_compra timestamp without time zone NOT NULL,
    sms_mt_sent integer DEFAULT 0
);


ALTER TABLE public.buying_limit_exceed OWNER TO virtualgoods;

--
-- Name: buying_limit_exceed_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE buying_limit_exceed_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.buying_limit_exceed_seq OWNER TO virtualgoods;

--
-- Name: buying_limit_exceed_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('buying_limit_exceed_seq', 58, true);


--
-- Name: campanha; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE campanha (
    id_campanha bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp(6) without time zone NOT NULL,
    dt_criacao timestamp(6) without time zone NOT NULL,
    nm_campanha character varying(50) NOT NULL,
    nm_portalvenda_performance character varying(50) NOT NULL,
    url_confirmstatus character varying(255) NOT NULL,
    url_pedido character varying(255) NOT NULL,
    txt_mt_success character varying(255) NOT NULL,
    txt_mt_fail character varying(255) NOT NULL,
    id_tipo_campanha bigint NOT NULL,
    id_regra bigint NOT NULL
);


ALTER TABLE public.campanha OWNER TO virtualgoods;

--
-- Name: campanha_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE campanha_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.campanha_seq OWNER TO virtualgoods;

--
-- Name: campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('campanha_seq', 7, true);


--
-- Name: duplicated_message; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE duplicated_message (
    id_duplicated_message bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    dt_compra timestamp(6) without time zone NOT NULL,
    sms_mt_sent integer DEFAULT 0
);


ALTER TABLE public.duplicated_message OWNER TO virtualgoods;

--
-- Name: duplicated_message_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE duplicated_message_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.duplicated_message_seq OWNER TO virtualgoods;

--
-- Name: duplicated_message_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('duplicated_message_seq', 53, true);


--
-- Name: historico; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE historico (
    id_historico bigint NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    nu_retentativa integer,
    st_historico integer NOT NULL,
    tp_historico integer NOT NULL,
    tx_mensagem character varying(255),
    url character varying(255),
    vl_tarifacao double precision,
    id_la bigint NOT NULL,
    id_parceiro bigint,
    id_mensagem bigint NOT NULL
);


ALTER TABLE public.historico OWNER TO virtualgoods;

--
-- Name: historico_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE historico_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.historico_seq OWNER TO virtualgoods;

--
-- Name: historico_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('historico_seq', 1054, true);


--
-- Name: keycode; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE keycode (
    id_keycode bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_keycode character varying(50) NOT NULL,
    id_parceiro bigint NOT NULL
);


ALTER TABLE public.keycode OWNER TO virtualgoods;

--
-- Name: keycode_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE keycode_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.keycode_seq OWNER TO virtualgoods;

--
-- Name: keycode_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('keycode_seq', 2, true);


--
-- Name: la; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE la (
    id_la bigint NOT NULL,
    cd_ativo integer NOT NULL,
    cd_claro integer NOT NULL,
    cd_ctbc integer NOT NULL,
    cd_nextel integer NOT NULL,
    cd_oi integer NOT NULL,
    cd_tim integer NOT NULL,
    cd_vivo integer NOT NULL,
    ds_la character varying(50) NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    tx_mercuri_itemid integer NOT NULL,
    tx_mercuri_password character varying(50) NOT NULL,
    tx_mercuri_serviceid integer NOT NULL,
    tx_mercuri_url character varying(128) NOT NULL,
    tx_mercuri_username character varying(50) NOT NULL,
    nm_la character varying(50) NOT NULL
);


ALTER TABLE public.la OWNER TO virtualgoods;

--
-- Name: la_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE la_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.la_seq OWNER TO virtualgoods;

--
-- Name: la_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('la_seq', 4, true);


--
-- Name: log; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE log (
    id_log bigint NOT NULL,
    dt_criacao timestamp(6) without time zone NOT NULL,
    st_transacao integer NOT NULL,
    id_transacao bigint NOT NULL
);


ALTER TABLE public.log OWNER TO virtualgoods;

--
-- Name: log_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE log_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.log_seq OWNER TO virtualgoods;

--
-- Name: log_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('log_seq', 1, false);


--
-- Name: logger_message; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE logger_message (
    id_message bigint NOT NULL,
    string_message character varying(200) NOT NULL
);


ALTER TABLE public.logger_message OWNER TO virtualgoods;

--
-- Name: mensagem; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE mensagem (
    id_mensagem bigint NOT NULL,
    tx_mensagem character varying(255) NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    dt_processamento timestamp without time zone NOT NULL,
    dt_request timestamp without time zone NOT NULL,
    st_mensagem integer NOT NULL,
    id_la bigint NOT NULL
);


ALTER TABLE public.mensagem OWNER TO virtualgoods;

--
-- Name: mensagem_resposta; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE mensagem_resposta (
    id_mensagem_resposta bigint NOT NULL,
    tx_mensagem character varying(255) NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    dt_processamento timestamp without time zone NOT NULL,
    dt_request timestamp without time zone NOT NULL,
    st_mensagem integer NOT NULL,
    id_la bigint NOT NULL,
    id_mensagem bigint NOT NULL
);


ALTER TABLE public.mensagem_resposta OWNER TO virtualgoods;

--
-- Name: mensagem_resposta_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE mensagem_resposta_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.mensagem_resposta_seq OWNER TO virtualgoods;

--
-- Name: mensagem_resposta_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('mensagem_resposta_seq', 305, true);


--
-- Name: mensagem_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE mensagem_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.mensagem_seq OWNER TO virtualgoods;

--
-- Name: mensagem_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('mensagem_seq', 382, true);


--
-- Name: operadora; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE operadora (
    cd_operadora integer NOT NULL,
    nm_operadora character varying(50) NOT NULL
);


ALTER TABLE public.operadora OWNER TO virtualgoods;

--
-- Name: parceiro; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE parceiro (
    id_parceiro bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_parceiro character varying(50) NOT NULL,
    nm_parceiro_performance character varying(50) NOT NULL,
    nu_retentativa integer NOT NULL,
    nu_timeschedule integer NOT NULL
);


ALTER TABLE public.parceiro OWNER TO virtualgoods;

--
-- Name: parceiro_la; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE parceiro_la (
    id_parceiro bigint NOT NULL,
    id_la bigint NOT NULL
);


ALTER TABLE public.parceiro_la OWNER TO virtualgoods;

--
-- Name: parceiro_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE parceiro_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.parceiro_seq OWNER TO virtualgoods;

--
-- Name: parceiro_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('parceiro_seq', 2, true);


--
-- Name: protocol_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE protocol_seq
    INCREMENT BY 1
    MAXVALUE 99999999999
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.protocol_seq OWNER TO virtualgoods;

--
-- Name: protocol_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('protocol_seq', 202, true);


--
-- Name: regra; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE regra (
    id_regra bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_regra character varying(50) NOT NULL,
    id_parceiro bigint NOT NULL,
    id_sharecode_claro bigint,
    id_sharecode_tim bigint,
    id_la bigint NOT NULL,
    id_keycode bigint NOT NULL,
    id_sharecode_vivo bigint,
    id_sharecode_nextel bigint,
    id_sharecode_oi bigint,
    id_sharecode_ctbc bigint,
    cd_autoriza_parceiro integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.regra OWNER TO virtualgoods;

--
-- Name: regra_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE regra_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.regra_seq OWNER TO virtualgoods;

--
-- Name: regra_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('regra_seq', 4, true);


--
-- Name: sharecode; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE sharecode (
    id_sharecode bigint NOT NULL,
    cd_ativo integer NOT NULL,
    ds_sharecode character varying(128) NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    tx_mercuri_itemid integer NOT NULL,
    tx_mercuri_password character varying(50) NOT NULL,
    tx_mercuri_serviceid integer NOT NULL,
    tx_mercuri_url character varying(128) NOT NULL,
    tx_mercuri_username character varying(50) NOT NULL,
    nm_sharecode character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    vl_tarifacao double precision NOT NULL
);


ALTER TABLE public.sharecode OWNER TO virtualgoods;

--
-- Name: sharecode_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE sharecode_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sharecode_seq OWNER TO virtualgoods;

--
-- Name: sharecode_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('sharecode_seq', 4, true);


--
-- Name: tipo_campanha; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE tipo_campanha (
    id_tipo_campanha bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_tipo_campanha character varying(50) NOT NULL,
    sg_tipo_campanha character varying(50) NOT NULL
);


ALTER TABLE public.tipo_campanha OWNER TO virtualgoods;

--
-- Name: tipo_campanha_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE tipo_campanha_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipo_campanha_seq OWNER TO virtualgoods;

--
-- Name: tipo_campanha_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('tipo_campanha_seq', 3, true);


--
-- Name: transacao; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE transacao (
    id_transacao bigint NOT NULL,
    dt_schedule timestamp(6) without time zone NOT NULL,
    dt_transacao timestamp(6) without time zone NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    st_transacao integer NOT NULL,
    vl_tarifacao double precision NOT NULL,
    id_keycode bigint NOT NULL,
    id_campanha bigint NOT NULL,
    id_sharecode bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    id_parceiro bigint NOT NULL,
    id_la bigint NOT NULL,
    id_regra bigint NOT NULL
);


ALTER TABLE public.transacao OWNER TO virtualgoods;

--
-- Name: transacao_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE transacao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.transacao_seq OWNER TO virtualgoods;

--
-- Name: transacao_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('transacao_seq', 224, true);


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE usuario (
    id_usuario bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    tx_email character varying(128) NOT NULL,
    cd_login character varying(50) NOT NULL,
    nm_usuario character varying(50) NOT NULL,
    cd_perfil character varying(50) NOT NULL,
    tx_senha character varying(50) NOT NULL
);


ALTER TABLE public.usuario OWNER TO virtualgoods;

--
-- Name: usuario_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE usuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.usuario_seq OWNER TO virtualgoods;

--
-- Name: usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('usuario_seq', 5, true);


--
-- Name: vg_config; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE vg_config (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    value character varying(200),
    description character varying(200),
    label character varying(50)
);


ALTER TABLE public.vg_config OWNER TO virtualgoods;

--
-- Name: without_rule_msg; Type: TABLE; Schema: public; Owner: virtualgoods; Tablespace: 
--

CREATE TABLE without_rule_msg (
    id_without_rule_msg bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    tx_mensagem character varying(255),
    sms_mt_sent integer DEFAULT 0
);


ALTER TABLE public.without_rule_msg OWNER TO virtualgoods;

--
-- Name: without_rule_msg_seq; Type: SEQUENCE; Schema: public; Owner: virtualgoods
--

CREATE SEQUENCE without_rule_msg_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.without_rule_msg_seq OWNER TO virtualgoods;

--
-- Name: without_rule_msg_seq; Type: SEQUENCE SET; Schema: public; Owner: virtualgoods
--

SELECT pg_catalog.setval('without_rule_msg_seq', 38, true);


--
-- Data for Name: billing_record_failure; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY billing_record_failure (id_billrec_failure, id_transacao, msg_failure_sent, cd_msisdn, cd_operadora, vl_compra, dt_compra) FROM stdin;
\.


--
-- Data for Name: billing_record_success; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY billing_record_success (id_billrec_success, id_transacao, nu_protocol, sent_protocol, cd_msisdn, cd_operadora, vl_compra, dt_compra) FROM stdin;
201	223	201	1	551199610887	10	1	2012-04-18 17:24:23.636
202	224	202	1	553197547176	10	1	2012-04-27 11:41:06.352
\.


--
-- Data for Name: buy_config; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY buy_config (cd_operadora, vl_max, nu_dias, mes_corrente_ativo, cd_config_ativo, msg_limite_excedido, dt_alteracao, dt_criacao) FROM stdin;
4	20	10	0	1	Voce atingiu o limite mensal de compras!	2012-03-07 10:47:58	2012-03-07 10:46:43
3	15	15	0	\N	Voce atingiu o limite mensal de compras!	2012-03-07 10:48:12	2012-03-07 10:46:24
9	25.100000000000001	\N	1	1	Voce atingiu o limite mensal de compras!	2012-03-07 14:45:24	2012-03-07 10:46:57
7	10	10	0	1	Voce atingiu o limite mensal de compras!	2012-03-07 14:56:25	2012-03-07 10:46:01
5	0	0	0	1	Voce atingiu o limite mensal de compras!	2012-04-12 09:40:47.051	2012-03-07 09:14:31
10	20	0	0	1	Voce ultrapassou o limite de compras para este mes. Vivo, a melhor escolha ;)	2012-04-13 14:12:42.604	2012-03-06 18:52:59
\.


--
-- Data for Name: buying_limit_exceed; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY buying_limit_exceed (id_buying_limit_exceed, id_mensagem, cd_msisdn, cd_operadora, dt_compra, sms_mt_sent) FROM stdin;
\.


--
-- Data for Name: campanha; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY campanha (id_campanha, cd_ativo, dt_alteracao, dt_criacao, nm_campanha, nm_portalvenda_performance, url_confirmstatus, url_pedido, txt_mt_success, txt_mt_fail, id_tipo_campanha, id_regra) FROM stdin;
6	1	2012-04-18 16:50:53.849	2012-01-23 16:04:08	00004	Tequila Mobile	http://192.168.168.101/confirm_billing	http://192.168.168.101/ask_auth	Compra realizada com sucesso, o protocolo é %p	Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!	1	7
2	1	2012-04-18 16:44:19.818	2011-12-14 11:23:00	00002	Tequila Mobile	http://192.168.168.101/confirm_billing	http://192.168.168.101/ask_auth	Compra realizada com sucesso, o protocolo é %p	Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!	1	2
3	1	2012-04-18 16:44:33.312	2011-12-14 11:25:00	00003	Tequila Mobile	http://192.168.168.101/confirm_billing	http://192.168.168.101/ask_auth	Compra realizada com sucesso, o protocolo é %p	Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!	1	3
1	1	2012-04-18 16:44:52.218	2011-12-14 11:18:00	00001	Tequila Mobile	http://192.168.168.101/confirm_billing	http://192.168.168.101/ask_auth	Compra realizada com sucesso, o protocolo é %p	Houve uma falha e a sua compra não foi realizada, tente novamente mais tarde!	1	1
\.


--
-- Data for Name: duplicated_message; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY duplicated_message (id_duplicated_message, id_mensagem, cd_msisdn, cd_operadora, dt_compra, sms_mt_sent) FROM stdin;
50	373	553197547176	10	2012-04-27 11:41:06.64	1
51	374	553197547176	10	2012-04-27 11:41:06.71	1
52	375	553197547176	10	2012-04-27 11:41:06.754	1
53	376	553197547176	10	2012-04-27 11:41:06.798	1
\.


--
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY historico (id_historico, dt_criacao, cd_msisdn, cd_operadora, nu_retentativa, st_historico, tp_historico, tx_mensagem, url, vl_tarifacao, id_la, id_parceiro, id_mensagem) FROM stdin;
1037	2012-04-18 17:24:23.636	551199610887	10	0	1	0	Vg0001 00001	\N	0	4	\N	371
1038	2012-04-18 17:24:28.597	551199610887	10	0	6	2	Vg0001 00001	\N	1	4	3	371
1039	2012-04-18 17:24:43.566	551199610887	10	0	1	4	Compra realizada com sucesso, o protocolo é 0151200000000201	\N	0	4	3	371
1040	2012-04-18 17:24:43.60	551199610887	10	1	0	3	Vg0001 00001	http://192.168.168.101/confirm_billing?msisdn=551199610887&message=Vg0001 00001&mid=371&sc=49481&operator=10&binfo=6	1	4	3	371
1041	2012-04-27 11:41:06.352	553197547176	10	0	1	0	vg0001 00001	\N	0	4	\N	372
1042	2012-04-27 11:41:06.62	553197547176	10	0	4	0	vg0001 00001	\N	0	4	\N	373
1043	2012-04-27 11:41:06.69	553197547176	10	0	4	0	vg0001 00001	\N	0	4	\N	374
1044	2012-04-27 11:41:06.735	553197547176	10	0	4	0	vg0001 00001	\N	0	4	\N	375
1045	2012-04-27 11:41:06.779	553197547176	10	0	4	0	vg0001 00001	\N	0	4	\N	376
1046	2012-04-27 11:41:11.184	553197547176	10	0	6	2	vg0001 00001	\N	1	4	3	372
1047	2012-04-27 11:41:26.179	553197547176	10	0	1	4	Compra realizada com sucesso, o protocolo é 0151200000000202	\N	0	4	3	372
1048	2012-04-27 11:41:26.296	553197547176	10	1	0	3	vg0001 00001	http://192.168.168.101/confirm_billing?msisdn=553197547176&message=vg0001 00001&mid=372&sc=49481&operator=10&binfo=6	1	4	3	372
1049	2012-05-02 08:50:26.148	559294057813	10	0	2	0	Pley	\N	0	5	\N	377
1050	2012-05-03 09:44:55.088	553197547176	10	0	2	0	Vg0001	\N	0	4	\N	378
1051	2012-05-03 10:15:25.961	553197547176	10	0	2	0	Vg0002	\N	0	5	\N	379
1052	2012-05-07 14:01:46.745	551199610887	10	0	2	0	term tg1	\N	0	4	\N	380
1053	2012-05-07 14:02:09.438	551199610887	10	0	2	0	term tg1	\N	0	4	\N	381
1054	2012-05-07 14:16:56.164	551199610887	10	0	2	0	term tg1	\N	0	4	\N	382
\.


--
-- Data for Name: keycode; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY keycode (id_keycode, cd_ativo, dt_alteracao, dt_criacao, nm_keycode, id_parceiro) FROM stdin;
2	1	2012-04-18 16:19:31.488	2011-12-14 10:43:01	vg0001	3
\.


--
-- Data for Name: la; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY la (id_la, cd_ativo, cd_claro, cd_ctbc, cd_nextel, cd_oi, cd_tim, cd_vivo, ds_la, dt_alteracao, dt_criacao, tx_mercuri_itemid, tx_mercuri_password, tx_mercuri_serviceid, tx_mercuri_url, tx_mercuri_username, nm_la) FROM stdin;
4	1	1	0	0	0	0	1	LA de Navegação	2012-04-18 15:50:51.156	2012-01-23 15:56:38	249	vgb4kh	16	http://merc-inter.dc1.supp.com.br	virtualgoods	49481
5	1	1	0	0	0	0	1	LA de Navegação	2012-04-18 15:51:03.655	2012-01-23 15:57:23	249	vgb4kh	16	http://merc-inter.dc1.supp.com.br	virtualgoods	49482
\.


--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY log (id_log, dt_criacao, st_transacao, id_transacao) FROM stdin;
\.


--
-- Data for Name: logger_message; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY logger_message (id_message, string_message) FROM stdin;
4	Erro ao verificar o limite de compras: %s
7	LA nao encontrada no sistema: %s
8	Erro indefinido no SMSMOController: %s
12	O campo número de dias não pode ser vazio
13	Configuração salva com sucesso!
14	Selecione uma operadora
15	O Limite máximo de caracteres para este campo é de 138
16	O Limite máximo de caracteres para o campo %s é de 138
17	Informe um valor numérico válido para o campo %s
18	O campo %s não pode ser vazio
1	Nao foi encontrada nenhuma configuracao de restricao de compras para a operadora %s, a compra sera processada normalmente
5	Requisicao invalida: %s
6	Requisição invalida. Revise o XML de entrada.
10	Valor maximo de compras ja foi atingido nestes ultimos %i dias, valor total comprado foi de : %d
9	Valor total de compras ja realizado nestes ultimos %i dias foi de : %d
2	Valor maximo de compras atingido para o mes corrente, valor total comprado foi de : %d
3	Valor total comprado no mes corrente foi de : %d
11	O campo valor maximo nao pode ser vazio
\.


--
-- Data for Name: mensagem; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY mensagem (id_mensagem, tx_mensagem, cd_msisdn, cd_operadora, dt_processamento, dt_request, st_mensagem, id_la) FROM stdin;
371	Vg0001 00001	551199610887	10	2012-04-18 17:24:23.636	2012-04-18 17:24:23.636	1	4
372	vg0001 00001	553197547176	10	2012-04-27 11:41:06.352	2012-04-27 11:41:06.352	1	4
373	vg0001 00001	553197547176	10	2012-04-27 11:41:06.62	2012-04-27 11:41:06.62	4	4
374	vg0001 00001	553197547176	10	2012-04-27 11:41:06.69	2012-04-27 11:41:06.69	4	4
375	vg0001 00001	553197547176	10	2012-04-27 11:41:06.735	2012-04-27 11:41:06.735	4	4
376	vg0001 00001	553197547176	10	2012-04-27 11:41:06.779	2012-04-27 11:41:06.779	4	4
377	Pley	559294057813	10	2012-05-02 08:50:26.148	2012-05-02 08:50:26.148	2	5
378	Vg0001	553197547176	10	2012-05-03 09:44:55.088	2012-05-03 09:44:55.088	2	4
379	Vg0002	553197547176	10	2012-05-03 10:15:25.961	2012-05-03 10:15:25.961	2	5
380	term tg1	551199610887	10	2012-05-07 14:01:46.745	2012-05-07 14:01:46.745	2	4
381	term tg1	551199610887	10	2012-05-07 14:02:09.438	2012-05-07 14:02:09.438	2	4
382	term tg1	551199610887	10	2012-05-07 14:16:56.164	2012-05-07 14:16:56.164	2	4
\.


--
-- Data for Name: mensagem_resposta; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY mensagem_resposta (id_mensagem_resposta, tx_mensagem, cd_msisdn, cd_operadora, dt_processamento, dt_request, st_mensagem, id_la, id_mensagem) FROM stdin;
300	Compra realizada com sucesso, o protocolo é 0151200000000201	551199610887	10	2012-04-18 17:24:43.59	2012-04-18 17:24:43.59	1	4	371
301	Voce ja enviou mais de uma mensagem no intervalo de tempo permitido. scomm	553197547176	10	2012-04-27 11:41:11.153	2012-04-27 11:41:11.153	1	4	373
302	Compra realizada com sucesso, o protocolo é 0151200000000202	553197547176	10	2012-04-27 11:41:26.186	2012-04-27 11:41:26.186	1	4	372
303	Comando invalido.	559294057813	10	2012-05-02 08:50:41.105	2012-05-02 08:50:41.105	1	5	377
304	Comando invalido.	553197547176	10	2012-05-03 09:45:56.133	2012-05-03 09:45:56.133	1	4	378
305	Comando invalido.	553197547176	10	2012-05-03 10:17:11.101	2012-05-03 10:17:11.101	1	5	379
\.


--
-- Data for Name: operadora; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY operadora (cd_operadora, nm_operadora) FROM stdin;
9	TIM
4	OI
3	NEXTEL
7	CTBC
5	CLARO
10	VIVO
\.


--
-- Data for Name: parceiro; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY parceiro (id_parceiro, cd_ativo, dt_alteracao, dt_criacao, nm_parceiro, nm_parceiro_performance, nu_retentativa, nu_timeschedule) FROM stdin;
3	1	2012-02-07 18:34:56	2011-12-14 09:47:39	Tequila Mobile	Tequila Mobile	3	10
\.


--
-- Data for Name: parceiro_la; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY parceiro_la (id_parceiro, id_la) FROM stdin;
3	4
\.


--
-- Data for Name: regra; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY regra (id_regra, cd_ativo, dt_alteracao, dt_criacao, nm_regra, id_parceiro, id_sharecode_claro, id_sharecode_tim, id_la, id_keycode, id_sharecode_vivo, id_sharecode_nextel, id_sharecode_oi, id_sharecode_ctbc, cd_autoriza_parceiro) FROM stdin;
3	1	2012-03-08 17:38:42	2011-12-14 11:15:00	Tarifa 3	3	12	\N	4	2	7	\N	\N	\N	0
2	1	2012-03-08 17:38:57	2011-12-14 11:15:00	Tarifa 2	3	10	\N	4	2	6	\N	\N	\N	0
1	1	2012-03-12 17:19:51	2011-12-14 11:15:00	Tarifa 1	3	2	\N	4	2	9	\N	\N	\N	0
7	1	2012-03-16 10:03:52	2012-01-23 16:02:29	Tarifa 4	3	\N	\N	4	2	8	\N	\N	\N	0
\.


--
-- Data for Name: sharecode; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY sharecode (id_sharecode, cd_ativo, ds_sharecode, dt_alteracao, dt_criacao, tx_mercuri_itemid, tx_mercuri_password, tx_mercuri_serviceid, tx_mercuri_url, tx_mercuri_username, nm_sharecode, cd_operadora, vl_tarifacao) FROM stdin;
8	1	Tarifação de R$ 9,90	2012-04-18 16:14:06.558	2012-01-23 15:54:12	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	72756	10	9.9000000000000004
7	1	Tarifação de R$ 4,00 + Imp	2012-04-18 16:14:32.574	2012-01-23 15:53:30	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	72755	10	4
9	1	Tarifação de R$ 1,00	2012-04-18 16:14:53.585	2012-01-23 15:54:57	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	72757	10	1
2	1	Tarifação 0,99	2012-04-18 16:15:01.101	2011-12-09 16:50:54	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	SC0821	5	0.98999999999999999
10	1	Tarifação 1,99 + imp	2012-04-18 16:15:08.727	2012-03-07 14:23:21	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	SC0822	5	1.99
11	1	Tarifação 2,99	2012-04-18 16:15:16.521	2012-03-08 17:36:37	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	SC0823	5	2.9900000000000002
3	1	Tarifação de R$ 3,80	2012-04-18 16:15:24.437	2011-12-14 10:17:43	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	49677	10	3.7999999999999998
4	1	Tarifação de R$ 5,70	2012-04-18 16:15:31.245	2011-12-14 10:18:56	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	49692	10	5.7000000000000002
6	1	Tarifação de R$ 1,99 + Imp	2012-04-18 16:15:37.605	2012-01-23 15:52:31	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	72754	10	1.99
12	1	Tarifação 3,99 + imp	2012-04-18 16:15:43.955	2012-03-08 17:37:23	248	vgbk1h	16	http://merc-inter.dc1.supp.com.br	virtualgoods	SC0824	5	3.9900000000000002
\.


--
-- Data for Name: tipo_campanha; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY tipo_campanha (id_tipo_campanha, cd_ativo, dt_alteracao, dt_criacao, nm_tipo_campanha, sg_tipo_campanha) FROM stdin;
1	1	2011-12-14 11:15:00	2011-12-14 11:15:00	Freemium Games	Free
\.


--
-- Data for Name: transacao; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY transacao (id_transacao, dt_schedule, dt_transacao, cd_msisdn, cd_operadora, st_transacao, vl_tarifacao, id_keycode, id_campanha, id_sharecode, id_mensagem, id_parceiro, id_la, id_regra) FROM stdin;
223	2012-04-18 17:24:23.636	2012-04-18 17:24:23.636	551199610887	10	7	1	2	1	9	371	3	4	1
224	2012-04-27 11:41:06.352	2012-04-27 11:41:06.352	553197547176	10	7	1	2	1	9	372	3	4	1
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY usuario (id_usuario, cd_ativo, dt_alteracao, dt_criacao, tx_email, cd_login, nm_usuario, cd_perfil, tx_senha) FROM stdin;
2	1	2012-01-19 10:55:52.048	2012-01-19 10:55:18.422	fabio.brandao3@supportcomm.com.br	fabio	Fábio Brandão	Administrador	yO0bD6NoL1FnPfEioZdY0g
3	1	2012-02-13 16:54:09.884	2012-02-13 16:54:09.884	denis.villegas3@supportcomm.com.br	denis	Denis Hoffmeister Villegas	Administrador	ysnZcVMY8uAkc19VnQRLWQ
4	1	2012-02-15 11:56:32.717	2012-02-15 11:55:33.426	maruen.mehana@suportcomm.com.br	maruen	Maruen Mehana	Administrador	mb+Ngy3WQFAkc19VnQRLWQ
6	1	2012-02-02 17:12:05	2012-02-02 17:09:17	marcio.silva@supportcomm.com.br	marcio.silva	Marcio Silva	Administrador	7NbJeEvsW6z3vHT0D62Vtg
1	1	2012-04-18 15:40:08.456	2011-12-09 11:50:56	gabrielle.sanches@supportcomm.com.br	gabrielle	Gabrielle sanches	Administrador	vloVjo7YnS8
\.


--
-- Data for Name: vg_config; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY vg_config (id, name, value, description, label) FROM stdin;
4	duplicated.check.interval	10	time interval in seconds to consider a message duplicated or not	Intervalo de duplicadas
1	sms.success.default	Compra realizada com Sucesso. 	mensagem enviada após sucesso em billing	SMS em sucesso
2	sms.fail.default	Houve uma falha e a sua compra nao foi realizada. Tente novamente mais tarde. 	mensagem enviada após falha no processo de compra	SMS em falha
3	invalid.command	Comando invalido.	message sent when the rule is not found	SMS de comando inválido
5	duplicated.check.message	Voce ja enviou mais de uma mensagem no intervalo de tempo permitido. scomm	Message to be sent back when  a message is considered duplicated	SMS de duplicadas
\.


--
-- Data for Name: without_rule_msg; Type: TABLE DATA; Schema: public; Owner: virtualgoods
--

COPY without_rule_msg (id_without_rule_msg, id_mensagem, cd_msisdn, cd_operadora, tx_mensagem, sms_mt_sent) FROM stdin;
33	377	559294057813	10	Pley	1
34	378	553197547176	10	Vg0001	1
35	379	553197547176	10	Vg0002	1
36	380	551199610887	10	term tg1	0
37	381	551199610887	10	term tg1	0
38	382	551199610887	10	term tg1	0
\.


--
-- Name: billing_record_failure_id_billrec_failure_pk; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_billrec_failure_pk PRIMARY KEY (id_billrec_failure);


--
-- Name: billing_record_failure_id_transacao_unique; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_transacao_unique UNIQUE (id_transacao);


--
-- Name: billing_record_success_id_billrec_success_pk; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_billrec_success_pk PRIMARY KEY (id_billrec_success);


--
-- Name: billing_record_success_id_transacao_unique; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_transacao_unique UNIQUE (id_transacao);


--
-- Name: buying_limit_exceed_id_buying_limit_exceed_pk; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_buying_limit_exceed_pk PRIMARY KEY (id_buying_limit_exceed);


--
-- Name: buying_limit_exceed_id_message_uq; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_message_uq UNIQUE (id_mensagem);


--
-- Name: campanha_nm_campanha_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_nm_campanha_key UNIQUE (nm_campanha);


--
-- Name: campanha_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_pkey PRIMARY KEY (id_campanha);


--
-- Name: duplicated_message_id_duplicated_message_pk; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY duplicated_message
    ADD CONSTRAINT duplicated_message_id_duplicated_message_pk PRIMARY KEY (id_duplicated_message);


--
-- Name: duplicated_message_id_mensagem_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY duplicated_message
    ADD CONSTRAINT duplicated_message_id_mensagem_key UNIQUE (id_mensagem);


--
-- Name: historico_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT historico_pkey PRIMARY KEY (id_historico);


--
-- Name: keycode_nm_keycode_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT keycode_nm_keycode_key UNIQUE (nm_keycode);


--
-- Name: keycode_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT keycode_pkey PRIMARY KEY (id_keycode);


--
-- Name: la_nm_la_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY la
    ADD CONSTRAINT la_nm_la_key UNIQUE (nm_la);


--
-- Name: la_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY la
    ADD CONSTRAINT la_pkey PRIMARY KEY (id_la);


--
-- Name: log_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id_log);


--
-- Name: logger_message_id_message_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY logger_message
    ADD CONSTRAINT logger_message_id_message_pkey PRIMARY KEY (id_message);


--
-- Name: mensagem_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY mensagem
    ADD CONSTRAINT mensagem_pkey PRIMARY KEY (id_mensagem);


--
-- Name: mensagem_resposta_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT mensagem_resposta_pkey PRIMARY KEY (id_mensagem_resposta);


--
-- Name: operadora_id_operadora_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY operadora
    ADD CONSTRAINT operadora_id_operadora_pkey PRIMARY KEY (cd_operadora);


--
-- Name: parceiro_la_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT parceiro_la_pkey PRIMARY KEY (id_la, id_parceiro);


--
-- Name: parceiro_nm_parceiro_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY parceiro
    ADD CONSTRAINT parceiro_nm_parceiro_key UNIQUE (nm_parceiro);


--
-- Name: parceiro_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY parceiro
    ADD CONSTRAINT parceiro_pkey PRIMARY KEY (id_parceiro);


--
-- Name: regra_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT regra_pkey PRIMARY KEY (id_regra);


--
-- Name: sharecode_nm_sharecode_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY sharecode
    ADD CONSTRAINT sharecode_nm_sharecode_key UNIQUE (nm_sharecode, cd_operadora);


--
-- Name: sharecode_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY sharecode
    ADD CONSTRAINT sharecode_pkey PRIMARY KEY (id_sharecode);


--
-- Name: tipo_campanha_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY tipo_campanha
    ADD CONSTRAINT tipo_campanha_pkey PRIMARY KEY (id_tipo_campanha);


--
-- Name: tipo_campanha_sg_tipo_campanha_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY tipo_campanha
    ADD CONSTRAINT tipo_campanha_sg_tipo_campanha_key UNIQUE (sg_tipo_campanha);


--
-- Name: transacao_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_pkey PRIMARY KEY (id_transacao);


--
-- Name: usuario_cd_login_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_cd_login_key UNIQUE (cd_login);


--
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- Name: vg_config_name_key; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY vg_config
    ADD CONSTRAINT vg_config_name_key UNIQUE (name);


--
-- Name: vg_config_pkey; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY vg_config
    ADD CONSTRAINT vg_config_pkey PRIMARY KEY (id);


--
-- Name: without_rule_msg_id_mensagem_uq; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY without_rule_msg
    ADD CONSTRAINT without_rule_msg_id_mensagem_uq UNIQUE (id_mensagem);


--
-- Name: without_rule_msg_id_without_rule_msg_pk; Type: CONSTRAINT; Schema: public; Owner: virtualgoods; Tablespace: 
--

ALTER TABLE ONLY without_rule_msg
    ADD CONSTRAINT without_rule_msg_id_without_rule_msg_pk PRIMARY KEY (id_without_rule_msg);


--
-- Name: billing_record_failure_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: billing_record_success_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: buying_limit_exceed_id_message_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_message_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: campanha_id_regra_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_id_regra_fk FOREIGN KEY (id_regra) REFERENCES regra(id_regra);


--
-- Name: campanha_id_tipo_campanha_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_id_tipo_campanha_fk FOREIGN KEY (id_tipo_campanha) REFERENCES tipo_campanha(id_tipo_campanha);


--
-- Name: duplicated_message_id_message_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY duplicated_message
    ADD CONSTRAINT duplicated_message_id_message_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: fk32a49cac2d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT fk32a49cac2d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk4b301a3176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a3176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk4b301a32d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a32d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk4b301a359b93b70; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a359b93b70 FOREIGN KEY (id_keycode) REFERENCES keycode(id_keycode);


--
-- Name: fk4b301a36426a449; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36426a449 FOREIGN KEY (id_sharecode_tim) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a36d7f2a71; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36d7f2a71 FOREIGN KEY (id_sharecode_ctbc) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a36d87a6ab; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36d87a6ab FOREIGN KEY (id_sharecode_vivo) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a384e17999; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a384e17999 FOREIGN KEY (id_sharecode_oi) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a38f3b56c6; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a38f3b56c6 FOREIGN KEY (id_sharecode_claro) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a3b7757f19; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a3b7757f19 FOREIGN KEY (id_sharecode_nextel) REFERENCES sharecode(id_sharecode);


--
-- Name: fk7eec7271176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT fk7eec7271176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk7eec72712d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT fk7eec72712d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk948452b5176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT fk948452b5176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk948452b5591e957e; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT fk948452b5591e957e FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: fkde4affd0176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd0176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fkde4affd02d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd02d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fkde4affd0591e957e; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd0591e957e FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: fkdfc72a4b176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY mensagem
    ADD CONSTRAINT fkdfc72a4b176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: log_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: transacao_id_keycode_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_keycode_fk FOREIGN KEY (id_keycode) REFERENCES keycode(id_keycode);


--
-- Name: transacao_id_la_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_la_fk FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: transacao_id_mensagem_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_mensagem_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: transacao_id_parceiro_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_parceiro_fk FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: transacao_id_regra_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_regra_fk FOREIGN KEY (id_regra) REFERENCES regra(id_regra);


--
-- Name: transacao_id_sharecode_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_sharecode_fk FOREIGN KEY (id_sharecode) REFERENCES sharecode(id_sharecode);


--
-- Name: without_rule_msg_id_mensagem_fk; Type: FK CONSTRAINT; Schema: public; Owner: virtualgoods
--

ALTER TABLE ONLY without_rule_msg
    ADD CONSTRAINT without_rule_msg_id_mensagem_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

