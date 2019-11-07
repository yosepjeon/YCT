package io.yosep.agile.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="user-rest-controller!!", description="swagger-user-rest")
@RequestMapping(value="/user")
public class RestUserController {
	@RequestMapping(value="/hello/{name}", method= {RequestMethod.GET,RequestMethod.POST})
	public String getHelloName(@PathVariable(value="name") String name) {
		return "Hello " + name;
	}
}
