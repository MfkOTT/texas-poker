package com.redis.coo.func;

import java.util.List;

/**
 * 封装redis集合scan操作的结果数据
 * 
 * @author maoyl05
 * @param <T>
 *
 */
public class RedisScanResult<T> {
	private List<T> results;
	private int cursor;
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public int getCursor() {
		return cursor;
	}
	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
}
