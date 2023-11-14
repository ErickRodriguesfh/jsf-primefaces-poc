-- noinspection SqlDialectInspectionForFile

CREATE TABLE ramo_atividade (id BIGINT AUTO_INCREMENT PRIMARY KEY, descricao VARCHAR(80) NOT NULL);
CREATE TABLE empresa (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome_fantasia VARCHAR(80)  NOT NULL, razao_social VARCHAR(120) NOT NULL, cnpj VARCHAR(18) NOT NULL, data_fundacao DATE, ramo_atividade_id BIGINT NOT NULL, tipo VARCHAR(30) NOT NULL, faturamento DECIMAL(10, 2), FOREIGN KEY (ramo_atividade_id) REFERENCES ramo_atividade (id));
CREATE INDEX empresa_ramo_atividade_idx ON empresa (ramo_atividade_id);
