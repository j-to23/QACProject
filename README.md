Welcome to my Inventory Management System, written in Java

On startup you will be asked for a Database Username and Password, these should be whatever your SQL Database's Username and passwords are.

You will then be asked which table of the database you want to edit: Customers(1), Products(2), Orders(3), Orderline(4)

	Orders are attached to customers and orderlines are the indidual items added on to the order.

you will then be asked whether you want to Create(1) a new row for that table, Read(2) all rows on the table, Update(3) a column on a row defined by their tableID, or Delete(4) a row by tableID.

Creating or deleting orderlines will automatically add or subtract the cost of the items from the associated order.

Deleting orders will also remove all attached orderlines.

