
DELIMITER $$

CREATE TRIGGER calcula_valor_total_venda
AFTER INSERT ON item_venda
FOR EACH ROW
BEGIN
    UPDATE venda
    SET valor_total_venda = (
        SELECT SUM(it.valor_item)
        FROM item_venda it
        WHERE it.id_venda = NEW.id_venda
    )
    WHERE id_venda = NEW.id_venda;
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER recalcula_valor_item
BEFORE UPDATE ON item_venda
FOR EACH ROW
BEGIN
    DECLARE preco_unitario DECIMAL(10, 2);
    SELECT preco_produto INTO preco_unitario
    FROM produto
    WHERE produto.id_produto = NEW.id_produto;
    SET NEW.valor_item = preco_unitario * NEW.quantidade_produto;
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER calcula_valor_item
BEFORE INSERT ON item_venda
FOR EACH ROW
BEGIN
    DECLARE preco_unitario DECIMAL(10, 2);
    SELECT preco_produto INTO preco_unitario
    FROM produto
    WHERE produto.id_produto = NEW.id_produto;

    -- Calcular o valor do item
    SET NEW.valor_item = preco_unitario * NEW.quantidade_produto;
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER recalcula_valor_total_venda
AFTER UPDATE ON item_venda
FOR EACH ROW
BEGIN
    UPDATE venda
    SET valor_total_venda = (
        SELECT SUM(it.valor_item)
        FROM item_venda it
        WHERE it.id_venda = NEW.id_venda
    )
    WHERE id_venda = NEW.id_venda;
END$$

DELIMITER ;