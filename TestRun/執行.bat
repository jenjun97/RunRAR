@ECHO off
REM -----------------------------------------------

REM 取得當前目錄
SET dir=%~dp0
ECHO %dir%

REM 預存舊classpath資訊
SET OLDCP=%CLASSPATH%

REM set路徑
SET bin=%dir%\bin
SET lib=%dir%\lib

REM set參數
SET JAVA_HOME=%dir%\jdk17.0.7_7
SET CLASSPATH=.;%bin%;

REM set path
SET path=.;%JAVA_HOME%\bin;%PATH%
ECHO path=%path%

REM 執行程式
java com.Demo

REM 還原舊classpath資訊
SET CLASSPATH=%OLDCP%

REM **結束**-----------------------------------------------
pause
@ECHO on
