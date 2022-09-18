/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     2022/4/19 14:41:34                           */
/*==============================================================*/


drop table if exists CLOUD_ACCEPTANCE_APP_OPERA;

drop table if exists CLOUD_AUTH_PERSON_REPL_REC;

drop table if exists CLOUD_CLASS_GROUP;

drop table if exists CLOUD_DECORATION_PROCESS;

drop table if exists CLOUD_DISPATCH_PROCEDURE;

drop table if exists CLOUD_FINISH_PROC_MEMBER;

drop table if exists CLOUD_HOUSE_TYPE;

drop table if exists CLOUD_HOUSE_TYPE_PROCESS_FEED;

drop table if exists CLOUD_LABOR_SERVICE_COMPANY;

drop table if exists CLOUD_MATERIALS_BILL;

drop table if exists CLOUD_MATERIAL_DISPATCH_TASK;

drop table if exists CLOUD_MATERIAL_DISTRIBUTE_DTL;

drop table if exists CLOUD_MATERIAL_SENDER_INFO;

drop table if exists CLOUD_PHASE_PROJECT_RESOURCES;

drop table if exists CLOUD_PRJ_LABOR_TEAM_GROUP;

drop table if exists CLOUD_PRJ_PLAN_ROOM_OPERATION;

drop table if exists CLOUD_PROCESS_QUANTITIES;

drop table if exists CLOUD_PROC_START_TIME_REQ;

drop table if exists CLOUD_PROC_START_TIME_REQ2;

drop table if exists CLOUD_PROJECT;

drop table if exists CLOUD_PROJECT_BUILDING;

drop table if exists CLOUD_PROJECT_LABOR_COMPANY;

drop table if exists CLOUD_PROJECT_LABOR_TEAM;

drop table if exists CLOUD_PROJECT_PERSON;

drop table if exists CLOUD_PROJECT_PHASE_PLAN;

drop table if exists CLOUD_PROJECT_PLAN;

drop table if exists CLOUD_PROJECT_PLAN_SCOPE;

drop table if exists CLOUD_PROJECT_ROOM;

drop table if exists CLOUD_PROJECT_TEAM_PERSONNEL;

drop table if exists CLOUD_PROJECT_UNIT;

drop table if exists CLOUD_ROOM_MATERIALS;

drop table if exists CLOUD_ROOM_PROCEDURE;

drop table if exists CLOUD_SENDER;

drop table if exists CLOUD_SUB_APPROVAL_INFO;

drop table if exists CLOUD_TASK_DISPATCH;

drop table if exists CLOUD_TASK_DISPATCHER;

drop table if exists CLOUD_TASK_DISPATCH_DETAIL;

drop table if exists CLOUD_TEAM_SUB_PRICE;

drop table if exists CLOUD_WORKER_REGISTRATION;

drop table if exists CLOUD_WORK_TYPE_CONF;

drop table if exists CLOUD_WORK_TYPE_GROUP_CONF;

/*==============================================================*/
/* Table: CLOUD_ACCEPTANCE_APP_OPERA                            */
/*==============================================================*/
create table CLOUD_ACCEPTANCE_APP_OPERA 
(
   ID                   char(19)                       not null,
   CLOUD_TASK_DISPATCH_ID char(19)                       null,
   APPLICATION_TIME     DATE                           null,
   NOTIFICATION_ACCEPTANCE_TIME DATE                           null,
   ACTUAL_ACCEPTANCE_TIME DATE                           null,
   ACCEPTANCE_STATUS    char(2)                        null,
   `DESCRIBE`             varchar(300)                   null,
   ATTACHMENT           varchar(300)                   null,
   ACCEPTANCE_TYPE      char(2)                        null,
   OPERATION_STATUS     char(2)                        null,
   DRAINAGE_TIME        DATE                           null,
   DRAINAGE_CONFIRMATION_TIME DATE                           null,
   TRANSFER_TIME        DATE                           null,
   ACCEPTANCE_TIME      DATE                           null,
   TASK_RECIPIENT_ID    BIGINT                         null,
   TRANSFER_ID          BIGINT                         null,
   REMARK               varchar(300)                   null,
   TASK_RECIPIENT       varchar(200)                   null,
   TRANSFER             varchar(200)                   null,
   constraint PK_CLOUD_ACCEPTANCE_APP_OPERA primary key (ID)
)
;
alter table CLOUD_ACCEPTANCE_APP_OPERA add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_AUTH_PERSON_REPL_REC                            */
/*==============================================================*/
create table CLOUD_AUTH_PERSON_REPL_REC 
(
   ID                   char(19)                       not null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   COMPANY_NAME         varchar(300)                   null,
   ORIGINAL_AUTHORIZER_NAME varchar(200)                   null,
   ORIGINAL_AUTHORIZER_ID_NUM VARCHAR(18)                    null,
   ORIGINAL_AUTHORIZER_PHONE char(11)                       null,
   NOW_AUTHORIZER_NAME  varchar(200)                   null,
   NOW_AUTHORIZER_ID_NUM VARCHAR(18)                    null,
   NOW_AUTHORIZER_PHONE char(11)                       null,
   AUTHORIZED_CERTIFICATE varchar(300)                   null,
   AUDIT_STATUS         char(2)                        null,
   `DESCRIBE`             varchar(300)                   null,
   constraint PK_CLOUD_AUTH_PERSON_REPL_REC primary key (ID)
)
;
alter table CLOUD_AUTH_PERSON_REPL_REC add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_CLASS_GROUP                                     */
/*==============================================================*/
create table CLOUD_CLASS_GROUP 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   LABOR_SERVICE_COMPANY_NAME varchar(300)                   null,
   CLOUD_PROJECT_LABOR_TEAM_ID char(19)                       null,
   LABOR_TEAM_NAME      varchar(300)                   null,
   CLOUD_PRJ_LABOR_TEAM_GROUP_ID char(19)                       null,
   TEAM_NAME            varchar(300)                   null,
   CLASS_GROUP_CODE     varchar(300)                   null,
   TEAM_LEADER_ID       BIGINT                         null,
   LEADER_NAME          varchar(200)                   null,
   LEADER_PHONE         char(11)                       null,
   LEADER_ID_NUM        VARCHAR(18)                    null,
   GROUP_NAME           varchar(300)                   null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   STATUS               char(2)                        null,
   ATTACHMENT           varchar(300)                   null,
   ASSIGNMENT_PLANNING_TEAM_NAME varchar(300)                   null,
   DISTRIBUTION_MODE    char(2)                        null,
   IS_SMALL_WORK_TEAM   char(1)                        null,
   constraint PK_CLOUD_CLASS_GROUP primary key (ID)
)
;
alter table CLOUD_CLASS_GROUP add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_DECORATION_PROCESS                              */
/*==============================================================*/
create table CLOUD_DECORATION_PROCESS 
(
   ID                   char(19)                       not null,
   PROCESS_TYPE         char(2)                        null,
   PROCEDURE_NAME       varchar(300)                   null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   CLOUD_CLASS_GROUP_ID char(19)                       null,
   GROUP_NAME           varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   STATUS               char(2)                        null,
   STANDARD_PRICE       decimal(12,2)                  null,
   DAILY_WORKLOAD       varchar(300)                   null,
   UNIT_NAME            varchar(300)                   null,
   100_SQUARE_METER_ROOM_LABOR varchar(300)                   null,
   DAILY_STANDARD_PRODUCTIVITY varchar(300)                   null,
   ACCEPTANCE_DELAY_DAYS int                            null,
   constraint PK_CLOUD_DECORATION_PROCESS primary key (ID)
)
;
alter table CLOUD_DECORATION_PROCESS add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_DISPATCH_PROCEDURE                              */
/*==============================================================*/
create table CLOUD_DISPATCH_PROCEDURE 
(
   ID                   char(19)                       not null,
   CLOUD_ACCEPTANCE_APP_OPERA_ID char(19)                       null,
   CLOUD_TASK_DISPATCH_ID char(19)                       null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   PROCEDURE_NAME       varchar(300)                   null,
   ACCEPTANCE_DELAY_TIME int                            null,
   CLOUD_TASK_DISPATCH_DETAIL_ID char(19)                       null,
   ROOM_NAME            varchar(300)                   null,
   STATUS               char(2)                        null,
   ATTACHMENT           varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   ACCEPTANCE_TYPE      char(2)                        null,
   APPLICATION_TIME     DATE                           null,
   ACTUAL_ACCEPTANCE_TIME DATE                           null,
   constraint PK_CLOUD_DISPATCH_PROCEDURE primary key (ID)
)
;
alter table CLOUD_DISPATCH_PROCEDURE add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_FINISH_PROC_MEMBER                              */
/*==============================================================*/
create table CLOUD_FINISH_PROC_MEMBER 
(
   ID                   char(19)                       not null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_TASK_DISPATCHER_ID char(19)                       null,
   TASK_DISPATCHER_NAME varchar(200)                   null,
   MEMBER               varchar(200)                   null,
   GROUP_NAME           varchar(300)                   null,
   constraint PK_CLOUD_FINISH_PROC_MEMBER primary key (ID)
)
;
alter table CLOUD_FINISH_PROC_MEMBER add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_HOUSE_TYPE                                      */
/*==============================================================*/
create table CLOUD_HOUSE_TYPE 
(
   ID                   char(19)                       not null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   HOUSE_TYPE_DESC      varchar(300)                   null,
   CLOUD_PROJECT_ID     char(19)                       null,
   HOUSE_TYPE_AREA      varchar(300)                   null,
   SORTING_SCHEME       varchar(300)                   null,
   constraint PK_CLOUD_HOUSE_TYPE primary key (ID)
)
;
alter table CLOUD_HOUSE_TYPE add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_HOUSE_TYPE_PROCESS_FEED                         */
/*==============================================================*/
create table CLOUD_HOUSE_TYPE_PROCESS_FEED 
(
   ID                   char(19)                       not null,
   CLOUD_PROCESS_QUANTITIES_ID char(19)                       null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_MATERIALS_BILL_ID char(19)                       null,
   MATERIAL_NAME        varchar(300)                   not null,
   NUM                  int                            null,
   COMPANY              varchar(300)                   null,
   MATERIAL_SOURCE      varchar(300)                   null,
   DELIVERY_METHOD      char(2)                        null,
   constraint PK_CLOUD_HOUSE_TYPE_PROCESS_FE primary key clustered (ID)
)
;
alter table CLOUD_HOUSE_TYPE_PROCESS_FEED add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_LABOR_SERVICE_COMPANY                           */
/*==============================================================*/
create table CLOUD_LABOR_SERVICE_COMPANY 
(
   ID                   char(19)                       not null,
   COMPANY_NAME         varchar(300)                   null,
   UNIFIED_CREDIT_CODE  VARCHAR(300)                   null,
   REGISTERED_ADDRESS   varchar(300)                   null,
   LEGAL_REPRESENTATIVE varchar(200)                   null,
   IS_AUTHORIZED_PERSON char(1)                        null,
   AUTHORIZED_NAME      varchar(200)                   null,
   AUTHORIZED_ID_NUMBER VARCHAR(18)                    null,
   AUTHORIZED_CERTIFICATE varchar(300)                   null,
   AUTHORIZED_PHONE     char(11)                       null,
   `DESCRIBE`             varchar(300)                   null,
   constraint PK_CLOUD_LABOR_SERVICE_COMPANY primary key (ID)
)
;
alter table CLOUD_LABOR_SERVICE_COMPANY add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_MATERIALS_BILL                                  */
/*==============================================================*/
create table CLOUD_MATERIALS_BILL 
(
   ID                   char(19)                       not null,
   PARENT_ID            char(19)                       null,
   MATERIAL_NAME        varchar(300)                   not null,
   IS_LAST_STAGE        char(1)                        null,
   COMPANY              varchar(300)                   null,
   IS_VALID             char(1)                        not null,
   MATERIAL_DESC        varchar(300)                   null,
   constraint PK_CLOUD_MATERIALS_BILL primary key clustered (ID)
)
;
alter table CLOUD_MATERIALS_BILL add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_MATERIAL_DISPATCH_TASK                          */
/*==============================================================*/
create table CLOUD_MATERIAL_DISPATCH_TASK 
(
   ID                   char(19)                       not null,
   DISPATCH_TEAM_LEADER_ID BIGINT                         null,
   DELIVERY_TIME        DATE                           null,
   DISPATCH_STATUS      char(2)                        null,
   REMARK               varchar(300)                   null,
   TRANSFER_TEAM_LEADER_ID BIGINT                         null,
   TRANSFER_TEAM_LEADER varchar(200)                   null,
   constraint PK_CLOUD_MATERIAL_DISPATCH_TAS primary key clustered (ID)
)
;
alter table CLOUD_MATERIAL_DISPATCH_TASK add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_MATERIAL_DISTRIBUTE_DTL                         */
/*==============================================================*/
create table CLOUD_MATERIAL_DISTRIBUTE_DTL 
(
   ID                   char(19)                       not null,
   CLOUD_DISPATCH_PROCEDURE_ID char(19)                       null,
   CLOUD_PROJECT_ROOM_ID char(19)                       null,
   ROOM_CODE            varchar(300)                   null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_MATERIALS_BILL_ID char(19)                       null,
   MATERIAL_NAME        varchar(300)                   not null,
   COMPANY              varchar(300)                   null,
   CLOUD_MATERIAL_DISPATCH_TASK_ID char(19)                       null,
   REMARK               varchar(300)                   null,
   DISPATCH_STATUS      char(2)                        null,
   ATTACHMENT           varchar(300)                   null,
   constraint PK_CLOUD_MATERIAL_DISTRIBUTE_D primary key clustered (ID)
)
;
alter table CLOUD_MATERIAL_DISTRIBUTE_DTL add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_MATERIAL_SENDER_INFO                            */
/*==============================================================*/
create table CLOUD_MATERIAL_SENDER_INFO 
(
   ID                   char(19)                       not null,
   CLOUD_MATERIAL_DISPATCH_TASK_ID char(19)                       null,
   SENDER_ID            BIGINT                         null,
   constraint PK_CLOUD_MATERIAL_SENDER_INFO primary key clustered (ID)
)
;
alter table CLOUD_MATERIAL_SENDER_INFO add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PHASE_PROJECT_RESOURCES                         */
/*==============================================================*/
create table CLOUD_PHASE_PROJECT_RESOURCES 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_PHASE_PLAN_ID char(19)                       null,
   PHASED_SCOPE_NAME    varchar(300)                   null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   CLOUD_WORK_TYPE_GROUP_CONF_ID char(19)                       null,
   GROUP_NAME           varchar(300)                   null,
   PLANNING_WORKING_GROUP_NAME varchar(300)                   null,
   TIME_START_TO_START  int                            null,
   END_DISTANCE_END_TIME int                            null,
   CLOUD_CLASS_GROUP_ID char(19)                       null,
   LABOR_TEAM_NAME      varchar(300)                   null,
   constraint PK_CLOUD_PHASE_PROJECT_RESOURC primary key (ID)
)
;
alter table CLOUD_PHASE_PROJECT_RESOURCES add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PRJ_LABOR_TEAM_GROUP                            */
/*==============================================================*/
create table CLOUD_PRJ_LABOR_TEAM_GROUP 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_LABOR_TEAM_ID char(19)                       null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   LABOR_SERVICE_COMPANY_NAME varchar(300)                   null,
   LABOR_TEAM_NAME      varchar(300)                   null,
   TEAM_NAME            varchar(300)                   null,
   TEAM_LEADER_ID       BIGINT                         null,
   TEAM_LEADER_NAME     varchar(200)                   null,
   TEAM_LEADER_PHONE    varchar(20)                    null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   STATUS               char(2)                        null,
   MATERIAL_PICKING_DELIVERY_METHOD char(2)                        null,
   TEAM_CONTRACT_STATUS char(2)                        null,
   IS_SMALL_WORK_TEAM   char(1)                        null,
   constraint PK_CLOUD_PRJ_LABOR_TEAM_GROUP primary key (ID)
)
;
alter table CLOUD_PRJ_LABOR_TEAM_GROUP add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PRJ_PLAN_ROOM_OPERATION                         */
/*==============================================================*/
create table CLOUD_PRJ_PLAN_ROOM_OPERATION 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_PLAN_SCOPE_ID char(19)                       not null,
   ROOM_CODE            varchar(300)                   null,
   CLOUD_PROJECT_ROOM_ID char(19)                       null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   PROCEDURE_NAME       varchar(300)                   null,
   QUANTITIES           varchar(300)                   null,
   MEASUREMENT_UNIT     varchar(300)                   null,
   PROCESS_SEQUENCE     varchar(300)                   null,
   GROUP_NAME           varchar(300)                   null,
   STANDARD_WORKING_HOURS decimal(4,2)                   null,
   STAUTS               char(2)                        null,
   TIME_START_TO_START  int                            null,
   END_DISTANCE_END_TIME int                            null,
   CLOUD_WORK_TYPE_GROUP_CONF_ID char(19)                       null,
   WORK_TYPE_GROUP_NAME varchar(300)                   null,
   AREA                 varchar(300)                   null,
   ACCEPTANCE_TYPE      char(2)                        null,
   PLANNING_TEAM_NAME   varchar(300)                   null,
   GROUP_SEQUENTIAL_WORK_NUMBER varchar(300)                   null,
   constraint PK_CLOUD_PRJ_PLAN_ROOM_OPERATI primary key (ID)
)
;
alter table CLOUD_PRJ_PLAN_ROOM_OPERATION add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROCESS_QUANTITIES                              */
/*==============================================================*/
create table CLOUD_PROCESS_QUANTITIES 
(
   ID                   char(19)                       not null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   CLOUD_WORK_TYPE_GROUP_CONF_ID char(19)                       null,
   GROUP_NAME           varchar(300)                   null,
   WORK_TYPE_NAME       varchar(300)                   null,
   PROCEDURE_NAME       varchar(300)                   null,
   QUANTITIES           varchar(300)                   null,
   MEASUREMENT_UNIT     varchar(300)                   null,
   STANDARD_MAN_HOUR    decimal(4,2)                   null,
   `DESCRIBE`             varchar(300)                   null,
   PROCESS_SEQUENCE     varchar(300)                   null,
   STANDARD_WORKING_HOURS decimal(4,2)                   null,
   EXTENSION_COMPLETION_TIME decimal(4,2)                   null,
   ACCEPTANCE_TYPE      char(2)                        null,
   SERIAL_NUMBER_CODE   varchar(300)                   null,
   constraint PK_CLOUD_PROCESS_QUANTITIES primary key (ID)
)
;
alter table CLOUD_PROCESS_QUANTITIES add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROC_START_TIME_REQ                             */
/*==============================================================*/
create table CLOUD_PROC_START_TIME_REQ 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_PHASE_PLAN_ID char(19)                       null,
   CLOUD_DECORATION_PROCESS_ID char(19)                       null,
   PROCEDURE_NAME       varchar(300)                   null,
   DELAY_TIME_PROCESS_COMMENCEMEN int                            null,
   `DESCRIBE`             varchar(300)                   null,
   constraint PK_CLOUD_PROC_START_TIME_REQ primary key (ID)
)
;
alter table CLOUD_PROC_START_TIME_REQ add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROC_START_TIME_REQ2                            */
/*==============================================================*/
create table CLOUD_PROC_START_TIME_REQ2 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_PHASE_PLAN_ID char(19)                       null,
   CLOUD_DECORATION_PROCESS_ID char(19)                       null,
   PROCEDURE_NAME       varchar(300)                   null,
   DELAY_TIME_PROCESS_COMMENCEMEN int                            null,
   `DESCRIBE`             varchar(300)                   null,
   constraint PK_CLOUD_PROC_START_TIME_REQ2 primary key (ID)
)
;
alter table CLOUD_PROC_START_TIME_REQ2 add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT                                         */
/*==============================================================*/
create table CLOUD_PROJECT 
(
   ID                   char(19)                       not null,
   NAME                 VARCHAR(100)                   null,
   PROVINCE             varchar(300)                   null,
   CITY                 varchar(300)                   null,
   COUNTY               varchar(300)                   null,
   PROVINCE_ID          VARCHAR(32)                    null,
   CITY_ID              VARCHAR(32)                    null,
   COUNTY_ID            VARCHAR(32)                    null,
   ADDRESS              varchar(300)                   null,
   PROJECT_TYPE         char(1)                        null,
   CONTRACT_SOURCE      varchar(300)                   null,
   CAPITAL_SOURCE       varchar(300)                   null,
   PERMIT_NUMBER        varchar(300)                   null,
   PROJECT_RECORD_NUM   varchar(300)                   null,
   NUM                  varchar(300)                   null,
   DEPOSIT              decimal(12,2)                  null,
   STATUS               char(1)                        null,
   COMPANY_ID           char(19)                       null,
   PROGRESS_STATUS      char(1)                        null,
   X_COORDINATE         DECIMAL(9,6)                   null,
   Y_COORDINATE         DECIMAL(9,6)                   null,
   COMPANY_NAME         varchar(300)                   null,
   DEVICE_SERIAL_NUMBER varchar(300)                   null,
   IS_SBJW              char(1)                        null,
   PROJECT_CODE         varchar(300)                   not null,
   BEGIN_DATE           DATE                           not null,
   END_DATE             DATE                           not null,
   SIGN_DATE            DATE                           not null,
   QNPC                 varchar(300)                   null,
   BANK                 varchar(300)                   null,
   BANK_CODE            varchar(300)                   null,
   BANK_CONTACTS        varchar(200)                   null,
   BANK_CONTACTS_TEL    varchar(20)                    null,
   BANK_CODE_MSG        varchar(40)                    null,
   BANK_NAME            varchar(50)                    null,
   PLANNED_WORKING_HOURS varchar(300)                   null,
   BILLING_INFO         varchar(300)                   null,
   IS_OPEN_FENCE        char(1)                        null,
   constraint PK_CLOUD_PROJECT primary key (ID)
)
;
alter table CLOUD_PROJECT add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_BUILDING                                */
/*==============================================================*/
create table CLOUD_PROJECT_BUILDING 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   BUILDING_NO          varchar(300)                   null,
   REMARK               varchar(300)                   null,
   STATUS               char(2)                        null,
   constraint PK_CLOUD_PROJECT_BUILDING primary key (ID)
)
;
alter table CLOUD_PROJECT_BUILDING add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_LABOR_COMPANY                           */
/*==============================================================*/
create table CLOUD_PROJECT_LABOR_COMPANY 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   LABOR_SERVICE_COMPANY_NAME varchar(300)                   null,
   PROJECT_AUTHORIZER_NAME varchar(200)                   null,
   PROJECT_AUTHORIZER_TEL char(11)                       null,
   PROJECT_AUTHORIZER_ID VARCHAR(18)                    null,
   AUTHORIZER_CERTIFICATE varchar(300)                   null,
   STATUS               char(2)                        null,
   PROJECT_CODE         VARCHAR(255)                   null,
   `DESCRIBE`             varchar(300)                   null,
   constraint PK_CLOUD_PROJECT_LABOR_COMPANY primary key (ID)
)
;
alter table CLOUD_PROJECT_LABOR_COMPANY add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_LABOR_TEAM                              */
/*==============================================================*/
create table CLOUD_PROJECT_LABOR_TEAM 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_LABOR_COMPANY_ID char(19)                       null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   LABOR_SERVICE_COMPANY_NAME varchar(300)                   null,
   LABOR_TEAM_NAME      varchar(300)                   null,
   LABOR_TEAM_AUTH_PERSON varchar(200)                   null,
   LABOR_TEAM_AUTH_PERSON_TEL varchar(20)                    null,
   `DESCRIBE`             varchar(300)                   null,
   STATUS               char(2)                        null,
   LABOR_SUBCONTRACT_AMOUNT decimal(12,2)                  null,
   constraint PK_CLOUD_PROJECT_LABOR_TEAM primary key (ID)
)
;
alter table CLOUD_PROJECT_LABOR_TEAM add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_PERSON                                  */
/*==============================================================*/
create table CLOUD_PROJECT_PERSON 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   PROJECT_ROLE_TYPE    char(2)                        null,
   PERSON_ID            char(19)                       null,
   constraint PK_CLOUD_PROJECT_PERSON primary key (ID)
)
;
alter table CLOUD_PROJECT_PERSON add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_PHASE_PLAN                              */
/*==============================================================*/
create table CLOUD_PROJECT_PHASE_PLAN 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_PLAN_ID char(19)                       null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   COMPANY_NAME         varchar(300)                   null,
   SUBCONTRACTOR_PRINCIPAL varchar(200)                   null,
   PHASED_SCOPE_NAME    varchar(300)                   null,
   REASONS_PHASE_DIVISION varchar(300)                   null,
   LEAD_TIME            int                            null,
   PROJECT_CYCLE        int                            null,
   RESERVED_TIME        int                            null,
   ACTUAL_PROJECT_EXECUTION_TIME DATE                           null,
   TOTAL_NUMBER_ROOM    int                            null,
   PLANNING_METHOD      char(2)                        null,
   constraint PK_CLOUD_PROJECT_PHASE_PLAN primary key (ID)
)
;
alter table CLOUD_PROJECT_PHASE_PLAN add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_PLAN                                    */
/*==============================================================*/
create table CLOUD_PROJECT_PLAN 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   PROJECT_PLAN_VERSION varchar(300)                   null,
   VERSION_STATUS       char(2)                        null,
   VERSION              varchar(300)                   null,
   VERSIION_DESC        varchar(300)                   null,
   WHOLE_PLANNED_TIME   varchar(300)                   null,
   constraint PK_CLOUD_PROJECT_PLAN primary key (ID)
)
;
alter table CLOUD_PROJECT_PLAN add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_PLAN_SCOPE                              */
/*==============================================================*/
create table CLOUD_PROJECT_PLAN_SCOPE 
(
   ID                   char(19)                       not null,
   CLO_ID               char(19)                       null,
   CLOUD_PROJECT_BUILDING_ID char(19)                       null,
   BUILDING_NO          varchar(300)                   null,
   CLOUD_PROJECT_UNIT_ID char(19)                       null,
   UNIT_CODE            varchar(300)                   null,
   ROOM_CODE            varchar(300)                   null,
   LAYER_NUM            int                            null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   CLOUD_PROJECT_ID     char(19)                       null,
   IS_VALID             char(1)                        null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   ROOM_NAME            varchar(300)                   null,
   TASK_FINISH_STATUS   char(2)                        null,
   constraint PK_CLOUD_PROJECT_PLAN_SCOPE primary key (ID)
)
;
alter table CLOUD_PROJECT_PLAN_SCOPE add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_ROOM                                    */
/*==============================================================*/
create table CLOUD_PROJECT_ROOM 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_BUILDING_ID char(19)                       null,
   BUILDING_NO          varchar(300)                   null,
   CLOUD_PROJECT_UNIT_ID char(19)                       null,
   UNIT_CODE            varchar(300)                   null,
   ROOM_CODE            varchar(300)                   null,
   LAYER_NUM            int                            null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   CLOUD_PROJECT_ID     char(19)                       null,
   IS_VALID             char(1)                        null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   ROOM_NAME            varchar(300)                   null,
   TASK_FINISH_STATUS   char(2)                        null,
   constraint PK_CLOUD_PROJECT_ROOM primary key (ID)
)
;
alter table CLOUD_PROJECT_ROOM add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_TEAM_PERSONNEL                          */
/*==============================================================*/
create table CLOUD_PROJECT_TEAM_PERSONNEL 
(
   ID                   char(19)                       not null,
   CLOUD_PRJ_LABOR_TEAM_GROUP_ID char(19)                       null,
   CLOUD_CLASS_GROUP_ID char(19)                       null,
   NAME                 varchar(200)                   null,
   WORK_TYPE_NAME       varchar(300)                   null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   PHONE                char(11)                       null,
   IS_REPRESENTS        char(1)                        null,
   STATUS               char(2)                        null,
   MEMBER_CODE          varchar(300)                   null,
   ARRIVAL_SIGN         char(2)                        null,
   constraint PK_CLOUD_PROJECT_TEAM_PERSONNE primary key (ID)
)
;
alter table CLOUD_PROJECT_TEAM_PERSONNEL add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_PROJECT_UNIT                                    */
/*==============================================================*/
create table CLOUD_PROJECT_UNIT 
(
   ID                   char(19)                       not null,
   CLOUD_PROJECT_ID     char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   CLOUD_PROJECT_BUILDING_ID char(19)                       null,
   BUILDING_NO          varchar(300)                   null,
   UNIT_CODE            varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   IS_VALID             char(1)                        null,
   COMMENCEMENT_BATCH_NO varchar(300)                   null,
   COMMENCEMENT_SEQUENCE int                            null,
   IS_START             char(1)                        null,
   constraint PK_CLOUD_PROJECT_UNIT primary key (ID)
)
;
alter table CLOUD_PROJECT_UNIT add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_ROOM_MATERIALS                                  */
/*==============================================================*/
create table CLOUD_ROOM_MATERIALS 
(
   ID                   char(19)                       not null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_MATERIALS_BILL_ID char(19)                       null,
   MATERIALS_BILL_NUM   int                            null,
   COMPANY              varchar(300)                   null,
   SUPPLY_MODE          char(2)                        null,
   DISPATCH_STATUS      char(2)                        null,
   DISPATCH_TEAM_LEADER_ID BIGINT                         null,
   MANUFACTURER_DESC    varchar(300)                   null,
   STATUS               char(2)                        null,
   `DESC`               varchar(300)                   null,
   constraint PK_CLOUD_ROOM_MATERIALS primary key clustered (ID)
)
;
alter table CLOUD_ROOM_MATERIALS add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_ROOM_PROCEDURE                                  */
/*==============================================================*/
create table CLOUD_ROOM_PROCEDURE 
(
   ID                   char(19)                       not null,
   ROOM_CODE            varchar(300)                   null,
   CLOUD_PROJECT_ROOM_ID char(19)                       null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   PROCEDURE_NAME       varchar(300)                   null,
   QUANTITIES           varchar(300)                   null,
   MEASUREMENT_UNIT     varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   PROCESS_SEQUENCE     varchar(300)                   null,
   GROUP_NAME           varchar(300)                   null,
   STANDARD_WORKING_HOURS decimal(4,2)                   null,
   STATUS               char(2)                        null,
   FINISH_TIME          DATE                           null,
   CLOUD_LABOR_SERVICE_COMPANY_ID char(19)                       null,
   CLOUD_PROJECT_LABOR_TEAM_ID char(19)                       null,
   LABOR_TEAM_NAME      varchar(300)                   null,
   CLOUD_PRJ_LABOR_TEAM_GROUP_ID char(19)                       null,
   CLOUD_CLASS_GROUP_ID char(19)                       null,
   LEADER_NAME          varchar(200)                   null,
   UNIT_PRICE           decimal(12,2)                  null,
   AMOUNT_MONEY         decimal(12,2)                  null,
   AREA                 varchar(300)                   null,
   ACCEPTANCE_TYPE      char(2)                        null,
   constraint PK_CLOUD_ROOM_PROCEDURE primary key (ID)
)
;
alter table CLOUD_ROOM_PROCEDURE add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_SENDER                                          */
/*==============================================================*/
create table CLOUD_SENDER 
(
   ID                   char(19)                       not null,
   CLOUD_ROOM_MATERIALS_ID char(19)                       null,
   SENDER_ID            BIGINT                         null,
   SENDER               varchar(200)                   null,
   constraint PK_CLOUD_SENDER primary key clustered (ID)
)
;
alter table CLOUD_SENDER add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_SUB_APPROVAL_INFO                               */
/*==============================================================*/
create table CLOUD_SUB_APPROVAL_INFO 
(
   ID                   char(19)                       not null,
   CLOUD_PRJ_LABOR_TEAM_GROUP_ID char(19)                       null,
   APPROVER_ID          BIGINT                         null,
   APPROVER             varchar(200)                   null,
   APPROVAL_OPINIONS    varchar(300)                   null,
   IS_AGREE             char(1)                        null,
   constraint PK_CLOUD_SUB_APPROVAL_INFO primary key (ID)
)
;
alter table CLOUD_SUB_APPROVAL_INFO add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_TASK_DISPATCH                                   */
/*==============================================================*/
create table CLOUD_TASK_DISPATCH 
(
   ID                   char(19)                       not null,
   TASK_DISPATCH_NAME   varchar(300)                   null,
   STARTUP_CONDITIONS_IS_MET char(1)                        null,
   STATUS               char(2)                        null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   `DESCRIBE`             varchar(300)                   null,
   QUANTITIES           varchar(300)                   null,
   CLOUD_CLASS_GROUP_ID char(19)                       null,
   CLOUD_CLASS_GROUP_NAME varchar(300)                   null,
   NUMBER_PEOPLE        int                            null,
   DISPATCH_TIME        DATE                           null,
   ESTIMATED_FINISH_TIME DATE                           null,
   RECEIVING_TIME       DATE                           null,
   FINISH_TIME          DATE                           null,
   UNIT_PRICE           decimal(12,2)                  null,
   AMOUNT_MONEY         decimal(12,2)                  null,
   constraint PK_CLOUD_TASK_DISPATCH primary key (ID)
)
;
alter table CLOUD_TASK_DISPATCH add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_TASK_DISPATCHER                                 */
/*==============================================================*/
create table CLOUD_TASK_DISPATCHER 
(
   ID                   char(19)                       not null,
   CLOUD_TASK_DISPATCH_ID char(19)                       null,
   CLOUD_TASK_DISPATCHER_ID char(19)                       null,
   TASK_DISPATCHER_NAME varchar(200)                   null,
   constraint PK_CLOUD_TASK_DISPATCHER primary key (ID)
)
;
alter table CLOUD_TASK_DISPATCHER add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_TASK_DISPATCH_DETAIL                            */
/*==============================================================*/
create table CLOUD_TASK_DISPATCH_DETAIL 
(
   ID                   char(19)                       not null,
   CLOUD_TASK_DISPATCH_ID char(19)                       null,
   CLOUD_PROJECT_ID     char(19)                       null,
   CLOUD_PROJECT_ROOM_ID char(19)                       null,
   PROJECT_NAME         varchar(300)                   null,
   BUILDING_NO          varchar(300)                   null,
   UNIT_CODE            varchar(300)                   null,
   ROOM_CODE            varchar(300)                   null,
   CLOUD_HOUSE_TYPE_ID  char(19)                       null,
   HOUSE_TYPE_NAME      varchar(300)                   null,
   ROOM_NAME            varchar(300)                   null,
   IS_MODEL_ROOM        char(1)                        null,
   ATTACHMENT           varchar(300)                   null,
   constraint PK_CLOUD_TASK_DISPATCH_DETAIL primary key (ID)
)
;
alter table CLOUD_TASK_DISPATCH_DETAIL add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_TEAM_SUB_PRICE                                  */
/*==============================================================*/
create table CLOUD_TEAM_SUB_PRICE 
(
   ID                   char(19)                       not null,
   CLOUD_PRJ_LABOR_TEAM_GROUP_ID char(19)                       null,
   TEAM_NAME            varchar(300)                   null,
   CLOUD_ROOM_PROCEDURE_ID char(19)                       null,
   PROCEDURE_NAME       varchar(300)                   null,
   GROUP_NUMBER         varchar(300)                   null,
   FIXED_PRICE          decimal(12,2)                  null,
   MEASUREMENT_UNIT     varchar(300)                   null,
   UNIT_PRICE           decimal(12,2)                  null,
   constraint PK_CLOUD_TEAM_SUB_PRICE primary key (ID)
)
;
alter table CLOUD_TEAM_SUB_PRICE add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_WORKER_REGISTRATION                             */
/*==============================================================*/
create table CLOUD_WORKER_REGISTRATION 
(
   ID                   char(19)                       not null,
   NAME                 varchar(200)                   null,
   ID_NUMBER            VARCHAR(18)                    null,
   NATIVE_PLACE         varchar(300)                   null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   WORK_TYPE_NAME       varchar(300)                   null,
   EDUCATION            char(2)                        null,
   FRONT_ID_CARD        varchar(300)                   null,
   BACK_ID_CARD         varchar(300)                   null,
   constraint PK_CLOUD_WORKER_REGISTRATION primary key (ID)
)
;
alter table CLOUD_WORKER_REGISTRATION add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_WORK_TYPE_CONF                                  */
/*==============================================================*/
create table CLOUD_WORK_TYPE_CONF 
(
   ID                   char(19)                       not null,
   WORK_TYPE_NAME       varchar(300)                   null,
   REMARK               varchar(300)                   null,
   constraint PK_CLOUD_WORK_TYPE_CONF primary key (ID)
)
;
alter table CLOUD_WORK_TYPE_CONF add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

/*==============================================================*/
/* Table: CLOUD_WORK_TYPE_GROUP_CONF                            */
/*==============================================================*/
create table CLOUD_WORK_TYPE_GROUP_CONF 
(
   ID                   char(19)                       not null,
   CLOUD_WORK_TYPE_CONF_ID char(19)                       null,
   GROUP_NAME           varchar(300)                   null,
   REMARK               varchar(300)                   null,
   NAME_CODE            varchar(300)                   null,
   constraint PK_CLOUD_WORK_TYPE_GROUP_CONF primary key (ID)
)
;
alter table CLOUD_WORK_TYPE_GROUP_CONF add(
  `created_by` bigint DEFAULT NULL COMMENT '创建人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint DEFAULT NULL COMMENT '更新人id',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间'
);

