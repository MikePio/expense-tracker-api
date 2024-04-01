# REST API Expense tracker - Monitoraggio spese

Creazione un'API REST per il monitoraggio spese utilizzando Spring Boot in cui verrà utilizzato PostgreSQL come database relazionale e Spring JdbcTemplate per interagire con esso. Inoltre, verrà aggiunta l'autenticazione tramite JWT (JSON Web Tokens).

Ispirato da https://www.youtube.com/watch?v=0-nCSvAkxqI&list=PLWieu6NbbqTwwYwylgXmmKVX1ZWsUVx8m&index=3
Time: 2h 11min

# STEPS

Creare la cartella per il progetto all'interno della wls:

apri esplora risorse > linux (in basso a sinistra) cioè \\wsl.localhost\ > Ubuntu-20.04\home\michele > (FACOLTATIVO Crea la cartella) Projects > nome_del_progetto

---

apri vs code e collegalo ad ubuntu cliccando nell'angolo in basso a sinistra > Connetti a WLS

--- 

inserisci i comandi:

```
sudo docker container run --name postgresdb -e POSTGRES_PASSWORD=****** -d -p 5432:5432 postgres
```
```
sudo docker container ls
```

oppure se il container è già stato creato 

```
sudo docker container start nome_del_container
```
```
sudo docker container ls
```

---

# Creazione del database

#### Video 2 - Project Setup & Creating Database Objects

Dopo aver creato il file `expensetracker_db.sql` ed averlo compilato con tutti i dati delle tabelle e le diverse relzioni tra tabelle, eseguire nel terminale i seguenti comandi:

per copiare il file sulla root

```
sudo docker cp /home/michele/Projects/expense-tracker-api/expensetracker_db.sql postgresdb:/
```

eseguo i comandi Postgre contenuti nel file:

"entro" nel container postgresdb:
```
sudo docker container exec -it postgresdb bash
```
verifico se è presente il file del db:
```
ls
```
Con il prossimo comando vengono create tutte le tabelle e le loro relazioni sul db
```
psql -U postgres --file expensetracker_db.sql
```
"esco" dal container postgresdb per tornare sul terminale del progetto:
```
exit
```

---

Aprire il file application.properties e compilarlo aggiungendo:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/expensetrackerdb
spring.datasource.username=expensetracker
spring.datasource.password=password
```

aprire il browser, cercare localhost:8080 e dovrebbe apparire la pagina di errore di spring boot con scritto "Whitelabel Error Page", ciò fa capire che spring boot sta funzionando.

---

Creare un nuovo package all'interno di `src/main/java/com/java/expensetrackerapi` e chiamarlo `controller`.

All'interno del package controller, creare un file java per inserire il controller REST degli utenti `UsersController.java`.

In `UsersController.java`, creare un metodo POST per la registrazione.

Testare il medoto POST con thunderclient o postman inserendo e compilando il body della richiesta con i campi inseriti nel metodo (POST) della registrazione nell'UserController:

in questo caso ad esempio:
{
  "firstName": "David",
  "lastName": "Smith",
  "email": "david@testemail.com",
  "password": "123"
} 

inviando i dati nel body in POST si dovrebbe ottenere in output: David, Smith, david@testemail.com, 123

# CONTINUA DA QUI

#### Video 3 - Persisting User Information on Register


#### Video 4 - Login and Hashing Password
#### Video 5 - JWT Authentication
#### Video 6 - Adding New Categories
#### Video 7 - Category - Find & Update Functionality
#### Video 8 - Adding Category Transactions
#### Video 9 - Transaction - Find and Update
#### Video 10 - Deleting - Category & Transactions
#### Video 11 - CORS & Testing from Web Client
#### Video 12 - Summary and Code !


































































