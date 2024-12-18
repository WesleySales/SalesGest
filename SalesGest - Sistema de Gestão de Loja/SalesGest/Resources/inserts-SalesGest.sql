-- inserts para teste
INSERT INTO cargo_funcionario (nome_cargo, remuneracao_base) VALUES
('GERENTE', 5000),
('VENDEDOR', 2500);

INSERT INTO categoria (nome_categoria) VALUES
('Eletrônicos'),
('Eletrodomésticos'),
('Móveis'),
('Roupas'),
('Alimentos');

INSERT INTO funcionario (nome_funcionario, sobrenome_funcionario, login_funcionario, senha_funcionario, id_cargo, telefone_funcionario) VALUES
('Carlos', 'Silva', 'carlos_gerente', 'senha123', 1, '11987654321'),
('Mariana', 'Costa', 'mariana_gerente', 'senha123', 1, '11987654322'),
('João', 'Pereira', 'joao_vendedor', 'senha123', 2, '11987654323'),
('Ana', 'Souza', 'ana_vendedora', 'senha123', 2, '11987654324'),
('Pedro', 'Lima', 'pedro_vendedor', 'senha123', 2, '11987654325');

INSERT INTO produto (nome_produto, preco_produto, estoque, id_categoria) VALUES
('Smartphone', 1500.00, 50, 1),
('Geladeira', 3000.00, 20, 2),
('Sofá', 1200.00, 15, 3),
('Camiseta', 50.00, 200, 4),
('Arroz', 20.00, 500, 5),
('Televisão', 2000.00, 25, 1),
('Fogão', 700.00, 10, 2),
('Mesa de Jantar', 800.00, 5, 3),
('Calça Jeans', 100.00, 150, 4),
('Feijão', 10.00, 300, 5);

INSERT INTO venda (id_funcionario, data_venda, valor_total_venda, status_venda) VALUES
(3, '2024-06-01', 1600, 'PAGO'),     -- Venda de João
(4, '2024-06-02', 3050, 'PAGO'),     -- Venda de Ana
(5, '2024-06-03', 50, 'CANCELADO'),  -- Venda de Pedro
(3, '2024-06-04', 3000, 'ABERTO');   -- Venda de João

INSERT INTO item_venda (id_produto, quantidade_produto, valor_item, id_venda) VALUES
(1, 1, 1500, 1),  -- Smartphone na venda 1
(5, 5, 100, 1),   -- Arroz na venda 1
(2, 1, 3000, 2),  -- Geladeira na venda 2
(4, 1, 50, 3),    -- Camiseta na venda 3
(3, 2, 2400, 4);  -- Sofá na venda 4

INSERT INTO pagamento (id_venda, metodo_pagamento, valor, status_pagamento, data_pagamento) VALUES
(1, 'PIX', 1600.00, 'APROVADO', '2024-06-01 10:00:00'),
(2, 'CARTAO', 3050.00, 'APROVADO', '2024-06-02 14:00:00'),
(3, 'BOLETO', 50.00, 'CANCELADO', '2024-06-03 16:30:00'),
(4, 'PIX', 3000.00, 'PENDENTE', '2024-06-04 12:00:00');
