create sequence tbl_user_seq increment by 1 minvalue 1 no maxvalue start with 1; 
create sequence t_address_id_seq increment by 1 minvalue 1 no maxvalue start with 1; 

CREATE TABLE t_user (
"id" int4 DEFAULT nextval('tbl_user_seq'::regclass) NOT NULL,
"user_name" varchar(40) COLLATE "default" NOT NULL,
"password" varchar(100) COLLATE "default",
"age" int4,
"create_datetime" timestamp(6) DEFAULT now(),
"update_datetime" timestamp(6) DEFAULT now(),
CONSTRAINT "t_user_pkey" PRIMARY KEY ("id")
)
WITH (OIDS=FALSE)
;

ALTER TABLE "public"."t_user" OWNER TO "postgres";

COMMENT ON COLUMN "public"."t_user"."user_name" IS '用户名称';

COMMENT ON COLUMN "public"."t_user"."password" IS '用户密码';

COMMENT ON COLUMN "public"."t_user"."age" IS '年龄';

COMMENT ON COLUMN "public"."t_user"."create_datetime" IS '创建时间';

COMMENT ON COLUMN "public"."t_user"."update_datetime" IS '更新时间';



CREATE TABLE  t_address (
"id" int4 DEFAULT nextval('t_address_id_seq'::regclass) NOT NULL,
"address" varchar(50) COLLATE "default" NOT NULL,
"address2" varchar(50) COLLATE "default",
"phone" varchar(20) COLLATE "default" NOT NULL,
"postal_code" varchar(20) COLLATE "default",
"create_datetime" timestamp(6) DEFAULT now() NOT NULL,
"update_datetime" timestamp(6) DEFAULT now() NOT NULL,
"user_id" int4 NOT NULL,
CONSTRAINT "t_address_pkey" PRIMARY KEY ("id")
)
WITH (OIDS=FALSE)
;

ALTER TABLE "public"."t_address" OWNER TO "postgres";

COMMENT ON COLUMN "public"."t_address"."address" IS '地址1';

COMMENT ON COLUMN "public"."t_address"."address2" IS '地址2';

COMMENT ON COLUMN "public"."t_address"."phone" IS '手机号';

COMMENT ON COLUMN "public"."t_address"."postal_code" IS '邮政编码';

COMMENT ON COLUMN "public"."t_address"."create_datetime" IS '创建时间';

COMMENT ON COLUMN "public"."t_address"."update_datetime" IS '更新时间';

COMMENT ON COLUMN "public"."t_address"."user_id" IS '用户ID';