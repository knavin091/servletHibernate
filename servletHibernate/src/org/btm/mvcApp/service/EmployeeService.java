<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
<session-factory>
<!-- database information -->
<property name="hibernate.connection.driver_class">
com.mysql.jdbc.Driver</property>
<property name="hibernate.connection.url">
jdbc:mysql://localhost:3306/hibserv</property>
<property name="hibernate.connection.user">
root</property>
<property name="hibernate.connection.password">
8102</property>

<property name="dialect">
org.hibernate.dialect.MySQL5Dialect</property>
<property name="show_sql">true</property>

<property name="hbm2ddl.auto">update</property>
<mapping class="org.btm.mvcApp.dto.Employee"/>
</session-factory>
</hibernate-configuration>