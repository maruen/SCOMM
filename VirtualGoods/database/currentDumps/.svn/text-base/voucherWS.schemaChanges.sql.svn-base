
ALTER TABLE voucher ADD COLUMN consumption_date_timestamp without time zone;

ALTER TABLE parceiro ADD COLUMN voucher_ws_login  character varying(12); 
ALTER TABLE parceiro ADD COLUMN voucher_ws_passwd character varying(12);

ALTER TABLE ONLY parceiro
   ADD CONSTRAINT voucher_ws_login_uq UNIQUE (voucher_ws_login);



