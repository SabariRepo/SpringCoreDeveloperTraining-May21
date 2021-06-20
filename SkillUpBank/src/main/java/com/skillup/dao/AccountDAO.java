package com.skillup.dao;

import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.skillup.model.Account;
import com.skillup.util.AccountIDNotFoundException;

@Repository
public class AccountDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRowMapper accountRowMapper;

	public boolean addAccount(Account account) {
		boolean result = false;
		int noOfRows = 0;
		try {
			noOfRows = jdbcTemplate.update("insert into account values(?,?,?)",
					new Object[] { account.getAccountId(), account.getAccountName(), account.getAccountBalance() });
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		if (noOfRows > 0)
			result = true;

		return result;
	}

	public Account findByAccountId(int accountId)throws AccountIDNotFoundException {
		Account account = null;
		try {
			account = jdbcTemplate.queryForObject("select * from account where accountid=?", new Object[] { accountId },
					new int[] { Types.INTEGER }, accountRowMapper);
		} catch (DataAccessException exception) {
				throw new AccountIDNotFoundException("Hi The Given Account Id"+accountId+"Does Not Exists");
		}
		return account;
	}
	
	public List<Account> findAllAccountDetails(){
		return jdbcTemplate.query("select * from account", accountRowMapper);
	}
	
	//Batch Update
	public void accountBatchUpdate() {
		
		List<Object[]> listOfData = new ArrayList<>();
		
		listOfData.add(new Object[] {9001,"Ajay",3.4f});
		listOfData.add(new Object[] {9002,"Raj",4.4f});
		listOfData.add(new Object[] {9003,"Dev",6.4f});
		
		jdbcTemplate.batchUpdate("insert into account values(?,?,?)",listOfData);
	}
	
	//Procedure Call
	public void callgetAccountProc() {
		
		//This SimpleJdbcCall class is meant for calling procedure from
		//the DB
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		
		//1. Setting the procedure name
		simpleJdbcCall.setProcedureName("getAccountdetails");
		
		//2. Setting the in parameter for the Stored Procedure
		SqlParameterSource in = new MapSqlParameterSource().addValue("accid", 9002);
		
		//3. Setting for the retrieval of out parameters;
		
		Map mapOut =  simpleJdbcCall.execute(in);
		
		System.out.println(mapOut);
	}
}
