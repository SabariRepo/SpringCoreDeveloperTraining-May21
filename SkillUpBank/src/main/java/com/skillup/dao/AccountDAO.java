package com.skillup.dao;

import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
