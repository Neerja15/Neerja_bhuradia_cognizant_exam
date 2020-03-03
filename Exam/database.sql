create database assignment;

use bankManagement;

Database changed

1.create  table branch_master(branch_id varchar(6) primary key,branch_name varchar(30), branch_city varchar(30));
Query OK, 0 rows affected (0.34 sec)

2. create  table loan_detail(customer_number varchar(6) ,branch_id varchar(30), loan_amount int ,foreign key(branch_id) references branch_master(branch_id), foreign key (customer_number) references customer_master(customer_number));
Query OK, 0 rows affected (0.09 sec)

3.create  table customer_master(customer_number varchar(6) primary key,firstname varchar(30),middlename varchar(30),lastname varchar(30),customer_city varchar(15), customer_contact_number varchar(10), occupation varchar(20),customer_date_of_birth date );
Query OK, 0 rows affected (0.11 sec)

4.create  table account_master(account_number varchar(6) primary key,customer_number varchar(6),branch_id varchar(6),opening_balance int,account_opening_date date, customer_type varchar(10), account_status varchar(10),foreign key (customer_number) references customer_master(customer_number),foreign key(branch_id) references branch_master(branch_id));
Query OK, 0 rows affected (0.14 sec)

5.create  table transaction_details(transaction_number varchar(6) primary key ,account_number varchar(6),date_of_transaction date,medium_of_transaction varchar(20),transaction_type varchar(20),transaction_amount int,foreign key (account_number) references account_master(account_number));
Query OK, 0 rows affected (0.13 sec)

______________________________________Inserting Of Data______________________________________________________________________

1.insert into branch_master values('101','HDFC Bank','Pune'),('102','ICICI Bank','Delhi'),('103','SBI Bank','Mumbai');

2.insert into customer_master values(1001,'Kratika','Kumari','Jain','Delhi',9874563210,'PAT','1988-04-17'),(1002,'Yash','Kumar','Singh','Pune','9872345690','Marketing','1997-06-27'),(1003,'Nirali','Kumari','Shah','Mumbai','7412345690','Designing','1999-03-25');

3.insert into account_master values('654322','1001','101',2000,'2019-20-20','Salary A/c','Active'),('789654','1002','102',1000,'2019-15-20','Salary A/c','Active'),('987456','1003','103',500,'2019-08-20','Salary A/c','Terminated');


4.insert into loan_detail values(1001,'101',60000),('1002','102',30000),('1003','103',50000);


5.insert into transaction_details values('PUN001','654322','2019-02-12' ,'Banking', 'Withdraw',30000),('PUN002','789654','2019-06-20' ,'Net banking', 'Withdraw',9000),('PUN003','987456','2019-09-20' ,'Banking', 'Deposit',60000);


______________________________________________Queries______________________________________________________________________

1. select a.account_number,c.customer_number,c.firstname,c.lastname,a.account_opening_date from account_master a,customer_master c where c.customer_number=a.customer_number order by account_number;

2. select count(*) as cust_count from customer_master where customer_city='Delhi';

3. select a.customer_number,c.firstname,a.account_number from account_master a,customer_master c where a.customer_number=c.customer_number and day(account_opening_date)>15;

4. select a.customer_number,a.account_number,c.firstname from account_master a,customer_master c where a.customer_number=c.customer_number and account_status="Terminated";

5.select transaction_type,count(*) as Trans_count from transaction_details t,account_master a where t.account_number=a.account_number and a.customer_number='1001';

6. select count(*) as Count_Customer from customer_master where customer_number not in(select distinct customer_number from account_master);

7.select distinct a.account_number,sum(t.transaction_amount)+a.opening_balance as Deposit_Amount from account_master a,transaction_details t where  t.account_number=a.account_number and transaction_type="Deposit" group by account_number
union select account_number,opening_balance from account_master where account_number not in
(select account_number from transaction_details);

8.select b.branch_city,count(*) from branch_master b,account_master a where b.branch_id=a.branch_id group by branch_city
union
select branch_city,0 from branch_master where branch_city not in
(select branch_city from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_city)
union
select b.branch_id,count(*) from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_id
union
select branch_id,0 from branch_master where branch_id not in
(select a.branch_id from branch_master b,account_master a where a.branch_id=b.branch_id group by branch_id);

9. select c.firstname from customer_master c,account_master a where a.customer_number=c.customer_number  group by c.firstname having count(*)>1 ;

10.select c.customer_number,c.firstname,c.customer_city,b.branch_city from branch_master b inner join customer_master c inner join account_master a
on a.customer_number=c.customer_number and a.branch_id=b.branch_id where b.branch_city<>c.customer_city;
