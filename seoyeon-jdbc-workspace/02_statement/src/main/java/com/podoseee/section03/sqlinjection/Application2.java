package com.podoseee.section03.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.podoseee.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        // 사번만을 가지고만 사원 조회하기 (PreparedStatement 이용)

        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번: ");
        String empId = sc.nextLine();

        String query = "SELECT * FROM employee WHERE emp_id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, empId); // 바인딩 시킨다

            rset = pstmt.executeQuery();

            if(rset.next()){
                System.out.println(rset.getString("emp_name") + ", " + rset.getString("dept_code" + ", " + rset.getInt("salary")));
            }else{
                System.out.println("조회된 사원이 없습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
             ## Statement VS PreparedStatement ##
             1. 파라미터 바인딩
                - Statement         : 파라미터 바인딩 불가, 쿼리 문자열 그대로 실행
                - PreparedStatement : ?(홀더)를 통해 파라미터 바인딩 가능 => 동적 쿼리 작업시 유용
             2. SQL Injection
                - Statement         : SQL Injection에 취약
                - PreparedStatement : 파라미터 바인딩 방식이므로 SQL Injection 방지 가능
             3. 컴파일 방식
                - Statement         : sql문 실행될때마다 데이터베이스 엔진에서 매번 새롭게 컴파일
                - PreparedStatement : 최초 1번만 컴파일되고 캐싱되어 재사용됨 => 동일한 쿼리를 반복실행할 때 더 빠름(성능이 좋음)
         */

    }
}
