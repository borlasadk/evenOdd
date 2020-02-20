@echo off
rem   NAME
rem   DESCRIPTION
rem     Build report of DBs Difference
rem   PARAMETERS
rem     %1 - tns name of new DB
rem     %2 - pmc_system schema password
rem   NOTES
rem     New DB should contain DB link "STR_DB" to old DB.
rem   MODIFIED (DD/MM/YY)
rem     V.Prynts      13/02/15 - Created
rem
set _TNS_NAME=%1
set _PASSW=%2
set _SCHEMA=pmc_system

if not defined _TNS_NAME set _TNS_NAME=CTCTST
if not defined _PASSW set _PASSW=******

echo select pmc_system.pmc_common.get_version from dual; |sqlplus -silent %_SCHEMA%/%_PASSW%@%_TNS_NAME% |find ".">version.properties

if  not exist version.properties (
    echo FAIL: Fail version.properties not exist!>error.log
    exit
)


for /F "usebackq tokens=* delims=" %%i In ("version.properties") do set _CTC_DB_VERSION=%%i_difference

echo on
sqlplus %_SCHEMA%/%_PASSW%@%_TNS_NAME% @difference_db.sql


