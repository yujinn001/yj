package com.sist.util;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class DBConn {

	//오라클 드라이버
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
                                                        //ㅎㅇ
    private static final String URL = "jdbc:oracle:thin:@211.63.89.131:1521:xe";

    private static final String USERNAME = "hr";

    private static final String PASSWORD = "happy";

    
    private DBConn() 
    {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*   싱글톤 => 고정된 메모리 영역을 사용하여 메모리 낭비를 줄이고 
     *   공통된 객체를 사용할 때 매번 객체를 생성하지 않는 방식이다
     *   
     *   => 자바에서 객체를 새로 생성할 때 new 연산자를 통하여 매번 메모리에 새로 할당을 하는데
     *      싱글톤 패턴은 기본 생성자 자체를  private로 생성하여 new연산자를 통해 생성하지 못하도록 제약을 둔다
     *      
     *   => getInstance()메소드를 통하여 객체를 반환한다
     *   public static singleton getInstance(){
     *   
     *   => instance는 static변수로 선언되며getInstance()가 최초로 호출될 때에는 null이므로 한번만 생성하고,
     *      이후에는 생성해놨던 instance를 반환합니다
     *      
     *   => 따라서 다른 함수에서 getInstance()를 여러번 호출하더라도 단 하나의 동일한 instance만을 반환한다
     *   }
     */

    // 외부에서는 getInstance()로 instance를 반환
    // LazyHolder의 instance에 접근하여 반환 
    public static DBConn getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    // 연결
    public Connection createConnection() {
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(PreparedStatement pstmt, Connection conn) {
        try 
        {
            if (pstmt != null){
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*   java 진영에서 가장 많이 사용되는 LazyHolder를 사용하는 싱글톤 패텅
     *   private static class인 LazyHolder안에 instance를 final로 선언하는 방법
     *   
     *   LazyJolder클래스가 초기화 되면서 instance 객체의 생성도 이루어 진다
     *   JVM은 이러한 클래스 초기화 과정에서 원자성을 보장
     *   
     *   => 따라서, final로 선언한 instance 는 getInstance() 호출시 LazyHolder클래스의 초기화가 이루어지면서
     *      원자성이 보장된 상태로 단 한번  생성되고, final 변수이므로 이후로 다시 instance가 할단되는 것을 막을수 있다
     *      
     *   장정) Synchronzied를 사용하지 않아도 JVM 자체가 보장하는 원자성을 사용하여 Thread-Safe하게 싱글톤 패턴을 구현할 수 있는것이다
     * 
     */
    // private static inner class인 LazyHolder
    private static class LazyHolder {
    	// LazyHolder 클래스 초기화 과정에서 JVM이 Thread-safe하게 instance를 생성
        private static final DBConn INSTANCE = new DBConn();
    }

}
