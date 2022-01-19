@echo off
cd /d "%~dp0"
echo compiling files...
for /r %%a in (*.java) do javac "%%a"
echo compiled all files
echo running main program...
java Main/Main
echo finished running main program
echo deleting all class files
for /r %%a in (*.class) do del "%%a"
echo done
pause
