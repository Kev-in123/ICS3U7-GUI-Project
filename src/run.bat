@echo off
cd /d "%~dp0"
echo compiling files...
for /r %%a in (*.java) do javac "%%a"
echo compiled all files
echo running main program...
java Main/Main
pause
