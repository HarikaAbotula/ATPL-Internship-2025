show databases;
use intern;

-- Customers Table
CREATE TABLE CustomersHarika (customerID INT PRIMARY KEY,customerName VARCHAR(50),contactName VARCHAR(20),address VARCHAR(100),
    city VARCHAR(20),postalCode VARCHAR(20),country VARCHAR(20)
);

-- Insert into Customers
INSERT INTO CustomersHarika VALUES
(1, 'Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany'),
(2, 'Bs Beverages', 'Victoria Ashworth', 'Fauntleroy Circus', 'London', 'EC2 5NT','UK'),
(3, 'Frankenversand', 'Peter Franken', 'Berliner Platz 43', 'München', '80805', 'Germany');

-- Categories Table
CREATE TABLE CategoriesHarika (categoryID INT PRIMARY KEY,categoryName VARCHAR(30), description TEXT);

-- Insert into Categories
INSERT INTO CategoriesHarika VALUES
(1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
(2,	'Dairy-products', 'cheese');

-- Employees Table
CREATE TABLE EmployeesHarika (empID INT PRIMARY KEY,lastName VARCHAR(25),firstName VARCHAR(25),birthDate DATE,photo VARCHAR(50),notes TEXT);

-- Insert into Employees
INSERT INTO EmployeesHarika VALUES
(1, 'Brown', 'Nancy', '1980-05-15', 'EmpID1.jpg', 'Nancy is a member of Toastmasters International'),
(2, 'Davis', 'Anne', '1975-03-20', 'EmpID2.jpg', 'Anne has a BA degree in English from St. Lawrence College. She is fluent in French and German');

-- Shippers Table
CREATE TABLE ShippersHarika (shipperID INT PRIMARY KEY,shipperName VARCHAR(50),phone VARCHAR(20)); 

-- Insert into Shippers
INSERT INTO ShippersHarika VALUES
(1, 'FastShip', '123-456-7890'),
(2, 'QuickMove', '987-654-3210');

-- Orders Table
CREATE TABLE OrdersHarika (orderID INT PRIMARY KEY,customerID INT,employeeID INT,orderDate DATE,shipperID INT,
    FOREIGN KEY (customerID) REFERENCES CustomersHarika(customerID),
    FOREIGN KEY (employeeID) REFERENCES EmployeesHarika(empID),
    FOREIGN KEY (shipperID) REFERENCES ShippersHarika(shipperID)
);

-- Insert into Orders
INSERT INTO OrdersHarika VALUES
(1, 1, 1, '2023-01-15', 1),
(2, 2, 2, '2023-02-10', 2),
(3, 3, 1, '2023-02-20', 1),
(4, 1, 2, '2023-03-05', 2),
(5, 2, 1, '2023-03-15', 1);

-- Suppliers Table
CREATE TABLE SupplierHarika (supplierID INT PRIMARY KEY,supplierName VARCHAR(50),contactName VARCHAR(50),address VARCHAR(200),
	city VARCHAR(50),postalCode VARCHAR(20),country VARCHAR(50)
);

-- Insert into Supplier
INSERT INTO SupplierHarika VALUES
(1, 'Supplier One', 'John Doe', '321 Peach St', 'Miami', '33101', 'USA'),
(2, 'Supplier Two', 'Jane Roe', '654 Plum Rd', 'Vancouver', 'V5K0A1', 'Canada');   

-- Products Table
CREATE TABLE ProductsHarika (productID INT PRIMARY KEY,productName VARCHAR(100),supplierID INT,categoryID INT,unit VARCHAR(50),price DECIMAL(10,2),
    FOREIGN KEY (supplierID) REFERENCES SupplierHarika(supplierID),
    FOREIGN KEY (categoryID) REFERENCES CategoriesHarika(categoryID)
);

-- Insert into Products
INSERT INTO ProductsHarika VALUES
(1, 'Cola', 1, 1, '12-pack', 5.99),
(2, 'Orange Juice', 1, 1, '1L bottle', 3.49),
(3, 'cheese', 2, 2, '200g bag', 2.99);

-- OrderDetails Table
CREATE TABLE OrderDetailsHarika (orderDetailID INT PRIMARY KEY,orderID INT,productID INT,quantity INT,
    FOREIGN KEY (orderID) REFERENCES OrdersHarika(orderID),
    FOREIGN KEY (productID) REFERENCES ProductsHarika(productID)
);

-- Insert into OrderDetails
INSERT INTO OrderDetailsHarika VALUES
(1, 1, 1, 10),
(2, 1, 2, 5),
(3, 2, 3, 8),
(4, 3, 1, 12),
(5, 4, 2, 3),
(6, 5, 3, 6);


Select * from CustomersHarika;
Select * from categoriesHarika;
select * from employeesHarika;
select * from shippersHarika;
select * from supplierHarika;
select * from productsHarika;
select * from ordersHarika;
select * from orderdetailsHarika;

-- 1.What is the total number of orders?
select count(orderid) As Total_num_of_orders from OrdersHarika;

-- 2.How many customers are there?
select count(customerid) as total_customers from customersHarika;

-- 3. What is the total revenue from all orders?
select p.productname, Sum(od.quantity * p.price) as total_revenue from orderdetailsHarika od
join productsHarika p on od.productid=p.productid
group by productname;

-- 4.What are the top 5 best-selling products by quantity?
select p.productname,sum(od.quantity) as quantity from  orderdetailsHarika od 
join productsHarika p on od.productid=p.productid 
group by productname 
order by quantity desc limit 5;

-- 5.Which are the top 5 products by total revenue generated?
select p.productname, sum(od.quantity*p.price) as total_revenue from productsHarika p
join orderdetailsHarika od on p.productid=od.productid 
group by productname
order by total_revenue desc limit 5;

-- What is the average revenue overall products?
select avg(avg_revenue) as avg_revenue_product from
	(select p.productname , sum(od.quantity*p.price) as avg_revenue from productsHarika p
    join orderdetailsHarika od on p.productid=od.productid 
    group by productname) as product_revenue;
    
-- 6.what is the average revenue per product?
SELECT p.productname,
  COUNT(DISTINCT od.orderid) AS orders_count,
  SUM(od.quantity * p.price) AS total_revenue,
  ROUND(SUM(od.quantity * p.price) / COUNT(DISTINCT od.orderid), 2) AS avg_revenue_per_product
FROM OrderDetailsHarika od
JOIN ProductsHarika p ON od.productid = p.productid
GROUP BY p.productname;

-- 7.What is the total revenue generated per product category?
select c.categoryname , sum(od.quantity*p.price) as total_revenue from orderdetailsHarika od
join productsHarika p on od.productid =p.productid 
JOIN CategoriesHarika c ON p.categoryid = c.categoryID
group by c.categoryname;

-- 8.Which product categories have the highest average price per product?
select c.categoryname,avg(p.price) as highest_avg_price from productsHarika p
	join categoriesHarika c on p.categoryid=c.categoryid 
    group by c.categoryname
    order by highest_avg_price desc;

-- 9.Who are the top 5 customers by purchase volume(total revenue generated by each customer)?
SELECT cu.customerName, SUM(od.quantity * p.price) AS total_spent
FROM OrdersHarika o
JOIN CustomersHarika cu ON o.customerid = cu.customerID
JOIN OrderDetailsHarika od ON o.orderid = od.orderid
JOIN ProductsHarika p ON od.productid = p.productid
GROUP BY cu.customerName
ORDER BY total_spent DESC
LIMIT 5;

-- who are the top 5 customers, made highest orders.
select c.customername,sum(o.orderid) as total_orders from ordersHarika o
join customersHarika c on o.customerid=c.customerid
group by c.customername
order by total_orders desc limit 5;

-- 10.How many customers are there in each country?
select country ,count(customerid) as total_cust from customersHarika group by country;

-- 11.Which country contributes the most to total revenue?
SELECT cu.country, SUM(od.quantity * p.price) AS total_revenue
FROM OrdersHarika o
JOIN CustomersHarika cu ON o.customerid = cu.customerID
JOIN OrderDetailsHarika od ON o.orderid = od.orderid
JOIN ProductsHarika p ON od.productid = p.productid
GROUP BY cu.country
ORDER BY total_revenue DESC
LIMIT 1;

-- 12.What is the average order value(avg amount of money spent on each order) per customer?
Select c.customername,Avg(od.quantity * p.price) as avg_order_value
from ordersHarika o
join CustomersHarika c on o.customerid = c.customerid
join orderdetailsHarika od on o.orderid = od.orderid
join productsHarika p on od.productid=p.productid
group by c.customername;


-- 13.Which customers placed more than 5 orders?
select c.customername,count(*) as total_orders from ordersHarika o 
join customersHarika c on o.customerid=c.customerid 
group by c.customername
having count(*)>5;

-- 14.How many orders are placed each month?
select date_format(orderdate, "%Y-%m") as month ,count(*) as total_orders 
from ordersHarika 
group by month
order by month;

-- 15.What is the average order value per month?
select DATE_FORMAT(o.orderdate, '%Y-%m') AS month ,avg(od.quantity * p.price) as avg_order_value
from ordersHarika o
join orderdetailsHarika od on o.orderid = od.orderid
join productsHarika p on od.productid=p.productid
group by month;

-- 16.Which month had the highest number of orders?
SELECT DATE_FORMAT(orderdate, '%Y-%m') AS month, COUNT(*) AS total_orders
FROM OrdersHarika
GROUP BY month
ORDER BY total_orders DESC
LIMIT 1;

-- 17.How many orders has each employee handled?
select CONCAT(e.firstname, ' ', e.lastName) AS employee_name,count(o.orderid) as total_orders_emp_handled
from ordersHarika o 
join employeesHarika e on o.employeeid=e.empid
group by employee_name;

-- 18.Which employee generated the highest revenue?
select CONCAT(e.firstname, ' ', e.lastName) AS employee_name ,sum(od.quantity*p.price) as highest_revenue
from orderdetailsHarika od
join productsHarika p on od.productid = p.productid
join ordersHarika o on od.orderid=o.orderid
join employeesHarika e on o.employeeid=e.empid
group by employee_name
order by highest_revenue desc limit 1;

-- 19.How frequently has each shipper been used?
-- For each shipper (delivery company), how many times were they used to deliver orders?
SELECT s.shippername, 
       COUNT(o.orderid) AS shipment_count
FROM OrdersHarika o
JOIN ShippersHarika s ON o.shipperid = s.shipperid
GROUP BY s.shippername;

-- 20.Which shipper delivered the most revenue-generating orders?
SELECT s.shippername, SUM(od.quantity * p.price) AS total_revenue
FROM OrdersHarika o
JOIN ShippersHarika s ON o.shipperid = s.shipperid
JOIN OrderDetailsHarika od ON o.orderid = od.orderid
JOIN ProductsHarika p ON od.productid = p.productid
GROUP BY s.shippername
ORDER BY total_revenue DESC
LIMIT 1;








