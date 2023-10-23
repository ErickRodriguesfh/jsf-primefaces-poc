INSERT INTO ramo_atividade (id, descricao)
VALUES (1, 'Distribuicao de alimentos'),
       (2, 'Telecomunicações'),
       (3, 'Vestuário'),
       (4, 'Lavanderia'),
       (5, 'Gráfica'),
       (6, 'Mecânica'),
       (7, 'Turismo'),
       (8, 'Saúde'),
       (9, 'Educação'),
       (10, 'Lazer');



INSERT INTO empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id)
VALUES (1, '70.311.193/0001-87', 'Mercado do João', 'João Mercado e Distribuidor de Alimentos Ltda', 'LTDA',
        '2009-03-02', 1),
       (2, '52.822.994/0001-25', 'Fale Mais', 'Fale Mais Telecom S.A.', 'SA', '1997-12-10', 2),
       (3, '41.952.519/0001-57', 'Maria de Souza da Silva', 'Maria de Souza da Silva', 'MEI', '2014-10-15', 3),
       (4, '16.134.777/0001-89', 'Gomes Inovação', 'José Fernando Gomes EIRELI ME', 'EIRELI', '2009-03-02', 4);