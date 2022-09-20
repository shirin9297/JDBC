package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2. Adim: Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "nikolayew9798");

        //3. Adim: Statement olustur.
        Statement st = con.createStatement();

        //4. Adim: Query calistir.
        //1.Ornek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1= "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
          boolean result = st.execute(sql1);
       // System.out.println(result);//False return yapar, cunku data cagrilmadi.

        //2.Örnek: Table'a worker_address sütunu ekleyerek alter yapın.
        String sql2 = "AlTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Ornek: Drop workers table
        String sql3 = "DROP TABLE workers";
        st.execute(sql3);

        //5. Adim: Baglanti ve Statement'i kapat.
        con.close();
        st.close();



    }
}
