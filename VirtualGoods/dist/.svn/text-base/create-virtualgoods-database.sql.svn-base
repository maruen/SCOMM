create table LA (id_la int8 not null, cd_ativo int4 not null, cd_claro int4 not null, cd_ctbc int4 not null, cd_nextel int4 not null, cd_oi int4 not null, cd_tim int4 not null, cd_vivo int4 not null, ds_la varchar(50) not null, dt_alteracao timestamp not null, dt_criacao timestamp not null, tx_mercuri_itemid int4 not null, tx_mercuri_password varchar(50) not null, tx_mercuri_serviceid int4 not null, tx_mercuri_url varchar(128) not null, tx_mercuri_username varchar(50) not null, nm_la varchar(50) not null unique, primary key (id_la));
create table Parceiro (id_parceiro int8 not null, cd_ativo int4 not null, dt_alteracao timestamp not null, dt_criacao timestamp not null, nm_parceiro varchar(50) not null unique, primary key (id_parceiro));
create table parceiro_la (id_parceiro int8 not null, id_la int8 not null);
alter table parceiro_la add constraint FK7EEC72712D1B52AE foreign key (id_parceiro) references Parceiro;
alter table parceiro_la add constraint FK7EEC7271176D21F2 foreign key (id_la) references LA;
create sequence la_seq;
create sequence parceiro_seq;
