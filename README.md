# grpc-sample
A sample project in Java to use gRPC for simulating a Wallet control.  

The Wallet has the operations below:  
* Deposit - makes a deposit into the wallet
* Withdraw - makes a withdraw from the wallet
* Balance - get the balance of the user's wallets

A user can make deposits and withdraws with the currencies contained in the database.  
For this project, the following currencies will be inserted into database:
1. EUR - Euro
2. USD - US Dollar
3. GBP - Britsh Pound Sterling

Techonologies used
-----
* Java 8
* gRPC
* MySQL 5.7
* Gradle 4.4
* Hibernate 5.3

### Instructions

#### Data base schemas
The schemas of database are in the following folder:

src/main/resources/scripts-db

To apply them, run on the following order:

1. create-db.sh
2. create-tables.sql
3. pre-inserts.sql

Before you build the project, remember to setup the **hibernate.cfg.xml** to your own database info. The **hibernate.cfg.xml** is in the folder _src/main/resources_.

#### Build
To build the project, use the following command:

./gradlew build  
./gradlew installDist

#### Run Server
Run the server with the following command:  
./build/install/grpc-sample/bin/wallet-server

#### Client Instructions
To run the client, you need to follow these instructions:

The client script is located in this folder:  
./build/install/grpc-sample/bin/wallet-client

The client need to send the code of operation, user id, amount and currency on this order to deposit and withdraw operations.

The **operations** have these codes:  
1 - deposit  
2 - withdraw  
3 - balance  

The **currencies** have these codes:  
0 - EUR  
1 - USD  
2 - GBP

Example of deposit operation:  
./build/install/grpc-sample/bin/wallet-client 1 1 200 0

Example of withdraw operation:  
./build/install/grpc-sample/bin/wallet-client 2 1 200 0


For balance operation, the client just need the code of operation and the user id 

Example of balance operation:  
./build/install/grpc-sample/bin/wallet-client 3 1

### Note
This project was tested on a Mac OS High Sierra (10.13.4). The scripts above can be executed on any OS, except the **create-db.sh** that can run on Mac OS or Linux only.

