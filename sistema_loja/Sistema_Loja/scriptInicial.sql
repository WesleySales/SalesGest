create database sistema_loja;
use  sistema_loja;


create table cargo_funcionario(
	id_cargo int primary key auto_increment,
    nome_cargo varchar(40)
);

create table funcionario (
	id_funcionario int primary key auto_increment,
    nome_funcionario varchar (30),
    sobrenome_funcionario varchar (30),
    login_funcionario varchar (30) unique,
    senha_funcionario varchar (30),
    id_cargo int,
    foreign key (id_cargo) references cargo_funcionario(id_cargo)
);

create table categoria(
	id_categoria int primary key auto_increment,
    nome_categoria varchar(60)
);

create table produto(
	id_produto int primary key auto_increment,
    nome_produto varchar(30),
    preco_produto double,
    estoque int
);

-- selects
select * from cargo_funcionario;
select * from funcionario;
select * from categoria;
select * from produto;

-- create views

-- visualização geral dos produtos
create view vw_produtos_visao_geral as (
	select p.id_produto, c.nome_categoria as categoria,p.nome_produto,
	p.preco_produto, p.estoque
	from produto p 
	join categoria c on p.id_categoria = c.id_categoria 
);
select * from vw_produtos_visao_geral;


-- visualização geral dos funcionários
create view vw_funcionario_geral as (
	select f.id_funcionario,f.nome_funcionario, f.sobrenome_funcionario, f.login_funcionario, 
    f.senha_funcionario, cf.nome_cargo as cargo 
	from funcionario f
	join cargo_funcionario cf on f.id_cargo=cf.id_cargo
);

select * from vw_funcionario_geral;

