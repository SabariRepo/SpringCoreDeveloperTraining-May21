package com.skillup.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.skillup.model.Account;

@Component
public class AccountRowMapper implements RowMapper<Account> {

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Account account = new Account();
			account.setAccountId(rs.getInt("accountid"));
			account.setAccountName(rs.getString("name"));
			account.setAccountBalance(rs.getFloat("balance"));
			return account;
		}
		
	
}
