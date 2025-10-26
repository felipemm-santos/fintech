-- Scripts para deletar as tabelas

/*
DROP TABLE T_FTC_USER CASCADE CONSTRAINTS;
DROP TABLE T_FTC_INCOME CASCADE CONSTRAINTS;
DROP TABLE T_FTC_EXPENSE CASCADE CONSTRAINTS;
DROP TABLE T_FTC_INVESTMENT CASCADE CONSTRAINTS;
DROP TABLE T_FTC_INVESTMENT_OPERATION CASCADE CONSTRAINTS;
DROP TABLE T_FTC_FINANCIAL_GOAL CASCADE CONSTRAINTS;
DROP TABLE T_FTC_USER_CATEGORY CASCADE CONSTRAINTS;

DROP SEQUENCE seq_user;
DROP SEQUENCE seq_investment;
DROP SEQUENCE seq_investment_operation;
DROP SEQUENCE seq_financial_goal;
DROP SEQUENCE seq_income;
DROP SEQUENCE seq_expense;
DROP SEQUENCE seq_user_category;
*/

-- Scripts para criar as tabelas e chaves primárias

-- Tabela usuário
CREATE SEQUENCE seq_user START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_USER
(
    id_user            INTEGER DEFAULT seq_user.nextval NOT NULL,
    nm_user            VARCHAR2(50) NOT NULL,
    dt_birth           DATE                             NOT NULL,
    ds_genre           CHAR(1)                          NOT NULL,
    dt_createdAt       DATE                             NOT NULL,
    tx_url_img_profile VARCHAR2(255),
    tx_email           VARCHAR2(255) NOT NULL,
    tx_password        VARCHAR2(255) NOT NULL
);

ALTER TABLE T_FTC_USER
    ADD CONSTRAINT user_pk PRIMARY KEY (id_user);

ALTER TABLE T_FTC_USER
    ADD CONSTRAINT user_genre_pk CHECK ( ds_genre = 'M' OR ds_genre = 'F');

-- Tabela investimento
CREATE SEQUENCE seq_investment START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_INVESTMENT
(
    id_investment         INTEGER DEFAULT seq_investment.nextval NOT NULL,
    id_user               INTEGER                                NOT NULL,
    nm_investment         VARCHAR2(50) NOT NULL,
    dt_createdAt          DATE                                   NOT NULL,
    nr_liquidityInDays    INTEGER                                NOT NULL,
    dt_maturity           DATE,
    ds_assetType          VARCHAR2(30) NOT NULL,
    ds_investmentCategory VARCHAR(50)                            NOT NULL,
    vl_annulRate          NUMBER(3, 4),
    ds_index              VARCHAR2(50) NOT NULL,
    vl_tax                NUMBER(3,4)
);

ALTER TABLE T_FTC_INVESTMENT
    ADD CONSTRAINT investment_pk PRIMARY KEY (id_investment);

-- Tabela operação de investimento
CREATE SEQUENCE seq_investment_operation START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_INVESTMENT_OPERATION
(
    id_operation     INTEGER DEFAULT seq_investment_operation.nextval NOT NULL,
    id_user          INTEGER                                          NOT NULL,
    id_investment    INTEGER                                          NOT NULL,
    ds_operationType VARCHAR(50),
    ds_operation     VARCHAR2(100),
    dt_operation     DATE                                             NOT NULL,
    nr_shares        INTEGER,
    vl_sharePrice    NUMBER(7, 2),
    vl_totalAmount   NUMBER(10,2),
    vl_taxPaid       NUMBER(7,2)
);

ALTER TABLE T_FTC_INVESTMENT_OPERATION
    ADD CONSTRAINT investment_operation_pk PRIMARY KEY (id_operation);

-- Tabela objetivo financeiro
CREATE SEQUENCE seq_financial_goal START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_FINANCIAL_GOAL
(
    id_goal           INTEGER DEFAULT seq_financial_goal.nextval NOT NULL,
    id_user           INTEGER                                    NOT NULL,
    nm_goal           VARCHAR2(20) NOT NULL,
    vl_targetAmount   NUMBER(7, 2) NOT NULL,
    vl_currentAmount  NUMBER(7, 2) NOT NULL,
    dt_targetDate     DATE                                       NOT NULL,
    st_status         NUMBER(1) NOT NULL,
    ds_goal           VARCHAR2(50),
    dt_completionDate DATE,
    dt_createdAt      DATE NOT NULL
);

ALTER TABLE T_FTC_FINANCIAL_GOAL
    ADD CONSTRAINT financial_goal_pk PRIMARY KEY (id_goal);

-- Tabela receita
CREATE SEQUENCE seq_income START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_INCOME
(
    id_income   INTEGER DEFAULT seq_income.nextval NOT NULL,
    id_user     INTEGER                            NOT NULL,
    id_category INTEGER                            NOT NULL,
    ds_income   VARCHAR2(30) NOT NULL,
    vl_income   NUMBER(7, 2) NOT NULL,
    st_status   VARCHAR2(30) NOT NULL,
    dt_dueDate  DATE,
    dt_income   DATE                               NOT NULL
);

ALTER TABLE T_FTC_INCOME
    ADD CONSTRAINT income_pk PRIMARY KEY (id_income);

-- Tabela despesa
CREATE SEQUENCE seq_expense START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_EXPENSE
(
    id_expense  INTEGER DEFAULT seq_expense.nextval NOT NULL,
    id_user     INTEGER                             NOT NULL,
    id_category INTEGER                             NOT NULL,
    ds_expense  VARCHAR2(30) NOT NULL,
    vl_expense  NUMBER(7, 2) NOT NULL,
    st_status   VARCHAR2(30) NOT NULL,
    dt_dueDate  DATE,
    dt_expense  DATE

);

ALTER TABLE T_FTC_EXPENSE
    ADD CONSTRAINT expense_pk PRIMARY KEY (id_expense);

-- Tabela categorias criadas pelo usuário
CREATE SEQUENCE seq_user_category START WITH 1 INCREMENT BY 1;
CREATE TABLE T_FTC_USER_CATEGORY
(
    id_category     INTEGER DEFAULT seq_user_category.nextval NOT NULL,
    nm_category     VARCHAR2(40) NOT NULL,
    ds_categoryType VARCHAR(30)                               NOT NULL
);

ALTER TABLE T_FTC_USER_CATEGORY
    ADD CONSTRAINT user_category_pk PRIMARY KEY (id_category);

-- Scripts para adicionar chaves estrangeiras

ALTER TABLE T_FTC_EXPENSE
    ADD CONSTRAINT expense_category_fk FOREIGN KEY (id_category) REFERENCES T_FTC_USER_CATEGORY (id_category);

ALTER TABLE T_FTC_EXPENSE
    ADD CONSTRAINT expense_user_fk FOREIGN KEY (id_user) REFERENCES T_FTC_USER (id_user);

ALTER TABLE T_FTC_INCOME
    ADD CONSTRAINT income_category_fk FOREIGN KEY (id_category) REFERENCES T_FTC_USER_CATEGORY (id_category);

ALTER TABLE T_FTC_INCOME
    ADD CONSTRAINT income_user_fk FOREIGN KEY (id_user) REFERENCES T_FTC_USER (id_user);

ALTER TABLE T_FTC_INVESTMENT
    ADD CONSTRAINT investment_user_fk FOREIGN KEY (id_user) REFERENCES T_FTC_USER (id_user);

ALTER TABLE T_FTC_INVESTMENT_OPERATION
    ADD CONSTRAINT invest_operation_user_fk FOREIGN KEY (id_user) REFERENCES T_FTC_USER (id_user);

ALTER TABLE T_FTC_INVESTMENT_OPERATION
    ADD CONSTRAINT invest_operation_investment_fk FOREIGN KEY (id_investment) REFERENCES T_FTC_INVESTMENT (id_investment);

ALTER TABLE T_FTC_FINANCIAL_GOAL
    ADD CONSTRAINT goal_user_fk FOREIGN KEY (id_user) REFERENCES T_FTC_USER (id_user);

