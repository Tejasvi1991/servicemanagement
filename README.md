1. Table Name : servicedetails

2. Create table Query:
create table `accountsdb`.`servicedetails` ( `id` int (4) NOT NULL AUTO_INCREMENT , `service_name` varchar (40) NULL ,`URL` varchar (200) NULL,
`create_date` DateTime NULL ,`update_date` DateTime NULL,`status` int (4) NULL,PRIMARY KEY ( `id` ) );
