package br.com.codenation.service;

import org.springframework.data.domain.Page;

import br.com.codenation.entity.Log;

public interface LogService {

	public Log create(Log log);
	public Page<Log> filterByLevel(String environment, String order, String search, boolean archived, int page, int size);
	public Page<Log> filterByDescription(String environment, String order, String search, boolean archived, int page, int size);
	public Page<Log> filterBySource(String environment, String order, String search, boolean archived, int page, int size);
	public boolean delete(Long id);
	public boolean arquived(Long id);

}
