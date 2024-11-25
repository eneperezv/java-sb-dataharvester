package com.enp.dataharvester.api.controller;

/*
 * @(#)UserController.java 1.0 24/11/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.dataharvester.api.dto.UserDto;
import com.enp.dataharvester.api.entity.ErrorDetails;
import com.enp.dataharvester.api.entity.ResponseDetails;
import com.enp.dataharvester.api.service.UserService;

@RestController
@RequestMapping("/api/v1/dataharvester/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseDetails<?> createUser(@RequestBody UserDto userDto){
		UserDto savedUserDto;
		try{
			savedUserDto = userService.createUser(userDto);
			if(savedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+savedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(savedUserDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseDetails<?> getUser(@PathVariable Long id){
		UserDto userDto;
		try {
			userDto = userService.findById(id);
			if(userDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+userDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(userDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseDetails<?> updateUser(@RequestBody UserDto userDto){
		UserDto searchedUserDto;
		UserDto savedUserDto;
		try {
			searchedUserDto = userService.findById(userDto.getId());
			if(searchedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+searchedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			savedUserDto = userService.updateUser(userDto);
			if(savedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+savedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(savedUserDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
