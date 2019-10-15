package br.com.codenation.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.entity.Log;
import br.com.codenation.service.LogServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LogController {

	@Autowired
	private LogServiceImpl logServiceImpl;

	@PostMapping("/logs")
	@ApiOperation("create a new log")
	@ResponseBody
	public Log create(@RequestBody Log log) {
		return this.logServiceImpl.create(log);
	}

	@GetMapping("/logs/level")
	@ApiOperation("?e=&o=&q=&a=")
	@ResponseBody
	public Page<Log> filterByLevel(
			@ApiParam("producao; homologacao; dev")
			@RequestParam("e") String environment, 
			@ApiParam("level; frequence")
			@RequestParam("o") String order,
			@ApiParam("search term")
			@RequestParam("q") String search,
			@ApiParam("true; false")
			@RequestParam("a") boolean archived,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return logServiceImpl.filterByLevel(environment, order, search, archived, page, size);
	}
	
	@GetMapping("/logs/description")
	@ApiOperation("?e=&o=&q=&a=")
	@ResponseBody
	public Page<Log> filterByDescription(
			@ApiParam("producao; homologacao; dev")
			@RequestParam("e") String environment, 
			@ApiParam("level; frequence")
			@RequestParam("o") String order,
			@ApiParam("search term")
			@RequestParam("q") String search,
			@ApiParam("true; false")
			@RequestParam("a") boolean archived,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return logServiceImpl.filterByDescription(environment, order, search, archived, page, size);
	}
	
	@GetMapping("/logs/source")
	@ApiOperation("?e=&o=&q=&a=")
	@ResponseBody
	public Page<Log> filterBySource(
			@ApiParam("producao; homologacao; dev")
			@RequestParam("e") String environment, 
			@ApiParam("level; frequence")
			@RequestParam("o") String order,
			@ApiParam("search term")
			@RequestParam("q") String search,
			@ApiParam("true; false")
			@RequestParam("a") boolean archived,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return logServiceImpl.filterBySource(environment, order, search, archived, page, size);
	}
	
	@DeleteMapping("/logs/{id}")
	@ApiOperation("log delete by id")
	public boolean delete(@PathVariable(value = "id") Long id) {
		return this.logServiceImpl.delete(id);
	}
	
	@PutMapping("/logs/{id}")
	@ApiOperation("set archived to true")
	public boolean arquived(@PathVariable("id") Long id) {
		return this.logServiceImpl.arquived(id);

	}

}
