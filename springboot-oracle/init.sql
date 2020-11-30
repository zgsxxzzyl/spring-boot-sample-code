CREATE TABLE T_USERS (
	ID LONG(100),
	USERNAME VARCHAR2(100)
)

create sequence seq_Id
increment by 1
start with 1
maxvalue 999999999;