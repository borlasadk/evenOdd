SET linesize 200;
SET PAGESIZE 50000;
SET HEADING OFF;
COLUMN changes format a30;
COLUMN objects format a30;
COLUMN table_name format a40;
COLUMN view_name format a40;
COLUMN column_name format a40;
COLUMN data_type format a20;
COLUMN data_length format a20;
COLUMN nullable format a10;
COLUMN rowadd format a10;

set termout off;
spool on;
spool %_CTC_DB_VERSION%.txt;
select 'List of Database Changes.' from dual;

select 'Old DB: '||pmc_common.get_version@str_db Old_DB,
       'New DB: '||pmc_common.get_version New_DB
  from dual;

select '==== Added tables ====' from dual;

select table_name
  from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%'
minus
select table_name as table_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name not like 'V%';

SET HEADING ON;
select table_name,
        column_name,
        data_type,
        to_char(data_length) as data_length,
        to_char(nullable) as nullable
  from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%'
   and table_name  in
       (select to_char(table_name)
          from user_tab_columns
         where table_name not like '%$%'
           and table_name not like 'V%'
        minus
        select table_name
          from user_tab_columns@STR_DB
         where table_name not like '%$%'
           and table_name not like 'V%')
minus
select table_name,
       column_name,
       data_type,
       to_char(data_length) as data_length,
       to_char(nullable) as nullable
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name not like 'V%';


SET HEADING OFF;

select '==== Deleted tables ====' from dual;

select 'table' as object_type,
       table_name as object_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name not like 'V%'
minus
select 'table' as object_type,
        table_name as object_name
     from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%';

select '==== Modifyed tables ====' from dual;

select 'Added columns:' from dual;


select 'table' as objects,
       table_name as table_name ,
       column_name as column_name
        from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%'
   and table_name not in
       (select to_char(table_name)
          from user_tab_columns
         where table_name not like '%$%'
           and table_name not like 'V%'
        minus
        select table_name
          from user_tab_columns@STR_DB
         where table_name not like '%$%'
           and table_name not like 'V%')
minus
select 'table' as objects,
       table_name as table_name,
       column_name as column_name
        from user_tab_columns@STR_DB
 where table_name not like '%$%'
 and table_name not like 'V%';

select 'Deleted columns:' from dual;


select 'table' as object_type,
       table_name as object_name,
       column_name as column_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name not like 'V%'
   and table_name not in (select table_name as object_name
                            from user_tab_columns@STR_DB
                            where table_name not like '%$%'
                            and table_name not like 'V%'
                            minus
                           select table_name as object_name
                            from user_tab_columns
                            where table_name not like '%$%'
                            and table_name not like 'V%')
minus
select 'table' as object_type,
       table_name as object_name,
       column_name as column_name
    from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%';


select 'Added/Modifyed columns:' from dual;

SET HEADING ON;

select 'table' as objects,
       table_name ,
       column_name,
       data_type,
       to_char(data_length) as data_length,
       to_char(nullable) as nullable
       from user_tab_columns
 where table_name not like '%$%'
   and table_name not like 'V%'
   and table_name not in
       (select to_char(table_name)
          from user_tab_columns
         where table_name not like '%$%'
           and table_name not like 'V%'
        minus
        select table_name
          from user_tab_columns@STR_DB
         where table_name not like '%$%'
           and table_name not like 'V%')
minus
select 'table' as objects,
       table_name as table_name,
       column_name as column_name,
       data_type,
       to_char(data_length) as data_length,
       to_char(nullable) as nullable
       from user_tab_columns@STR_DB
 where table_name not like '%$%'
 and table_name not like 'V%';



SET HEADING OFF;


select '==== Added views ====' from dual;

select table_name as view_name
  from user_tab_columns
 where table_name not like '%$%'
   and table_name like 'V%'
minus
select table_name as  view_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name like 'V%';


select '==== Deleted views ====' from dual;

select table_name as  view_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name like 'V%'
minus
select to_char(table_name) as view_name
  from user_tab_columns
 where table_name not like '%$%'
   and table_name like 'V%';



select '==== Modifyed views ====' from dual;

select 'Added columns:' from dual;

SET HEADING ON;

select 'view' as objects,
       table_name,
       column_name
  from user_tab_columns
 where table_name not like '%$%'
   and table_name like 'V%'
   and table_name not in (select to_char(table_name)
                            from user_tab_columns
                           where table_name not like '%$%'
                             and table_name like 'V%'
                          minus
                          select table_name
                            from user_tab_columns@STR_DB
                           where table_name not like '%$%'
                             and table_name like 'V%')
minus
select 'view' as objects,
       table_name,
       column_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name like 'V%';

SET HEADING OFF;

select 'Deleted columns:' from dual;

SET HEADING ON;

select 'view' as objects,
       table_name,
       column_name
  from user_tab_columns@STR_DB
 where table_name not like '%$%'
   and table_name like 'V%'
   and table_name not in (select table_name as  view_name
                              from user_tab_columns@STR_DB
                            where table_name not like '%$%'
                            and table_name like 'V%'
                          minus
                          select table_name as view_name
                              from user_tab_columns
                            where table_name not like '%$%'
                            and table_name like 'V%')
minus
select 'view' as objects,
        table_name,
        column_name
  from user_tab_columns
 where table_name not like '%$%'
   and table_name like 'V%'
   and table_name not in (select table_name
                            from user_tab_columns
                           where table_name not like '%$%'
                             and table_name like 'V%'
                          minus
                          select table_name
                            from user_tab_columns@STR_DB
                           where table_name not like '%$%'
                             and table_name like 'V%');



SET HEADING OFF;

select '==== Finish ====' from dual;

spool off;
exit;
