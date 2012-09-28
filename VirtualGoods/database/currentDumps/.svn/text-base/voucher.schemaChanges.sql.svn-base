create table voucher (
	voucher_id bigint NOT NULL,
	id_mensagem bigint NOT NULL,
	id_transacao bigint NOT NULL,
	id_campanha bigint NOT NULL,
	msisdn character varying(50) NOT NULL,
	voucher_code character varying(50) NOT NULL,
	voucher_value double precision NOT NULL,
	purchase_date timestamp without time zone NOT NULL,
	expiration_date timestamp without time zone,
	is_consumed Integer NOT NULL,
	consumption_date timestamp without time zone,
	voucher_mt_sent Integer NOT NULL   
);


ALTER TABLE ONLY voucher
    ADD CONSTRAINT voucher_id_mensagem_uq UNIQUE (id_mensagem);

ALTER TABLE ONLY voucher
    ADD CONSTRAINT voucher_code_uq UNIQUE (voucher_code);

ALTER TABLE ONLY voucher
    ADD CONSTRAINT voucher_id_pk PRIMARY KEY (voucher_id);

ALTER TABLE ONLY voucher
    ADD CONSTRAINT voucher_id_mensagem_fk FOREIGN KEY (id_mensagem) REFERENCES mensagem(id_mensagem);

ALTER TABLE ONLY parceiro
   ADD CONSTRAINT voucher_ws_login_uq UNIQUE (voucher_ws_login);

CREATE TABLE vg_flow (
        flow_id int NOT NULL,
        flow_type int NOT NULL,
        flow_name character varying(50) NOT NULL,
        flow_description character varying(200) NOT NULL
);

ALTER TABLE vg_flow 
        ADD CONSTRAINT vg_flows_flow_id_pk PRIMARY KEY (flow_id);
        
ALTER TABLE ONLY vg_flow
    ADD CONSTRAINT vg_flows_flow_type_uq UNIQUE (flow_type);

CREATE TABLE option_in (
    id_option_in bigint NOT NULL,
    id_transacao bigint NOT NULL,
    id_campanha bigint NOT NULL,
    msg_option_in_sent integer NOT NULL default 0,
    cd_msisdn character varying(50) NOT NULL,
    cd_operadora integer NOT NULL,
    vl_compra double precision NOT NULL,
    dt_compra timestamp without time zone NOT NULL,
    time_of_authorization timestamp without time zone,
    is_authorized integer NOT NULL default 0
);

ALTER TABLE ONLY option_in ADD CONSTRAINT option_in_id_option_in_pk PRIMARY KEY (id_option_in);
ALTER TABLE ONLY option_in ADD CONSTRAINT option_in_id_transacao_un UNIQUE (id_transacao);
ALTER TABLE ONLY option_in ADD CONSTRAINT option_in_id_transacao_fk FOREIGN KEY (id_transacao) REFERENCES transacao(id_transacao);


CREATE SEQUENCE voucher_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE vg_flow_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
    
CREATE SEQUENCE without_campaign_msg_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE option_in_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

DROP SEQUENCE without_rule_msg_seq;
    
ALTER TABLE regra DROP COLUMN cd_autoriza_parceiro;

ALTER TABLE campanha ADD COLUMN description CHARACTER VARYING(50) DEFAULT 'DEFAULT' NOT NULL;    
ALTER TABLE campanha ADD COLUMN flow_type INTEGER DEFAULT 1 NOT NULL; 
ALTER TABLE campanha ADD COLUMN txt_mt_voucher CHARACTER VARYING(255);
ALTER TABLE campanha ADD COLUMN txt_mt_option_in CHARACTER VARYING(255);
ALTER TABLE campanha RENAME COLUMN nm_campanha TO keyword;

ALTER TABLE logger_message ADD COLUMN shortcode CHARACTER VARYING(50) DEFAULT 'GENERIC' NOT NULL;

ALTER TABLE without_rule_msg RENAME TO without_campaign_msg;
ALTER TABLE without_campaign_msg RENAME COLUMN id_without_rule_msg TO id;

ALTER TABLE transacao ADD COLUMN double_option_in integer not null default 0;
    
ALTER TABLE historico DROP COLUMN st_historico;
ALTER TABLE historico DROP COLUMN tp_historico;       
ALTER TABLE historico ADD COLUMN statusType character varying(50) NOT NULL;
ALTER TABLE historico ADD COLUMN messageStatus character varying(50) NOT NULL;

ALTER TABLE mensagem_resposta DROP COLUMN st_mensagem; 
ALTER TABLE mensagem_resposta ADD COLUMN messageStatus character varying(50) NOT NULL;

ALTER TABLE mensagem DROP COLUMN st_mensagem;
ALTER TABLE mensagem ADD COLUMN messageStatus character varying(50) NOT NULL;

ALTER TABLE transacao DROP COLUMN st_transacao;
ALTER TABLE transacao ADD COLUMN transactionStatus character varying(50) NOT NULL;

ALTER TABLE parceiro ADD COLUMN voucher_size INTEGER DEFAULT 6 NOT NULL;
ALTER TABLE parceiro ADD COLUMN voucher_ws_login  character varying(12);
ALTER TABLE parceiro ADD COLUMN voucher_ws_passwd character varying(12);


