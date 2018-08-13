package com.jcg.spring.mvc.file.upload;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class FileUploadInDb {

	static JdbcTemplate jdbcTemplateObj;
	static SimpleDriverDataSource dataSourceObj;

	// Database Configuration Parameters
	static String DB_USERNAME = "root", DB_PASSWORD = "", DB_URL = "jdbc:mysql://localhost:3306/fileDb";

	private static SimpleDriverDataSource getDatabaseConnection()  {
		dataSourceObj = new SimpleDriverDataSource();
		try {			
			dataSourceObj.setDriver(new com.mysql.jdbc.Driver());
			dataSourceObj.setUrl(DB_URL);
			dataSourceObj.setUsername(DB_USERNAME);
			dataSourceObj.setPassword(DB_PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return dataSourceObj;
	}

	// This Method Is Used To Save The Uploaded File In The Database
	public static void fileSaveInDb(FileUpload fileUploadObj) {

		// This Code Is Used To Set Driver Class Name, Database URL, Username & Password
		jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());

		if(null != jdbcTemplateObj) {

			// Performing The Sql 'Insert' Operation
			String sqlInsertQuery = "INSERT INTO files_upload (file_name, file_description, file_data) VALUES (?, ?, ?)";
			int insertCount = jdbcTemplateObj.update(sqlInsertQuery, fileUploadObj.getFileName(), fileUploadObj.getFileDescription(), fileUploadObj.getData());
			if(insertCount == 1) {
				System.out.println("The Uploaded File Is Successfully Saved In The Database...!" + "\n");
			} else {
				System.out.println("Error Occured While Saving The Uploaded File In The Database... Please Check...!" + "\n");
			}
		} else {
			System.out.print("Application Is Not Able To Bind With The Database! Please Check!");
		}
	}
}