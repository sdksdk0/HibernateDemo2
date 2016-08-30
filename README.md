# HibernateDemo2
Hibernate基础,核心文件配置，映射文件配置

#简介
hibernate是轻量级的JAVAEE应用的持久层解决方案，是一个关系型数据库ORM框架。
ORM：对象关系映射，对象：java中一切皆对象javaBean，关系：数据库中的表（二维表），映射：配置文件。


##编写步骤
- 创建java项目
- 导入jar包
- 核心配置文件(hibernate.cfg.xml)
- javaBean +映射文件（ bena名称.hbm.xml),必须将映射文件加入到核心配置文件。

核心配置文件：

驱动、url、username、password、规范


    <?xml version="1.0"  encoding="UTF-8" ?>
    <!DOCTYPE hibernate-configuration PUBLIC
    	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
    
    <hibernate-configuration>
    	<!-- 相当于连接池 -->
    	<session-factory>
    		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/day15</property>
    		<property name="hibernate.connection.username">zp</property>
    		<property name="hibernate.connection.password">a</property>
    		
    		<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect.class</property>
    		
    	</session-factory>
    
    </hibernate-configuration>



映射文件：
User.hbm.xml，和javabean同包。

配置javabena属性和表中字段的对应关系.

    <?xml version="1.0"  encoding="UTF-8" ?>
    
    <!DOCTYPE hibernate-mapping PUBLIC 
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
    
    <hibernate-mapping>
    	<class  name="cn.tf.domain.User"  table="t_user">
    		<!-- 给表配置主键 -->
    		<id name="uid">
    			<!-- 主键生成策略 -->
    			<generator class="native"></generator>
    		</id>
    		<!-- 其他属性 -->
    		<property name="username"></property>
    		<property name="password"></property>	
    	</class>
    </hibernate-mapping>



##API详解

SessionFactory,单例的，线程安全的，不同的线程可以获得不同的session。

configuration。buildSessionFactory（）：获得实例

openSseeion(),创建一个会话，每执行一次，session都是新的。

Configuration:提供用于去加载配置文件的。

核心配置文件的种类：hibernate.properties(只能配置基本信息) 和hibernate.cfg.xml(可以配置基本信息，映射文件等)

构造方法：new Configuration().configure(); 去加载hibernate.cfg.xml配置文件。


通过configure(string  ),指定自定义的cfg.xml文件。

    config.addResource("cn/tf/domain/User.hbm.xml");
或者：

    config.addClass(User.class);


Session:

每个用户必须独享自己的session，
save,update,delete,createQuery(list/setFirstResult/setMaxResults)


事务操作

1. 开启事务：beginTransaction()
1. 提交事务： commit（）
1. 回滚:rollback()


##主配置文件
hibernate.cfg.xml
位置:src(classpath)  ,在WEN-INF/classes目录下

    
    <!-- 显示生产sql语句 -->
		<property name="hibernate.show_sql">true</property>
		<!-- 格式化方式显示sql -->
		<property name="hibernate.format_sql">true</property>
		
		
		<!-- 表的创建 ,先有表，再有映射，实际开发中通过表自动生成hbm.xml映射文件
			取值：validate:程序运行时，将校验映射文件和表的对应关系，如果一一对应程序正常运行，如果不正常则抛异常。
			     create :每一次都将创建表，如果表已经存在了就删除，程序结束之后表还在
			     create-drop:每一次都将创建表，如果表已经存在了就删除,程序结束之后表也删除了, 必须执行factory.close()
				 update:如果表不存在就创建，如果存在，将维护映射到表的关系。只负责添加，但不进行删除。
				
		-->
		
		
		<property name="hibernate.hbm2ddl.auto">update</property>
		
		<!-- 取消bena校验 -->
		<property name="javax.persistence.validation.mode">none</property>
		
		
		<!-- 将session绑定到本地线程中     
			当在cfg.xml配置了thread，SessionFactory提供的getCurrentSession()将可以使用
			get():相当于map.get(Thread)
			set(value): 相当于map.put(Thread,value)
			remove()  :map.remove(Thread)
		  -->
		<property name="hibernate.current_session_context_class">thread</property>
		
		
##映射文件基本配置


    <class  name="cn.tf.domain.Person"  table="t_person">
		<!-- 给表配置主键 -->
		<id name="pid">
			<!-- 主键生成策略 -->
			<generator class="native"></generator>
		</id>
		<!-- 其他属性
			name:默认用于配置javabean属性名称
			length:配置长度，默认255
			column:当前属性对应表中字段名称，默认和name值相同
					column的属性： <property  column=""  ></property>
					<column  name=""></column>
			type: 数据字段类型
					hibernate类型:例如:string(都是小写)
					java类型:例如java.lang.String
					mysql类型:例如varchar(50)  ,  <column  name="name"  sql-type="varchar(50)" />
					
			日期时间类型：
					date:日期，java.util.Date
					time:java.util.Date
					timestamp:java.util.Date,时间戳随时间变化而变化
					项目中使用datetime表示日期时间
		 -->
		 
		 <!-- 其他配置
				access ，用于确定当前属性如何进行数据封装
					property : 默认值，hibernate采用javabean属性 与 表字段进行对应。在javabean必须提供 getter/setter方法
					field ： hibernate采用 javabean 字段 与 表字段进行对应。 可以没有getter/setter方法
						例如：private String username;
					noop : 提供给hibernate hql使用，数据库没有对应字段。一般不使用。
				precision 和 scale 给 oracle配置，在mysql没有作用。
					precision 配置数字位数
					scale 配置小数位数 
					例如：numeric(precision,scale)  , 12.34  numeric(4,2)
			 		
		 
		  -->
		 
		 
		<property name="name"  length="50"  column="name"  type="string"   access="property">	</property>
		<property name="gender"  ></property>
		<property name="age"  type="integer"></property>
		<property name="photo"  type="binary"   length="200000"></property>
		<property name="birthday" >
			<column name="birthday"  sql-type="datetime"></column>
		</property>
		<property name="desc"  column="`desc`"></property>
		
		
		
	</class>


insert="false"   表示生成insert语句没有当前字段
 update="false" 表示生成update语句没有当前字段
<property name="title"   insert="false"></property>

			 
 在class中设置动态的添加和修改，默认是false，如果属性内容为空，则生成的sql中就没有该字段。

dynamic-insert="false"  dynamic-update="false"
如果使用动态更新，数据必须是查询获得的。


##派生属性

从数据库另一张表查询获得。
聚合函数：count(),max(),min(),avg(),sum()等。


sql语句：如果使用字段，默认从当前表中获得字段的，如果要获得B表字段，必须使用表的别名。


	<property name="orderCount"  formula="(SELECT COUNT(*) FROM t_order  o  WHERE o.book_id=bid)"></property>
	
生成的sql语句:

    select
        book0_.bid as bid1_0_,
        book0_.title as title1_0_,
        book0_.price as price1_0_,
        (SELECT
            COUNT(*) 
        FROM
            t_order  o  
        WHERE
            o.book_id=book0_.bid) as formula0_0_ 
    from
        t_book book0_ 
    where
        book0_.bid=?


##OID映射

hibernate通过OID确定系统，及OID相同，对象就相同，OID取值为数据库主键的值。


    <id  name="cid" >
			<generator class="identity"></generator>
		</id>
		
		
			 id属性配置,
			 name:OID属性名称
			 column：表字段列名
			 length:表字段长度
			 type:表字段类型
			 unsaved-value:save或update方法使用依据
			 			String,默认是null,如果使用unsaved-value="abc" ，当执行save方法，设置“abc”相当之前null
			 generator:主键生成策略
			 			increment:类型必须是整型，自己维护表的数据自动增长，在执行insert语句执行之前，先查询，查询最大值，加1，但是在高并发或集群中会有一定的问题。
			 			
			 			identity:使用数据库底层的自动增长，auto_increment 
			 			
			 			sequence:oracle序列
			 			hilo:采用高低位算法，不支持自动增长，也不支持序列
			 					table ，设置数据库中，另一个表A的表名。
								column，表A的列名
								max_lo，一次操作多少条记录。100表示可以允许一次操作100条记录。
								算法：max_lo *  next_value + next_value
								例如：
									<generator class="hilo">
						                <param name="table">hi_value</param>
						                <param name="column">next_value</param>
						                <param name="max_lo">100</param>
						        	</generator>
						        	
				非整型：
						uuid:随机字符串32长度      
						assigned:自然主键，手动设置
										
##持久对象状态

状态分类：

- transient:瞬时态，session中没有缓存数据，数据库没有对应的数据。
- 	persistent:持久态，session中有缓存数据，数据库中最终会有该数据，例如save(user).
- 	detached:脱管态,session没有缓存，但是数据库中有该数据，


瞬时态->持久态   :执行save()和saveOrUpdate()

瞬时态->脱管态    :手动设置OID，如果OID对应的记录不存在，之后操作将抛出异常

持久态->瞬时态   :当执行delete()，（删除态）


持久态->脱管态   :close()关闭,clear()清除所有缓存，session.evict(PO)将指定的对象从缓存中移除


脱管态->瞬时态  :手动删除OID

脱管态->持久态  :执行update，执行了saveOrUpdate()



所有查询结果，对象都是持久态，查询结果保存在session中。 


###一级缓存
session级别的缓存，及将数据保存在session中。
一级缓存内置，不能删除，必须使用的。

目的：提高性能，减少数据库的访问。
