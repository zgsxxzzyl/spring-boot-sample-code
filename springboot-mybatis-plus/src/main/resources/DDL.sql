-- 创建用户表
CREATE TABLE test_user
(
    id          NUMBER(20) NOT NULL,
    name        VARCHAR2(100),
    age         NUMBER(3),
    email       VARCHAR2(200),
    status      VARCHAR2(10) DEFAULT '1',
    create_time DATE         DEFAULT SYSDATE,
    CONSTRAINT pk_test_user PRIMARY KEY (id)
);

-- 添加注释
COMMENT ON TABLE test_user IS '用户信息表';
COMMENT ON COLUMN test_user.id IS '主键ID';
COMMENT ON COLUMN test_user.name IS '用户姓名';
COMMENT ON COLUMN test_user.age IS '年龄';
COMMENT ON COLUMN test_user.email IS '邮箱地址';
COMMENT ON COLUMN test_user.status IS '状态：0-禁用，1-启用';
COMMENT ON COLUMN test_user.create_time IS '创建时间';
