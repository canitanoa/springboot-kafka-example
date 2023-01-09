## Proyecto de ejemplo para implementar Kafka con Spring-Boot


```bash
1- Crear repositorio en GitHub en: https://github.com/canitanoa/
2- git init 
3- git add . 
4- git commit -m "Crear proyecto springboot-kafka-example" 
5- git remote add origin https://github.com/canitanoa/springboot-kafka-example.git 
6- git push -u origin master 
```



### Intalacion del Broker y Servicio Kafka:

### Imple:
1. Descragar Apache Kafka
```txt
URL: https://kafka.apache.org/quickstart

    PASO 1: OBTENER KAFKA
        Descargue la última versión de Kafka y extráigala:
        https://www.apache.org/dyn/closer.cgi?path=/kafka/3.3.1/kafka_2.13-3.3.1.tgz
        
        Descomprimir:
        $ tar -xzf kafka_2.13-3.3.1.tgz
        
		Renombrar la carpeta:
		kafka_2.13-3.3.1 por kafka
		
        Acceder a la carpeta:
        $ cd kafka
	
	OPCION 1:
		Ejecutar los server por .CMDs:
		
		1_RUN_Zookeeper.cmd
		2_RUN_Kafka_broker.cmd
    
	OPCION 2:
		INICIE EL ENTORNO DE KAFKA
        NOTA: Su entorno local debe tener instalado Java 8+.
        Apache Kafka se puede iniciar con ZooKeeper o KRaft. Para comenzar con cualquiera de las configuraciones, siga una de las secciones a continuación, pero no ambas.
        
        Kafka con ZooKeeper
        Ejecute los siguientes comandos para iniciar todos los servicios en el orden correcto:
        
        # Debe estar parado dentro de la carpeta donde descomprimio los archivos de kafka:
        $ cd "C:\CANITANO\Desarrollo\Brokers\kafka"

        # Start the ZooKeeper service
        $ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
        
        Abra otra sesión de terminal y ejecute:
        # Start the Kafka broker service
        $ .\bin\windows\kafka-server-start.bat .\config\server.properties
		
	
        
    Una vez que todos los servicios se hayan iniciado correctamente, tendrá un entorno Kafka básico ejecutándose y listo para usar.
```

### Arquitectura:

*Componenetes:*

- Producer: Genera el mensaje
- Topic: Es la colección de eventos donde se alojará el mensaje
- Consumer: Lee el mensaje del Topico


![alt text](https://github.com/canitanoa/springboot-kafka-example/blob/master/imgs/Topic.png?raw=true)

### Configuración del proyecto:

- Se crea la configuración para el *Tipico*: 
  - KafkaTopicConfig.java
	- Definimos el nombre del Topico
- Se crea la configuración para el *Producer*: 
  - KafkaProducerConfig.java
	- Definimos el server configurado en las properties
	- Definimos la configuracion para pasar al Producer Factory
	- Definimos el Producer Factory, que es el responsable de creal la instancia del Producer
	- Definimos la forma en que vamos a enviar los mensajes con el KafkaTemplate
- Se crea el *Consumer*:
  - KafkaConsumerConfig.java
    - asas
- Se crea la configuración para el *Listener* (para consumir los mensajes de los topicos de Kafka)
  - kaConsumerConfig.java
    - Definimos el server configurado en las properties
    - Definimos la configuracion para pasar al Consumer Factory
    - Definimos el Consumer Factory
    - Definimos el Listener que va a sondear todos los registros de Kafka
- Se crea el *Producer*:
  - KafkaExampleApplication.java
    - Dodne por medio de CommandLineRunner se envian los mensajes al topico
- Se crea el *Producer*:
  - KafkaListeners.java
    - Dodne por medio del Listener se consumen los mensajes

### Prueba: 
```txt
1.Clean_Package.cmd
2.RUN_App.cmd
3.OPEN_Console_Consumer.cmd
4.Ejecutar el POST de /messages en "kafka-example.postman_collection.json"


1. Producir el mensaje:

	- KafkaExampleApplication.java:
		Dentro se encuentra un CommandLineRunner que envia un mansaje 
		al topico 'amigosms' por medio del template 'kafkaTemplate'
	
		Para probarlo ejecutar la clase  KafkaExampleApplication.java
	
2. Consumir el mensaje: 
	- kafka-console-consumer.bat
		En los paquetes de intalacion de kafka se encuentra el .bat para 
		leer los mensaje del topico (esto simula al consumer)
		
		Para probarlo ejecutar (desde el raiz donde se intalo kafka): 
		.\bin\windows\kafka-console-consumer.bat --topic amigosms --from-beginning --bootstrap-server localhost:9092
```
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  