package br.com.codenation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.codenation.entity.Log;
import br.com.codenation.repository.LogRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

	@Override
	public Log create(Log log) {
		return logRepository.save(log);
	}

	@Override
	public boolean delete(Long id) {
		Log log = this.logRepository.findById(id).get();

		if (log != null) {
			this.logRepository.delete(log);
			return true;
		}
		return false;
	}

	@Override
	public boolean arquived(Long id) {
		Log log = this.logRepository.findById(id).get();

		if (log != null) {
			log.setArchived(true);
			this.logRepository.save(log);
			return true;
		}
		return false;
	}

	@Override
	public Page<Log> filterByLevel(String environment, String order, String search, boolean archived, int page,
			int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, order);

		return logRepository.filterByLevel(environment.toLowerCase(), search.toLowerCase(), archived, pageRequest);
	}

	@Override
	public Page<Log> filterByDescription(String environment, String order, String search, boolean archived, int page,
			int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, order);

		return logRepository.filterByDescription(environment.toLowerCase(), search.toLowerCase(), archived,
				pageRequest);
	}

	@Override
	public Page<Log> filterBySource(String environment, String order, String search, boolean archived, int page,
			int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, order);

		return logRepository.filterBySource(environment.toLowerCase(), search.toLowerCase(), archived, pageRequest);
	}

}
