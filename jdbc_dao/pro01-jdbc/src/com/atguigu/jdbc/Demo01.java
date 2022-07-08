package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//目标：和数据库建立连接
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.添加jar
        // 2.加载驱动
        /**
         * org.gjt.mm.mysql.Driver
         * 
         * 是早期的驱动名称，后来就改名为com.mysql.jdbc.Driver，现在一般都推荐使用com.mysql.jdbc.Driver。在最新版本的mysql
         * jdbc驱动中，为了保持对老版本的兼容，仍然保留了org.gjt.mm.mysql.Driver，但是实际上org.gjt.mm.mysql.Driver中调用了com.mysql.jdbc.Driver，因此现在这两个驱动没有什么区别。
         * 
         * 其它说法：
         * 
         * org.gjt.mm.mysql.Driver是当时最好的MySQL JDBC，但不是MySQL公司的，然后MySQL将MM的JDBC驱动
         * 收为官方的JDBC驱动，所以将驱动的package也改了，但还保留了org.gjt.mm.mysql.Driver这个路径的引用，也就是你使用新版的JDBC驱动时还可以通过这个来引用，打开下载的新版JDBC驱动的jar文件可以看到，只有一个文件的目录是org.gjt.mm.mysql，就是为了兼容而设计的。
         */
        Class.forName("com.mysql.jdbc.Driver");
        // 3.通过驱动管理器获取连接对象
        // 3-1.准备URL
        String url = "jdbc:mysql://localhost:3306/fruitdb";
        // 3-2.准备用户名
        String user = "root";
        // 3-3.准备密码
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url, user, pwd);

        System.out.println("conn = " + conn);
    }
}

/*
 * 1. JDBC : sun发布的 一个 java程序和数据库之间通信的 规范（接口）
 * 
 * 2. 各大数据库厂商去实现JDBC规范（实现类），这些实现类打成压缩包，就是所谓的jar包
 * 
 * 
 * 3. 常见错误：
 * 1. ClassNotFoundException
 * 2. 中文乱码
 * 
 * 
 */