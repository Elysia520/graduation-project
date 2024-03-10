package com.littleheap.DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

import com.littleheap.Book;
import com.littleheap.Part;
import com.littleheap.Static.Information;

public class TableOperate {

    //数据库查询连接模板
    public TableOperate() {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            String sql = "select * from temp";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("编号" + "\t" + "姓名" + "\t" + "年龄");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //是否存在该用户
    public static boolean isExist_Customer(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Customer";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //是否存在该管理员
    public static boolean isExist_Manager(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //注册新用户
    public static void regist_Customer(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");

            String sql = "insert into Customer values('" + user + "','" + password + "');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //注册新管理员
    public static void regist_Manager(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Manager");

            String sql = "insert into Manager values('" + user + "','" + password + "');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //改变用户的密码
    public static void changePassword_Customer(String user, String password, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Customer set customer_password = '" + newPassword + "' where customer_user = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //改变管理员的密码
    public static void changePassword_Manager(String user, String password, String newPassword) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Manager set manager_password = '" + newPassword + "' where manager_user = '" + user + "';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //是否存在该用户名
    public static boolean isExist_Customer_user(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Customer";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //是否存在该管理员名称
    public static boolean isExist_Manager_user(String user, String password) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");

            String url = Information.JDBC_URL;    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("用户名" + "\t" + "\t" + "\t" + "密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //插入零件图片
    public static void insertComponent(int Part_ID, String Part_name, String Part_type, long parts_image_data) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-insertBook");

            String url = Information.JDBC_URL;    //JDBC的URL

            try {
                Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
                Statement stmt = conn.createStatement(); //创建Statement对象
                System.out.println("成功连接到数据库-insertComponent");

                String sql = "INSERT INTO component (name, type, image, part_number) VALUES (?, ?, ?, ?)";   //要执行的SQL

                PreparedStatement stmts = conn.prepareStatement(sql);
                stmts.setString(1, String.valueOf(Part_ID));
                stmts.setString(1, Part_name);
                stmts.setString(1, Part_type);
                stmts.setString(1, String.valueOf(parts_image_data));
                stmts.executeUpdate();
                System.out.println("数据插入成功");

                stmts.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //新建类别
//    public static void newClass(String classnumber, String classname) {
//    	try{
//            //调用Class.forName()方法加载驱动程序
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("成功加载MySQL驱动-newClass");
//
//            String url=Information.JDBC_URL;    //JDBC的URL
//            Connection conn;
//
//            conn = DriverManager.getConnection(url,Information.username,Information.password);
//            Statement stmt = conn.createStatement(); //创建Statement对象
//            System.out.println("成功连接到数据库-newClass");
//
//            String sql = "CREATE TABLE "+classname+"Book(number VARCHAR(255) primary key,classnumber VARCHAR(255),name VARCHAR(255),classname VARCHAR(255),price VARCHAR(255),state VARCHAR(255),total VARCHAR(255),current VARCHAR(255),dateon VARCHAR(255),dateoff VARCHAR(255));";    //要执行的SQL
//
//            PreparedStatement stmts = conn.prepareStatement(sql);
//            stmts.executeUpdate();
//
//            stmts.close();
//            stmt.close();
//            conn.close();
//            }catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//    }

    //删除零件信息
    public static void deleteComponent(int Part_ID, String Part_name) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-deleteComponent");

            String url = Information.JDBC_URL;    //JDBC的URL
            try {
                Connection conn;

                conn = DriverManager.getConnection(url, Information.username, Information.password);
                Statement stmt = conn.createStatement(); //创建Statement对象
                System.out.println("成功连接到数据库-deleteComponent");

                String sql = "DELETE FROM component Book WHERE number = ?;"; //要执行的SQL

                try (PreparedStatement stmts = conn.prepareStatement(sql)) {
                    System.out.println("成功连接到数据库-deleteBook");
                    stmts.setString(1, String.valueOf(Part_ID));
                    stmts.setString(2, Part_name);
                    stmts.executeUpdate();

                    stmts.close();
                    stmt.close();
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    //查询零件信息
    public static ArrayList<Part> search_Part_name(String Part_name) {
        ArrayList<Part> parts = new ArrayList<>();
    	try{
    		
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_Part_name");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            System.out.println("成功连接到数据库-search_Part_name");

            String sql = "SELECT * FROM books WHERE Part_name = ?;";   //要执行的SQL
            PreparedStatement  pstmt  = conn.prepareStatement(sql); //创建Statement对象
            pstmt.setString(1, Part_name);
            ResultSet rs = pstmt.executeQuery(sql);//创建数据对象
                while (rs.next()){
                    Part part = new Part();
                    part.setPart_ID(rs.getInt("Part_ID"));
                    part.setPart_name(rs.getString("Part_name"));
                    part.setPart_type(rs.getString("Part_type"));
                    part.setParts_image_data(rs.getLong("parts_image_data"));
                    part.setPart_ID(rs.getInt("Part_ID"));
                    parts.add(part);
                }
                rs.close();
                pstmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        return parts;
    }
    
    //更改零件信息
    public static void updateComponent(String partName,int newID,String newname,String newtype,long newimage_data) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-updateComponent");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            //Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-updateComponent");

            String sql = "UPDATE component SET id = ?, name = ?, type = ?, image = ? WHERE part_name = ?;";//要执行的SQL
            PreparedStatement pstmt  = conn.prepareStatement(sql);

            pstmt.setInt(1, newID);
            pstmt.setString(2, newname);
            pstmt.setString(3, newtype);

            // 设置图片数据
            try (FileInputStream fis = new FileInputStream(String.valueOf(newimage_data))) {
                pstmt.setBinaryStream(4, fis, fis.available());
            } catch (FileNotFoundException e) {
                System.err.println("Image file not found: " + e.getMessage());
                return;
            }

            pstmt.setString(5, partName);

            // 执行更新操作
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record updated.");
            }
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
  //创建用户数据库
    public static void newCustomer(String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-newCustomer");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-newCustomer");

            String sql = "CREATE TABLE "+user+"Customer (number VARCHAR(255) primary key,classname VARCHAR(255),name VARCHAR(255),dateoff VARCHAR(255));";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    //借书注射到用户信息
    public static void borrowBook_Insert(String classname,String number,String user,String dateoff) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-borrowBook_Insert");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-borrowBook_Insert");

            String sql = "insert into "+user+"Customer values('"+number+"','"+classname+"','"+search_bookname(classname, number)+"','"+dateoff+"');";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    //还书更新书籍数据库信息
    public static void returnBook_Update(String classname,String number,String user,String dateoff) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-returnBook_Update");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-returnBook_Update");

            String sql = "update "+classname+"Book set state = 'in' where number = '"+number+"';\n";    //要执行的SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();  
            stmts_state.close();
            
            sql = "update "+classname+"Book set current = 'null' where number = '"+number+"';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();  
            stmts_current.close();
            
            sql = "update "+classname+"Book set dateoff = 'null' where number = '"+number+"';\n";
            PreparedStatement stmts_dateoff = conn.prepareStatement(sql);
            stmts_dateoff.executeUpdate();
            stmts_dateoff.close();
            
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    //还书更新用户的数据库信息
    public static void returnBook_Delete(String number,String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-returnBook_Delete");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-returnBook_Delete");

            String sql = "delete from "+user+"Customer where number = '"+number+"';";  //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    //续借更新两者数据库信息
    public static void prolongBook_Update(String classname,String number,String dateoff,String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-prolongBook_Update");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-prolongBook_Update");

            String sql = "update "+classname+"Book set dateoff = '"+dateoff+"' where number = '"+number+"';\n";    //要执行的SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();  
            stmts_state.close();
            
            sql = "update "+user+"Customer set dateoff = '"+dateoff+"' where number = '"+number+"';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();  
            stmts_current.close();
            
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
  //查询个人图书信息
    public static void search_personal(String user) {
    	Information.bookarray.clear();
    	try{
    		
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_personal");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_personal");

            String sql = "select * from "+user+"Customer;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                while (rs.next()){
                	Book book = new Book();
                    book.number = rs.getString(1);
                    book.classname = rs.getString(2);
                    book.name = rs.getString(3);
                    book.dateoff = rs.getString(4);
                    Information.bookarray.add(book);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	//是否存在该Table表
    public static boolean isExist_Table(String table) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Table");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Table");

            String sql = "show tables";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                while (rs.next()){
                    if(table.equals(rs.getString(1))) {
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	//查找书名
    public static String search_bookname(String classname,String number) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookname");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookname");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return "null";
    }
    
	//查找书籍状态
    public static String search_bookstate(String classname,String number) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookstate");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookstate");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return rs.getString(6);
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return "null";
    }
    
	//查找书籍还书日期
    public static int search_bookdateoff(String classname,String number) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookdateoff");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookdateoff");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return Integer.parseInt(rs.getString(10));
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return 0;
    }
}
