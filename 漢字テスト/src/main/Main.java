package main;

import java.sql.SQLException;
import java.util.List;

import db.HsqlDB;
import file.FileReader;
public class Main {

	public static void main(String[] args)throws SQLException, Exception  {

		HsqlDB db = new HsqlDB();

		List<String> data = FileReader.SJIS("./data/SJIS.txt");

		for(String s: data){
			db.insert(s);
		}

		db.select();
    }




}
