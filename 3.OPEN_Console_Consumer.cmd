@echo off

@ECHO *********************************************
@ECHO Abrimos la consola para consumir los mensajes
@ECHO *********************************************

start /D "C:\CANITANO\Desarrollo\Brokers\kafka" cmd /k ".\bin\windows\kafka-console-consumer.bat --topic amigosms --from-beginning --bootstrap-server localhost:9092"


@echo pause