MySQL数据库学习
登陸：shell>mysql -uroot -p
修改提示符：
①shell>mysql -uroot -ppassward --prompt 提示符
②mysql>prompt 提示符
【參數】\D 完整的日期；\d 當前數據庫；\h 服務器名稱； \u 當前用戶；
修改定界符：DELIMITER 定界符;
修改存储引擎：ALTER TABLE table_name ENGINE [=] engine_name;
顯示當前服務器版本：SELECT VERSION;
顯示當前日期：SELECT NOW();
修改客户端编码方式：SET NAMES gbk;
顯示當前用戶：SELECT USER();
查看數據庫的默認引擎：show variables like 'default_storage_engine';
查看數據庫支持的引擎：show engines;或show variables like 'have%';
修改密碼：
①SET PASSWORD FOR ‘root’@’localhost’ = PASSWORD(‘newpass’);
②mysqladmin -u root password oldpassword “newpassword”
③UPDATE user SET Password = PASSWORD(‘newpassword’) WHERE user = ‘root’; 
創建數據庫：CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name [DEFAULT] CHARACTER SET [=] charset_name;
查看當前服務器下的數據表列表：SHOW {DATABASES | SCHEMAS} [LIKE 'pattern' | WHERE expr];
修改數據庫：ALTER {DATABASE | SCHEMA} [db_name] [DEFAULT] CHARACTER SET [=] charset_name;
刪除數據庫：DROP {DATABASE | SCHEMA} [IF EXISTS] db_name;
創建數據表：CREATE TABLE [IF NOT EXISTS] table_name(column_name data_type,...);
空與非空：NULL/NOT NULL;
有符號與無符號：SIGNED/UNSIGNED;
自動編號：AUTO_INCREMENT;
主鍵：PRIMARY KEY;
添加主鍵約束：ALTER TABLE tbl_name ADD [CONSTRAINT [symbol]] PRIMARY KEY [index_type] (index_col_name,...);
刪除主鍵約束：ALTER TABLE tbl_name DROP PRIMARY KEY;
唯一約束：UNIQUE KEY;
添加唯一約束：ALTER TABLE tbl_name ADD [CONSTRAINT [symbol]] UNIQUE [INDEX | KEY] [index_name] [index_type] (index_col_name,...);
刪除唯一約束：ALTER TABLE tbl_name DROP {INDEX | KEY} index_name；
默認約束：DEFAULT 值;
添加/刪除默認約束：ALTER TABLE tbl_name ALTER [COLUMN] col_name {SET DEFAULT literal | DROP DEFAULT};
查看數據表列表：SHOW TABLES [FROM db_name] [LIKE 'pattern' | WHERE expr];
查看數據表結構：SHOW COLUMNS FROM tb1_name;
插入記錄：INSERT [INTO] tbl_name [(col_name,...)] VALUES(val,...);
記錄查找：SELECT expr,... FROM tbl_name;
查看索引：SHOW INDEXES FROM table_name;
外鍵約束：FOREIGN KEY (pid) REFERENCES provinces (id);外鍵列pid，參照列id；
添加外鍵約束：ALTER TABLE tbl_name ADD [CONSTRAINT [symbol]] FOREIGN KEY [index_name](index_col_name,...) reference_definition;
刪除外鍵約束：ALTER TABLE tbl_name DROP FOREIGN KEY fk_symbol;
外鍵約束的參照操作：
①CASCADE:從父表刪除或更新且自動刪除或更新子表中匹配的行。
②SET NULL:從父表刪除或更新行，並設置子表中的外鍵列為NULL。
③RESTRICT:拒絕對父表的刪除或更新操作。
④NO ACTION:標準SQL的關鍵字，在MySQL中與RESTRICT相同。
添加單列：ALTER TABLE tbl_name ADD [COLUMN] col_name column_definition [FIRST | AFTER col_name];
添加多列：ALTER TABLE tbl_name ADD [COLUMN] (col_name column_definition,...);
刪除列：ALTER TABLE tbl_name DROP [COLUMN] col_name;
修改列定義：
①ALTER TABLE tbl_name MODIFY [COLUMN] col_name column_definition [FIRST | AFTER col_name];
②ALTER TABLE tbl_name CHANGE [COLUMN] old_col_name new_col_name column_definition [FIRST | AFTER col_name];
修改數據表名：
①ALTER TABLE tbl_name RENAME [TO|AS] new_tbl_name;
②RENAME TABLE tbl_name TO new_tbl_name [, tbl_name TO new_tbl_name2]...
插入记录：
①INSERT [INTO] tbl_name [(col_name,...)] {VALUES | VALUE} ({expr | DEFAULT},...),(...),...
②INSERT [INTO] tbl_name SET col_name={expr | DEFAULT},...
③INSERT [INTO] tbl_name [(col_name,...)] SELECT ...
更新记录：
①单表更新：UPDATE [LOW_PRIORITY] [IGNORE] table_reference SET col_name1={expr1 | DEFAULT} [,col_name2={expr2 | DEFAULT}]...[WHERE where_condition];
②多表更新：UPDATE table_reference SET col_name1 = {expr1 | DEFAULT} [,col_name2 = {expr2 | DEFAULT}]...[WHERE where_condition];
删除记录：
①单表删除：DELETE FROM tbl_name [WHERE where_condition];
②多表删除：DELETE tbl_name[.*] [,tbl_name[.*]]... FROM table_reference [WHERE where_condition];
查找记录：
SELECT select_expr [,select_expr ...]
[	
	FROM table_reference
	[WHERE where_condition]
	[GROUP BY {col_name | position} [ASC | DESC],...]
	[HAVING where_condition]
	[ORDER BY {col_name | expr | position} [ASC|DESC],...]
	[LIMIT {[offset,] row_count | row_count OFFSET offset}]
]
表连接：table_reference {[INNER | CROSS] JOIN | {LEFT | RIGHT} [OUTER] JOIN} table_reference ON join_condition;
内链接：显示左表及右表符合连接条件的记录；
左外连接：显示左表的全部记录及右表符合连接条件的记录；
右外连接：显示右表的全部记录及左表符合连接条件的记录；
e.g. SELECT col_name... FROM tbl_name1 INNER JOIN tbl_name2 ON condition_expr;
创建数据表同时将查询结果写入到数据表：CREATE TABLE [IF NOT EXISTS] tbl_name [(create_definition,...)] select_statement;
创建自定义函数：
①CREATE FUNCTION function_name(参数1,...) RETURNS {STRING | INTEGER | REAL | DECIMAL} routine_body; 
②CREATE FUNCTION function_name(参数1,...) RETURNS 返回值 RETURN 函数体; 
复合结构用BEGIN...END;
删除自定义函数：DROP FUNCTION function_name;
创建存储过程：
CREATE 
[DEFINER = {user | CURRENT_USER}] 
PROCEDURE sp_name([proc_parameter[,...]]) 
[characteristic ...] routine_body
proc_parameter:
[IN | OUT | INOUT] param_name type
调用存储过程：CALL sp_name([parameter[,...]]);
删除存储过程：DROP PROCEDURE [IF EXISTS] sp_name;





