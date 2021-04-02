carl-07-trans：做事务的环境项目

步骤：
1. 创建maven项目
2. 加入maven依赖
        spring依赖
        mybatis依赖
        mysql驱动
        spring事务依赖
        mybatis和spring继承的依赖：mybatis官方提供，用来在spring项目中创建mybatis的SqlSessionFactory，dao对象
3. 创建实体类
        sale, goods
4. 创建dao接口和mapper文件
        SaleDao接口，GoodsDao接口
        SaleDao.xml, GoodsDao.xml
5. 创建mybatis主配置文件
6. 创建Service接口和实现类，属性是dao
7. 创建spring配置文件，声明mybatis的对象交给spring创建
        数据源
        SqlSessionFactory
        dao对象
        声明自定义的service
8. 创建测试类，获取Service对象，通过service对象调用dao完成数据库的访问