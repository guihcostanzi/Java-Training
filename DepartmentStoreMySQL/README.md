## CONNECTING A PROGRAM TO A DATABASE USING JDBC 

  JDBC is an Java API that permits you to connect to any relational database. Each database requires its own drivers.

  In eclipse, you can use the user library to better organize your drivers. You can import the driver's .jar file and use it for your programs. To do that, go to your 
  Java Program's properties > Java Build Path > Libraries.

  You can either use a predefined user library, or just manually import the desired driver (.jar) to the "Referenced Libraries", by using the option "Add External JARs...".

### CLASSES TO TAKE NOTE

### CONNECTION 

  This class manages the connection between your java program and the database. Needs to be manually closed with the .close() method.

### PROPERTIES

  It has a .load(FileInputStream fs) method. It storages the properties of an text file, following this model :

  ````
  user=guilherme
  password=1234
  useSSL=false
  dburl=jdbc:mysql://localhost:3306/jdbc
  allowPublicKeyRetrieval=true
  ````

  This <property>=<value> model should be followed in the text archive.
  Objects of the Properties type can be passed as arguments when setting the connection with the Database, using the DriverManager.

  *Obs : I had to add that **allowPublicKeyRetrieval=true** property to make things work with the new MySQL driver. I also deleted the module-info.java from the src, 
  it wouldn't let me use sql classes.*

  ````
  String url = props.getProperty("dburl");
  Connection conn = DriverManager.getConnection(url, props);
  ````

  The properties will then be considered when estabilishing the connection with the database.
  
### STATEMENT
  
  This class is responsible for receiving SQL queries/commands, and for execcuting them too. Useful when you want to execute a sql query only once. Low performance.
  
  Example :
  ````
  String sql = "SELECT * FROM EMPLOYEES";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);
  ````
  *Obs : The executeQuery() method is called in a ResultSet variabele, returning the data from the database according to the query. This data can be accessed in the
  form of rows and column indexes, either the column name or its position (1, 2 ...).*
  
  Example:
  ````
  //1 - Column Name
  res.getInt("ID_COLUMN");  
  
  //2 - Column Index Number
  res.getString(3);  
  ````
  *Obs : Note that the get<type> method follows the type of the value you want to return.*
  
### PREPARED STATEMENT
  
  Similar to STATEMENT class, but accepts parameters at runtime. Useful when you want to execute a query multiple times. Great performance.
  When you use Prepared Statement, the sql query is compiled the first time and cached at the database server, granting more speed for the subsequent queries.
  
  Example :
  ````
  PreparedStatement sqlQuery = conn.prepareStatement("INSERT INTO EMPLOYEES (NAME, SALARY) VALUES (?, ?)");
  
  sqlQuery.setString(1, "Martin");
  sqlQuery.setDouble(2, 1200.0);
  
  int rowsAffected = sqlQuery.executeUpdate();
  ````
  
  *Obs : The executeUpdate() method can be called outside of a variable, simply executting the sql command, or inside a variable, returning the number
  of rows affected.*
  
  
  
  




