--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: billing_record_failure; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.billing_record_failure OWNER TO postgres;

--
-- Name: billing_record_failure_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE billing_record_failure_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.billing_record_failure_seq OWNER TO postgres;

--
-- Name: billing_record_success; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.billing_record_success OWNER TO postgres;

--
-- Name: billing_record_success_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE billing_record_success_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.billing_record_success_seq OWNER TO postgres;

--
-- Name: buy_config; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.buy_config OWNER TO postgres;

--
-- Name: buying_limit_exceed; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE buying_limit_exceed (
    id_buying_limit_exceed bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    dt_compra timestamp without time zone NOT NULL
);


ALTER TABLE public.buying_limit_exceed OWNER TO postgres;

--
-- Name: buying_limit_exceed_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE buying_limit_exceed_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.buying_limit_exceed_seq OWNER TO postgres;

--
-- Name: campanha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.campanha OWNER TO postgres;

--
-- Name: campanha_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE campanha_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.campanha_seq OWNER TO postgres;

--
-- Name: historico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.historico OWNER TO postgres;

--
-- Name: historico_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE historico_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.historico_seq OWNER TO postgres;

--
-- Name: keycode; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE keycode (
    id_keycode bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_keycode character varying(50) NOT NULL,
    id_parceiro bigint NOT NULL
);


ALTER TABLE public.keycode OWNER TO postgres;

--
-- Name: keycode_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE keycode_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.keycode_seq OWNER TO postgres;

--
-- Name: la; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.la OWNER TO postgres;

--
-- Name: la_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE la_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.la_seq OWNER TO postgres;

--
-- Name: log; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE log (
    id_log bigint NOT NULL,
    dt_criacao timestamp(6) without time zone NOT NULL,
    st_transacao integer NOT NULL,
    id_transacao bigint NOT NULL
);


ALTER TABLE public.log OWNER TO postgres;

--
-- Name: log_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE log_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.log_seq OWNER TO postgres;

--
-- Name: logger_message; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE logger_message (
    id_message bigint NOT NULL,
    string_message character varying(200) NOT NULL
);


ALTER TABLE public.logger_message OWNER TO postgres;

--
-- Name: mensagem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.mensagem OWNER TO postgres;

--
-- Name: mensagem_resposta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.mensagem_resposta OWNER TO postgres;

--
-- Name: mensagem_resposta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mensagem_resposta_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.mensagem_resposta_seq OWNER TO postgres;

--
-- Name: mensagem_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mensagem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.mensagem_seq OWNER TO postgres;

--
-- Name: operadora; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE operadora (
    cd_operadora integer NOT NULL,
    nm_operadora character varying(50) NOT NULL
);


ALTER TABLE public.operadora OWNER TO postgres;

--
-- Name: parceiro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.parceiro OWNER TO postgres;

--
-- Name: parceiro_la; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parceiro_la (
    id_parceiro bigint NOT NULL,
    id_la bigint NOT NULL
);


ALTER TABLE public.parceiro_la OWNER TO postgres;

--
-- Name: parceiro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parceiro_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.parceiro_seq OWNER TO postgres;

--
-- Name: protocol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE protocol_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 99999999999
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.protocol_seq OWNER TO postgres;

--
-- Name: regra; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.regra OWNER TO postgres;

--
-- Name: regra_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE regra_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.regra_seq OWNER TO postgres;

--
-- Name: sharecode; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.sharecode OWNER TO postgres;

--
-- Name: sharecode_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sharecode_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sharecode_seq OWNER TO postgres;

--
-- Name: tipo_campanha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_campanha (
    id_tipo_campanha bigint NOT NULL,
    cd_ativo integer NOT NULL,
    dt_alteracao timestamp without time zone NOT NULL,
    dt_criacao timestamp without time zone NOT NULL,
    nm_tipo_campanha character varying(50) NOT NULL,
    sg_tipo_campanha character varying(50) NOT NULL
);


ALTER TABLE public.tipo_campanha OWNER TO postgres;

--
-- Name: tipo_campanha_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_campanha_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipo_campanha_seq OWNER TO postgres;

--
-- Name: transacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.transacao OWNER TO postgres;

--
-- Name: transacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE transacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.transacao_seq OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
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


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.usuario_seq OWNER TO postgres;

--
-- Name: vg_config; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vg_config (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    value character varying(200),
    description character varying(200)
);


ALTER TABLE public.vg_config OWNER TO postgres;

--
-- Name: without_rule_msg; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE without_rule_msg (
    id_without_rule_msg bigint NOT NULL,
    id_mensagem bigint NOT NULL,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    tx_mensagem character varying(255)
);


ALTER TABLE public.without_rule_msg OWNER TO postgres;

--
-- Name: without_rule_msg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE without_rule_msg_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.without_rule_msg_seq OWNER TO postgres;

--
-- Name: billing_record_failure_id_billrec_failure_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_billrec_failure_pk PRIMARY KEY (id_billrec_failure);


--
-- Name: billing_record_failure_id_transacao_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_transacao_unique UNIQUE (id_transacao);


--
-- Name: billing_record_success_id_billrec_success_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_billrec_success_pk PRIMARY KEY (id_billrec_success);


--
-- Name: billing_record_success_id_transacao_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_transacao_unique UNIQUE (id_transacao);


--
-- Name: buying_limit_exceed_id_buying_limit_exceed_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_buying_limit_exceed_pk PRIMARY KEY (id_buying_limit_exceed);


--
-- Name: buying_limit_exceed_id_message_uq; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_message_uq UNIQUE (id_mensagem);


--
-- Name: campanha_nm_campanha_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_nm_campanha_key UNIQUE (nm_campanha);


--
-- Name: campanha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_pkey PRIMARY KEY (id_campanha);


--
-- Name: historico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT historico_pkey PRIMARY KEY (id_historico);


--
-- Name: keycode_nm_keycode_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT keycode_nm_keycode_key UNIQUE (nm_keycode);


--
-- Name: keycode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT keycode_pkey PRIMARY KEY (id_keycode);


--
-- Name: la_nm_la_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY la
    ADD CONSTRAINT la_nm_la_key UNIQUE (nm_la);


--
-- Name: la_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY la
    ADD CONSTRAINT la_pkey PRIMARY KEY (id_la);


--
-- Name: log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id_log);


--
-- Name: logger_message_id_message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logger_message
    ADD CONSTRAINT logger_message_id_message_pkey PRIMARY KEY (id_message);


--
-- Name: mensagem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mensagem
    ADD CONSTRAINT mensagem_pkey PRIMARY KEY (id_mensagem);


--
-- Name: mensagem_resposta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT mensagem_resposta_pkey PRIMARY KEY (id_mensagem_resposta);


--
-- Name: operadora_id_operadora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operadora
    ADD CONSTRAINT operadora_id_operadora_pkey PRIMARY KEY (cd_operadora);


--
-- Name: parceiro_la_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT parceiro_la_pkey PRIMARY KEY (id_la, id_parceiro);


--
-- Name: parceiro_nm_parceiro_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parceiro
    ADD CONSTRAINT parceiro_nm_parceiro_key UNIQUE (nm_parceiro);


--
-- Name: parceiro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parceiro
    ADD CONSTRAINT parceiro_pkey PRIMARY KEY (id_parceiro);


--
-- Name: regra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT regra_pkey PRIMARY KEY (id_regra);


--
-- Name: sharecode_nm_sharecode_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sharecode
    ADD CONSTRAINT sharecode_nm_sharecode_key UNIQUE (nm_sharecode, cd_operadora);


--
-- Name: sharecode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sharecode
    ADD CONSTRAINT sharecode_pkey PRIMARY KEY (id_sharecode);


--
-- Name: tipo_campanha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_campanha
    ADD CONSTRAINT tipo_campanha_pkey PRIMARY KEY (id_tipo_campanha);


--
-- Name: tipo_campanha_sg_tipo_campanha_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_campanha
    ADD CONSTRAINT tipo_campanha_sg_tipo_campanha_key UNIQUE (sg_tipo_campanha);


--
-- Name: transacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_pkey PRIMARY KEY (id_transacao);


--
-- Name: usuario_cd_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_cd_login_key UNIQUE (cd_login);


--
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- Name: vg_config_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vg_config
    ADD CONSTRAINT vg_config_name_key UNIQUE (name);


--
-- Name: vg_config_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vg_config
    ADD CONSTRAINT vg_config_pkey PRIMARY KEY (id);


--
-- Name: without_rule_msg_id_mensagem_uq; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY without_rule_msg
    ADD CONSTRAINT without_rule_msg_id_mensagem_uq UNIQUE (id_mensagem);


--
-- Name: without_rule_msg_id_without_rule_msg_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY without_rule_msg
    ADD CONSTRAINT without_rule_msg_id_without_rule_msg_pk PRIMARY KEY (id_without_rule_msg);


--
-- Name: billing_record_failure_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY billing_record_failure
    ADD CONSTRAINT billing_record_failure_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: billing_record_success_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY billing_record_success
    ADD CONSTRAINT billing_record_success_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: buying_limit_exceed_id_message_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buying_limit_exceed
    ADD CONSTRAINT buying_limit_exceed_id_message_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: campanha_id_regra_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_id_regra_fk FOREIGN KEY (id_regra) REFERENCES regra(id_regra);


--
-- Name: campanha_id_tipo_campanha_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_id_tipo_campanha_fk FOREIGN KEY (id_tipo_campanha) REFERENCES tipo_campanha(id_tipo_campanha);


--
-- Name: fk32a49cac2d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY keycode
    ADD CONSTRAINT fk32a49cac2d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk4b301a3176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a3176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk4b301a32d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a32d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk4b301a359b93b70; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a359b93b70 FOREIGN KEY (id_keycode) REFERENCES keycode(id_keycode);


--
-- Name: fk4b301a36426a449; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36426a449 FOREIGN KEY (id_sharecode_tim) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a36d7f2a71; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36d7f2a71 FOREIGN KEY (id_sharecode_ctbc) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a36d87a6ab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a36d87a6ab FOREIGN KEY (id_sharecode_vivo) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a384e17999; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a384e17999 FOREIGN KEY (id_sharecode_oi) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a38f3b56c6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a38f3b56c6 FOREIGN KEY (id_sharecode_claro) REFERENCES sharecode(id_sharecode);


--
-- Name: fk4b301a3b7757f19; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regra
    ADD CONSTRAINT fk4b301a3b7757f19 FOREIGN KEY (id_sharecode_nextel) REFERENCES sharecode(id_sharecode);


--
-- Name: fk7eec7271176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT fk7eec7271176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk7eec72712d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parceiro_la
    ADD CONSTRAINT fk7eec72712d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fk948452b5176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT fk948452b5176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fk948452b5591e957e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mensagem_resposta
    ADD CONSTRAINT fk948452b5591e957e FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: fkde4affd0176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd0176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: fkde4affd02d1b52ae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd02d1b52ae FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: fkde4affd0591e957e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico
    ADD CONSTRAINT fkde4affd0591e957e FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: fkdfc72a4b176d21f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mensagem
    ADD CONSTRAINT fkdfc72a4b176d21f2 FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: log_id_transacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


--
-- Name: transacao_id_keycode_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_keycode_fk FOREIGN KEY (id_keycode) REFERENCES keycode(id_keycode);


--
-- Name: transacao_id_la_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_la_fk FOREIGN KEY (id_la) REFERENCES la(id_la);


--
-- Name: transacao_id_mensagem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_mensagem_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);


--
-- Name: transacao_id_parceiro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_parceiro_fk FOREIGN KEY (id_parceiro) REFERENCES parceiro(id_parceiro);


--
-- Name: transacao_id_regra_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_regra_fk FOREIGN KEY (id_regra) REFERENCES regra(id_regra);


--
-- Name: transacao_id_sharecode_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transacao
    ADD CONSTRAINT transacao_id_sharecode_fk FOREIGN KEY (id_sharecode) REFERENCES sharecode(id_sharecode);


--
-- Name: without_rule_msg_id_mensagem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
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

