package org.rex.db.listener;

import java.util.Arrays;

import javax.sql.DataSource;

import org.rex.db.dialect.LimitHandler;
import org.rex.db.util.ConstantUtil;

/**
 * 包装SQL、预编译参数、数据源等，方便监听程序调用
 */
public class SqlContext extends BaseContext{
	
	/** 
	 * 用于读取常量 
	 */
	private static final ConstantUtil constants = new ConstantUtil(SqlContext.class);
	
	/**
	 * 执行的SQL类型：查询
	 */
	public static final int SQL_QUERY = 1;
	
	/**
	 * 执行的SQL类型：更新
	 */
	public static final int SQL_UPDATE = 2;
	
	/**
	 * 执行的SQL类型：批处理
	 */
	public static final int SQL_BATCH_UPDATE = 3;
	
	/**
	 * 执行的SQL类型：调用
	 */
	public static final int SQL_CALL = 4;
	
	private int sqlType;
	
	private boolean betweenTransaction;
	
	private DataSource dataSource;
	
	private String[] sql;
	
	private Object parameters;
	
	private LimitHandler limitHandler;
	
	public SqlContext(int sqlType, boolean betweenTransaction, DataSource dataSource, String[] sql, Object parameters, LimitHandler limitHandler){
		super();
		this.sqlType = sqlType;
		this.betweenTransaction = betweenTransaction;
		this.dataSource = dataSource;
		this.sql = sql;
		this.parameters = parameters;
		this.limitHandler = limitHandler;
	}

	public int getSqlType() {
		return sqlType;
	}

	public boolean isBetweenTransaction() {
		return betweenTransaction;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public String[] getSql() {
		return sql;
	}

	public Object getParameters() {
		return parameters;
	}
	
	public LimitHandler getLimitHandler() {
		return limitHandler;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("sqlType=")
			.append(constants.toCode(new Integer(sqlType), "SQL"))
			.append(", betweenTransaction=")
			.append(betweenTransaction)
			.append(", dataSource=")
			.append(dataSource)
			.append(", sql=")
			.append(Arrays.toString(sql))
			.append(", parameters=")
			.append(parameters);
		
		return sb.toString();
	}
	
}
