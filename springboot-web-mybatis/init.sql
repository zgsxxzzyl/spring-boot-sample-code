CREATE TABLE "T_DA_HYFL"
   (	"ID" NUMBER(20,0) NOT NULL ENABLE,
	"FDATE" DATE,
	"HYFL" VARCHAR2(100),
	"HYSX" VARCHAR2(100),
	"HYBK" VARCHAR2(100),
	"BZ" VARCHAR2(100)
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATAMODEL" ;


   COMMENT ON COLUMN "DATAMODEL"."T_DA_HYFL"."FDATE" IS '更新日期';

   COMMENT ON COLUMN "DATAMODEL"."T_DA_HYFL"."HYFL" IS '行业分类';

   COMMENT ON COLUMN "DATAMODEL"."T_DA_HYFL"."HYSX" IS '行业属性：进攻属性、防御属性';

   COMMENT ON COLUMN "DATAMODEL"."T_DA_HYFL"."HYBK" IS '行业板块：高科技、证券、农业、医疗、消费、矿产';

   COMMENT ON COLUMN "DATAMODEL"."T_DA_HYFL"."BZ" IS '备注';

   COMMENT ON TABLE "DATAMODEL"."T_DA_HYFL"  IS '行业分类表';

create sequence seq_Id
increment by 1
start with 1
maxvalue 999999999;