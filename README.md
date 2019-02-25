# Animal-shelter-web

Animal shelter web is a web application based on JavaEE that connects to MySQL database with Spring JDBC package and handles CRUD operations. 
Requested data is send to client as JSP files that use Java Standard Tag Library to visualize retrieved data.
Design of respective jsp files is performed with HTML/CSS. 

The main goal of this application was to get to know how web applications work in general in order to start learning Spring with kowhing basic JavaEE fundamentals that Spring covers. During developing it i get familiar with HTTP protocol and its methods. Understood how requests and paramater works, how to send attributes and use different scopes of them. I found how servlets work and how to use them to redirect user between pages with include, forward and redirect operations.

Moreover project allowed me to know relational databases concept - being more specific SQL database. To make app CRUD available i need to teach myself basic of SQL language, what clauses are, how to use them, what type of joins between tables are available and whats the difference between them. Started with simply JDBC and creating connection during each query, then added connection pool based on singleton  pattern with use of HikariCP. The next step was to change hard coded String queries to PreparedStatement type and finally to use Spring JDBC package and JDBC Template class.

The last part was about storing data into db and geting it. To achieve that in simple way (in JEE environment) I used abstract factory pattern and stored CRUD methods and queries for each object type in different class. Abstract factory also allows to create different implementation types that depend on which database is used. With CRUD and database I also was able to add registration and user roles with restricted areas based on database entities.

Views are sent to user in form of jsp files that use html/css and JSTL tags due to not mixing java language and html in one file. Its easier to read however not perfect still. To deploy app I've been using Tomcat local server.

At this point after adding some basic frontend I decided I know as much as I need to start learning Spring.
