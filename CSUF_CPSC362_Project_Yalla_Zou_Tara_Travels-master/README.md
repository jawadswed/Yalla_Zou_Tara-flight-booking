# CSUF_CPSC362_Project_Yalla_Zou_Tara_Travels
The project for CPSC362 project

Steps to remote connect to AWS MySQL database:

1. Download the public key CPSC362Project.pem to local machine

2. In the terminal commandline tool, run the command below
```cd [path to the CPSC362Project.pem file]```

3. Remote login aws, run the command in terminal
```ssh -i "CPSC362Project.pem" ec2-user@ec2-52-14-56-213.us-east-2.compute.amazonaws.com```

4. Login mysql, run the command in terminal
```mysql -u root -pCPSC362!```

5. Search in google for "my public IP address", then replace your public ip to the command below to get access to the database from application
```GRANT ALL PRIVILEGES ON *.* TO root@[XXX.XXX.XXX.XXX(my public IP here)] IDENTIFIED BY 'CPSC362!' WITH GRANT OPTION;```


6. Exit MySQL, run the command 
```exit```

7. Exit remote AWS connection, run the command
```logout```

