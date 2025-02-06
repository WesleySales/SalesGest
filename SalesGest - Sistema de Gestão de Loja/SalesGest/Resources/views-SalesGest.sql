-- create views
-- visualização geral dos produtos
create view vw_produtos_visao_geral as (
	select p.id_produto, c.nome_categoria as categoria,p.nome_produto,
	p.preco_produto, p.estoque
	from produto p 
	join categoria c on p.id_categoria = c.id_categoria 
);
-- visualização geral dos funcionários
create view vw_funcionario_geral as (
	select f.id_funcionario,f.nome_funcionario, f.sobrenome_funcionario, f.login_funcionario, 
    f.senha_funcionario, cf.nome_cargo as cargo cf.remuneracao_base as salario
	from funcionario f
	join cargo_funcionario cf on f.id_cargo=cf.id_cargo
);

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_item_venda` AS (select `iv`.`id_produto` AS `codigo`,`p`.`nome_produto` AS `produto`,`p`.`preco_produto` AS `preco_unitario`,`iv`.`quantidade_produto` AS `quantidade`,`iv`.`valor_item` AS `valor` from ((`venda` `v` join `item_venda` `iv` on(`v`.`id_venda` = `iv`.`id_venda`)) join `produto` `p` on(`iv`.`id_produto` = `p`.`id_produto`)));
